package mailServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import linkedList.SingleLinkedList;
import queue.IQueue;
import queue.linkedBasedQueue;

public class mail implements IMail{
    private Date date;
    private String sender;
    private IQueue receiver;
    private SingleLinkedList attachment;
    private String textBody;
    private String subject;
    private int priority;
    private int id;

    public mail(){
        this.priority = 0;
        setId(0);
        date=null;
        sender=null;
        receiver=new linkedBasedQueue();
        attachment=new SingleLinkedList();
        textBody=null;
        subject=null;
    }
    /**
     * set the date of the mail
     * @param date the new date
     */
    public void setDate(Date date)
    {
        this.date=date;
    }
    /**
     * set the sender of the mail
     * @param sender the new sender
     */
    public void setSender(String sender){
        folder folder= new folder();
        if(!folder.checkExistUsername(sender)){
            throw new RuntimeException("email is not found");
        }
        this.sender=sender;
    }
    /**
     * set the receiver of the mail (enqueue it to the queue of the receiver of mail)
     * @param receiver
     */
    public void setReceiver(String receiver){
        folder folder= new folder();
        if(!folder.checkExistUsername(receiver)){
            throw new RuntimeException("email is not found");
        }
        this.receiver.enqueue(receiver);
    }
    /**
     * set the attachment of the mail (add it to the linked list of the attachments)
     * @param file the new attachment
     */
    public void setAttachment(File file){

        attachment.add(file);
    }
    /**
     * set the text body of the mail
     * @param text the new text
     */
    public void setTextBody(String text){
        textBody=text;
    }
    /**
     * get the date of the mail
     * @return the date of the mail
     */
    public Date getDate(){
        return this.date;
    }
    /**
     * get the sender of the mail
     * @return the sender of the mail
     */
    public String getSender(){
        return this.sender;
    }
    /**
     * get the text body of the mail
     * @return the text body of the mail
     */
    public String getTextBody(){
        return this.textBody;
    }
    /**
     * get the queue of the the receivers of the mail
     * @return the queue of the the receivers of the mail
     */
    public IQueue getReceiver(){
        return this.receiver;
    }
    /**
     * get the linked list of the attachment of the mail
     * @return the linked list of the attachment of the mail
     */
    public  SingleLinkedList getAttachment(){
        return attachment;
    }
    /**
     * get the subject of the mail
     * @return the subject of the mail
     */
    public String getSubject() {
        return subject;
    }
    /**
     * set the subject of the mail
     * @param subject the new subject of the mail
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * get the priority of the mail
     * @return the priority of the mail
     */
    public int getPriority() {
        return priority;
    }
    /**
     * set the priority of the mail
     * @param priority the new priority of the mail
     */
    public void setPriority(int priority) {
        if(priority<0 || priority>10){
            throw new RuntimeException("priority is not allowed");
        }
        this.priority = priority;
    }
    /**
     * get the id of the mail
     * @return the idd of the mail
     */
    public int getId() {
		return id;
	}
    /**
     * set the id of the mail
     * @param id the new id
     */
	public void setId(int id) {
		this.id = id;
	}
    /**
     * make the draft folder
     * @throws IOException if the file was null
     */
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
        fw.write(line);
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
    /**
     * make the send folder
     * @throws IOException if the file was null
     */
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
        writer.write(getSender());
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
        fw.write(line);
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
            writer1.write(temp);
            writer1.newLine();
            writer.write(line);
            writer.newLine();
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
    /**
     * check the validity of the mail
     * @return false if the mail is not available or return true
     */
  public  boolean checkMail(){
        if(getSender().equals("") ||getSubject().equals("")){
            return false;
        }
        String temp=getReceiver().dequeue().toString();
        if(temp.equals(""))
        	return false;
        getReceiver().enqueue(temp);
        
        return true;
  }
}