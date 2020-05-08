package mailServer;

import linkedList.doubleLinkedList;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public interface IFilter {
    /**
     * get the type of the sorting
     * @return type of the sorting
     */
    public String getType();
    /**
     * set the type of the sorting
     * @param type
     */
    public void setType(String type);
    /**
     * @param mails the double linked list of the e_mails to be sort
     * it set the double linked list of the e_mails
     */
    public void setMails(doubleLinkedList mails);
    /**
     * @return the double linked list of the e_mails which we want it to be sorted
     */
    public doubleLinkedList getMails();
    /**
     * get the date
     * @return the date
     */
    public Date getDate();
    /**
     * set the date
     * @param d
     */
    public void setDate(Date d);
    /**
     * set the subject
     * @param subject
     */
    public void setSubject(String subject);
    /**
     * get the subject
     * @return the subject
     */
    public String getSubject();
    /**
     * set the receiver
     * @param receiver
     */
    public void setReceiver(String receiver);
    /**
     * get the receiver
     * @return the receiver
     */
    public String getReceiver();
    /**
     * set the sender
     * @param sender
     */
    public void setSender(String sender);
    /**
     * get the sender
     * @return the sender
     */
    public String getSender();
    /**
     * set the priority
     * @param priority
     */
    public void setPriority(int priority);
    /**
     * get the priority
     * @return the priority
     */
    public int getPriority();
    /**
     * set the numOfReceivers
     * @param numOfReceivers
     */
    public void setNumOfReceivers(int numOfReceivers);
    /**
     * get the numOfReceivers
     * @return numOfReceivers
     */
    public int getNumOfReceivers();
    /**
     * set the numOfAttachments
     * @param numOfAttachments
     */
    public void setNumOfAttachments(int numOfAttachments);
    /**
     * get the numOfAttachments
     * @return numOfAttachments
     */
    public int getNumOfAttachments();
    /**
     * set the numOfLinesInBody
     * @param numOfLinesInBody
     */
    public void setNumOfLinesInBody(int numOfLinesInBody);
    /**
     * get the numOfLinesInBody
     * @return numOfLinesInBody
     */
    public int getNumOfLinesInBody();
    /**
     * set the numOfWordsInBody
     * @param numOfWordsInBody
     */
    public void setNumOfWordsInBody(int numOfWordsInBody);
    /**
     * get the numOfWordsInBody
     * @return numOfWordsInBody
     */
    public int getNumOfWordsInBody();
    /**
     * set the numOfLettersInBody
     * @param numOfLettersInBody
     */
    public void setNumOfLettersInBody(int numOfLettersInBody);
    /**
     * get the numOfLettersInBody
     * @return numOfLettersInBody
     */
    public int getNumOfLettersInBody();
    /**
     * @param x is the Date(complete) that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Date
     */
    public doubleLinkedList filterByCompleteDate(Date x) throws IOException, ParseException;
    /**
     * @param x is the Date(Day) that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Date
     */
    public doubleLinkedList filterByDayOfDate(Date x) throws IOException, ParseException;
    
    /**
     * @param x is the Subject that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Subject
     */
    public doubleLinkedList filterBySubject(String x) throws IOException, ParseException;
    /**
     * @param x is the Sender that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Sender
     */
    public doubleLinkedList filterBySender(String x) throws IOException, ParseException;
    /**
     * @param x is the Priority that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Priority
     */
    public doubleLinkedList filterByPriority(int x) throws IOException, ParseException;
    /**
     * @param x is the Num Of Receivers that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Receivers
     */
    public doubleLinkedList filterByNumOfReceivers(int x) throws IOException, ParseException;
    /**
     * @param x is the Receiver that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that seme Receiver x
     */
    public doubleLinkedList filterByReceiver(String x) throws IOException, ParseException;
    /**
     * @param x is the Num Of Attachments that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Attachments
     */
    public doubleLinkedList filterByNumOfAttachments(int x) throws IOException, ParseException;
    /**
     * @param x is the Num Of Lines In Body that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Lines In Body
     */
    public doubleLinkedList filterByNumOfLinesInBody(int x) throws IOException, ParseException;
    /**
     * @param x is the Num Of Words In Body that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Words In Body
     */
    public doubleLinkedList filterByNumOfWordsInBody(int x) throws IOException, ParseException;
    /**
     * @param x is the Num Of Letters In Body that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Letters In Body
     */
    public doubleLinkedList filterByNumOfLettersInBody(int x) throws IOException, ParseException;
    /**
     * @param x is the Subject that we to filter the contacts with
     * @return Returns double Linked List Of the contacts with that Subject
     */
    public doubleLinkedList filterContactByName(String x) throws IOException, ParseException;
}
