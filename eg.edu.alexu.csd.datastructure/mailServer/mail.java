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
        File file10=new File("System/num.txt");
        FileReader x = new FileReader(file10);
        BufferedReader in=new BufferedReader(x);
        String line=in.readLine();
        in.close();
        int num = Integer.parseInt(line);
        num++;
        FileWriter x1=new FileWriter(file10);
        x1.write(Integer.toString(num));
        x1.flush();
        x1.close();


        File indexSent= new File("System/" + getSender() + "/Draft/index.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(indexSent.getPath(), true) );
        writer.write(getDate().toString());
        writer.newLine();
        writer.write(getSubject());
        writer.newLine();
        writer.write(getSender());
        writer.newLine();
        
        
        File file = new File("System/" + getSender() + "/Draft/" + line);
        file.mkdir();
        File file1 = new File("System/" + getSender() + "/Draft/" + line + "/" + getSubject() + ".txt");
        FileWriter fr = new FileWriter(file1);
        fr.write(getTextBody());
        fr.write("\r\n");
        fr.flush();
        fr.close();

        folder folder=new folder();
        File file6=new File("System/" + getSender() + "/Draft/" + line + "/attachments");
        file6.mkdir();

        for (int i = 0; i < getAttachment().size(); i++) {
            File f2=new File(getAttachment().get(i).toString());
            File f1=new File(file6.getPath()+"/"+f2.getName());

            folder.copyFileUsingChannel(f2,f1);
        }

        File file2 = new File("System/" + getSender() + "/Draft/" + line + "/index.txt");
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

        File file8=new File("System/" + getSender() +"/Draft/" +line +"/receivers.txt");
        FileWriter n=new FileWriter(file8);
        while (!receiver.isEmpty()) {
            String temp = getReceiver().dequeue().toString();
            n.write(temp);
            n.write("\r\n");
            writer.write(temp);
            if(!receiver.isEmpty())
                writer.write(",");
        }
        writer.newLine();
        writer.close();
        n.flush();
        n.close();
    }

    public void send() throws IOException {
        File file10=new File("System/num.txt");
        FileReader x = new FileReader(file10);
        BufferedReader in=new BufferedReader(x);
        String line=in.readLine();
        in.close();
        int num = Integer.parseInt(line);
        num++;
        FileWriter x1=new FileWriter(file10);
        x1.write(Integer.toString(num));
        x1.flush();
        x1.close();

        File indexSent= new File("System/" + getSender() + "/Sent/index.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(indexSent.getPath(), true) );
        writer.write(getDate().toString());
        writer.newLine();
        writer.write(getSubject());
        writer.newLine();


        File file = new File("System/" + getSender() + "/Sent/" + line);
        file.mkdir();

        File file1 = new File("System/" + getSender() + "/Sent/" + line + "/" + getSubject() + ".txt");
        FileWriter fr = new FileWriter(file1);
        fr.write(getTextBody());
        fr.write("\r\n");
        fr.flush();
        fr.close();

        folder folder=new folder();
        File file6=new File("System/" + getSender() + "/Sent/" + line + "/attachments");
        file6.mkdir();

        for (int i = 0; i < getAttachment().size(); i++) {
            File f2=new File(getAttachment().get(i).toString());
            File f1=new File(file6.getPath()+"/"+f2.getName());

            folder.copyFileUsingChannel(f2,f1);
        }

        File file2 = new File("System/" + getSender() + "/Sent/" + line + "/index.txt");
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

        File file8=new File("System/" + getSender() +"/Sent/" + line +"/receivers.txt");
        FileWriter n=new FileWriter(file8);
        while (!receiver.isEmpty()) {
            String temp = getReceiver().dequeue().toString();
            File file3 = new File("System/" + temp + "/Inbox/" + line);
            file3.mkdir();
            File file4 = new File("System/" + temp + "/Inbox/" +line + "/receivers.txt");
            FileWriter f = new FileWriter(file4);
            f.write(temp);
            f.write("\r\n");
            f.flush();
            f.close();
            File file5 = new File("System/" + temp + "/Inbox/" + line +"/"+ getSubject() +".txt");
            folder.copyFileUsingChannel(file1,file5);
           File file7=new File("System/" + temp + "/Inbox/" + line+"/attachments");
           file7.mkdir();
            for (int i = 0; i < getAttachment().size(); i++) {
                File f2=new File(getAttachment().get(i).toString());
                File f1=new File(file7.getPath()+"/"+f2.getName());

                folder.copyFileUsingChannel(f2,f1);
            }
            File file9 = new File("System/" + temp + "/Inbox/" + line + "/index.txt");
            folder.copyFileUsingChannel(file2,file9);
            n.write(temp);
            n.write("\r\n");

            File indexInbox= new File("System/" + temp + "/Inbox/index.txt");
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(indexInbox.getPath(), true) );
            writer1.write(getDate().toString());
            writer1.newLine();
            writer1.write(getSubject());
            writer1.newLine();
            writer1.write(getSender());
            writer1.newLine();
            writer1.close();
            writer.write(temp);
            if(!receiver.isEmpty())
                writer.write(",");

        }
        writer.newLine();
        writer.close();
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
