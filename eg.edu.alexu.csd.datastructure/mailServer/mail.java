package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.SingleLinkedList;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.linkedBasedQueue;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Date;

public class mail {
    private Date date;
    private String sender;
    private IQueue receiver;
    private SingleLinkedList attachment;
    private String textBody;
    private String subject;
    private int priority;

    public mail(){
        this.priority = 0;
        date=null;
        sender=null;
        receiver=new linkedBasedQueue();
        attachment=new SingleLinkedList();
        textBody=null;
        subject=null;
    }
    public void setDate(){
        this.date=new Date();
    }
    public void setSender(String sender){
        folder folder= new folder();
        if(!folder.check_exist_username(sender)){
            throw new RuntimeException("email is not found");
        }
        this.sender=sender;
    }
    public void setReceiver(String receiver){
        folder folder= new folder();
        if(!folder.check_exist_username(receiver)){
            throw new RuntimeException("email is not found");
        }
        this.receiver.enqueue(receiver);
    }
    public void setAttachment(File file){
        attachment.add(file);
    }
    public void setTextBody(String text){
        textBody=text;
    }
    public Date getDate(){
        return this.date;
    }
    public String getSender(){
        return this.sender;
    }
    public String getTextBody(){
        return this.textBody;
    }
    public IQueue getReceiver(){
        return this.receiver;
    }
    public  SingleLinkedList getAttachment(){
        return attachment;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if(priority<0 || priority>10){
            throw new RuntimeException("priority is not allowed");
        }
        this.priority = priority;
    }


    public void draft() throws IOException {
        File file = new File("System/" + getSender() + "/drafts/" + getSubject());
        file.mkdir();
        File file1 = new File("System/" + getSender() + "/drafts/" + getSubject() + "/" + getSubject() + ".txt");
        FileWriter fr = new FileWriter(file1);
        fr.write(getTextBody());
        fr.write("\r\n");
        fr.flush();
        fr.close();

        folder folder=new folder();
        File file6=new File("System/" + getSender() + "/drafts/" + getSubject() + "/attachments");
        file6.mkdir();

        for (int i = 0; i < getAttachment().size(); i++) {
            File f2=new File(getAttachment().get(i).toString());
            File f1=new File(file6.getPath()+"/"+f2.getName());

            folder.copyFileUsingChannel(f2,f1);
        }

        File file2 = new File("System/" + getSender() + "/drafts/" + getSubject() + "/index.txt");
        FileWriter fw = new FileWriter(file2);
        fw.write(getDate().toString());
        fw.write("\r\n");   // write new line
        fw.write(getSubject());
        fw.write("\r\n");
        fw.write(getSender());
        fw.write("\r\n");
        fw.write(Integer.toString(getPriority()));
        fw.write("\r\n");
        fw.flush();
        fw.close();

        File file8=new File("System/" + getSender() +"/drafts/" + getSubject() +"/receivers.txt");
        FileWriter n=new FileWriter(file8);
        while (!receiver.isEmpty()) {
            String temp = getReceiver().dequeue().toString();
            n.write(temp);
            n.write("\r\n");
        }
        n.flush();
        n.close();
    }



    public void send() throws IOException {
        File file = new File("System/" + getSender() + "/sent/" + getSubject());
        file.mkdir();

        File file1 = new File("System/" + getSender() + "/sent/" + getSubject() + "/" + getSubject() + ".txt");
        FileWriter fr = new FileWriter(file1);
        fr.write(getTextBody());
        fr.write("\r\n");
        fr.flush();
        fr.close();

        folder folder=new folder();
        File file6=new File("System/" + getSender() + "/sent/" + getSubject() + "/attachments");
        file6.mkdir();

        for (int i = 0; i < getAttachment().size(); i++) {
            File f2=new File(getAttachment().get(i).toString());
            File f1=new File(file6.getPath()+"/"+f2.getName());

            folder.copyFileUsingChannel(f2,f1);
        }

        File file2 = new File("System/" + getSender() + "/sent/" + getSubject() + "/index.txt");
        FileWriter fw = new FileWriter(file2);
        fw.write(getDate().toString());
        fw.write("\r\n");   // write new line
        fw.write(getSubject());
        fw.write("\r\n");
        fw.write(getSender());
        fw.write("\r\n");
        fw.write(Integer.toString(getPriority()));
        fw.write("\r\n");
        fw.flush();
        fw.close();

        File file8=new File("System/" + getSender() +"/sent/" + getSubject() +"/receivers.txt");
        FileWriter n=new FileWriter(file8);
        while (!receiver.isEmpty()) {
            String temp = getReceiver().dequeue().toString();
            File file3 = new File("System/" + temp + "/inbox/" + getSubject());
            file3.mkdir();
            File file4 = new File("System/" + temp + "/inbox/" + getSubject() + "/receivers.txt");
            FileWriter f = new FileWriter(file4);
            f.write(temp);
            f.write("\r\n");
            f.flush();
            f.close();
            File file5 = new File("System/" + temp + "/inbox/" + getSubject() +"/"+ getSubject() +".txt");
            folder.copyFileUsingChannel(file1,file5);
           File file7=new File("System/" + temp + "/inbox/" + getSubject()+"/attachments");
           file7.mkdir();
            for (int i = 0; i < getAttachment().size(); i++) {
                File f2=new File(getAttachment().get(i).toString());
                File f1=new File(file7.getPath()+"/"+f2.getName());

                folder.copyFileUsingChannel(f2,f1);
            }
            File file9 = new File("System/" + temp + "/inbox/" + getSubject() + "/index.txt");
            folder.copyFileUsingChannel(file2,file9);
            n.write(temp);
            n.write("\r\n");
        }
        n.flush();
        n.close();

    }

    public  boolean checkMail(){
        if(getSender()==null ||getSubject()==null || getReceiver()==null||getTextBody()==null){
            return false;
        }
        return true;
    }



}
