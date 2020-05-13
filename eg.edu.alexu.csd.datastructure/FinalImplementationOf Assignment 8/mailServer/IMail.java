package mailServer;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import linkedList.SingleLinkedList;
import queue.IQueue;

public interface IMail {
    /**
     * set the date of the mail
     * @param date the new date
     */
    public void setDate(Date date);
    /**
     * set the sender of the mail
     * @param sender the new sender
     */
    public void setSender(String sender);
    /**
     * set the receiver of the mail (enqueue it to the queue of the receiver of mail)
     * @param receiver
     */
    public void setReceiver(String receiver);
    /**
     * set the attachment of the mail (add it to the linked list of the attachments)
     * @param file the new attachment
     */
    public void setAttachment(File file);
    /**
     * set the text body of the mail
     * @param text the new text
     */
    public void setTextBody(String text);
    /**
     * set the id of the mail
     * @param id the new id
     */
	public void setId(int id) ;	
	/**
     * get the date of the mail
     * @return the date of the mail
     */
    public Date getDate();
    /**
     * get the sender of the mail
     * @return the sender of the mail
     */
    public String getSender();
    /**
     * get the text body of the mail
     * @return the text body of the mail
     */
    public String getTextBody();
    /**
     * get the queue of the the receivers of the mail
     * @return the queue of the the receivers of the mail
     */
    public IQueue getReceiver();
    /**
     * get the linked list of the attachment of the mail
     * @return the linked list of the attachment of the mail
     */
    public SingleLinkedList getAttachment();
    /**
     * get the subject of the mail
     * @return the subject of the mail
     */
    public String getSubject();
    /**
     * get the id of the mail
     * @return the idd of the mail
     */
    public int getId() ;
    /**
     * set the subject of the mail
     * @param subject the new subject of the mail
     */
    public void setSubject(String subject);
    /**
     * get the priority of the mail
     * @return the priority of the mail
     */
    public int getPriority();
    /**
     * set the priority of the mail
     * @param priority the new priority of the mail
     */
    public void setPriority(int priority);
    /**
     * make the draft folder
     * @throws IOException if the file was null
     */
    public void draft() throws IOException;
    /**
     * make the send folder
     * @throws IOException if the file was null
     */
    public void send() throws IOException;
    /**
     * check the validity of the mail
     * @return false if the mail is not available or return true
     */
    public  boolean checkMail();
}