package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.doubleLinkedList;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public interface IFilter {
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
     * @param x is the Date that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Date
     */
    public doubleLinkedList filterByDate(Date x) throws IOException, ParseException;
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
}
