package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.doubleLinkedList;

import java.io.IOException;
import java.text.ParseException;

public interface ISort {
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
     * it sort the double linked list by the date of each e_main(Newest To Oldest)
     * @return a sorted double linked list of folders of e_mails by date(Newest To Oldest)
     */
    public doubleLinkedList sortByDateOldestToNewest() throws ParseException, IOException ;
    /**
     * it sort the double linked list by the date of each e_main(Oldest To Newest)
     * @return a sorted double linked list of folders of e_mails by date(Oldest To Newest)
     */
    public doubleLinkedList sortByDateNewestToOldest() throws ParseException, IOException;
    /**
     * it sort the double linked list by the name of subject of each e_main
     * @return a sorted double linked list of folders of e_mails by the name of subject
     */
    public doubleLinkedList sortAscendingBySubject() throws ParseException, IOException;
    /**
     * it sort the double linked list Descending by the name of subject of each e_main
     * @return a sorted double linked list of folders of e_mails by the name of subject(Descending)
     */
    public doubleLinkedList sortDescendingBySubject() throws ParseException, IOException;
    /**
     * it sort the double linked list by the name of Sender of each e_main
     * @return a sorted double linked list of folders of e_mails by the name of Sender
     */
    public doubleLinkedList sortAscendingBySender() throws ParseException, IOException;
    /**
     * it sort the double linked list Descending by the name of Sender of each e_main
     * @return a sorted double linked list of folders of e_mails by the name of Sender(Descending)
     */
    public doubleLinkedList sortDescendingBySender() throws ParseException, IOException;
    /**
     * it sort the double linked list by its priority(degree of importance) of subject of each e_main
     * @return a sorted double linked list of folders of e_mails by the its priority(degree of importance)
     */
    public doubleLinkedList sortAscendingByPriority() throws ParseException, IOException;
    /**
     * it sort the double linked list Descending by its priority(degree of importance) of subject of each e_main
     * @return a sorted double linked list of folders of e_mails by the its priority(degree of importance)(Descending)
     */
    public doubleLinkedList sortDescendingByPriority() throws ParseException, IOException;
    /**
     * it sort the double linked list by its Num Of Lines In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Lines In Body
     */
    public doubleLinkedList sortAscendingByNumOfLinesInBody() throws ParseException, IOException;
    /**
     * it sort Descending the double linked list by its Num Of Lines In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Lines In Body(Descending)
     */
    public doubleLinkedList sortDescendingByNumOfLinesInBody() throws ParseException, IOException;
    /**
     * it sort the double linked list by its Num Of Words In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Words In Body
     */
    public doubleLinkedList sortAscendingByNumOfWordsInBody() throws ParseException, IOException;
    /**
     * it sort Descending the double linked list by its Num Of Words In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Words In Body (Descending)
     */
    public doubleLinkedList sortDescendingByNumOfWordsInBody() throws ParseException, IOException;
    /**
     * it sort the double linked list by its Num Of Letters In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by its Num Of Letters In Body
     */
    public doubleLinkedList sortAscendingByNumOfLettersInBody() throws ParseException, IOException;
    /**
     * it sort Descending the double linked list by its Num Of Letters In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by its Num Of Letters In Body Descending
     */
    public doubleLinkedList sortDescendingByNumOfLettersInBody() throws ParseException, IOException;
    /**
     * it sort the double linked list by its Num Of Receivers of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Receivers
     */
    public doubleLinkedList sortAscendingByNumOfReceivers() throws ParseException, IOException;
    /**
     * it sort Descending the double linked list by its Num Of Receivers of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Receivers(Descending)
     */
    public doubleLinkedList sortDescendingByNumOfReceivers() throws ParseException, IOException;
    /**
     * it sort the double linked list by its Num Of Lines In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Lines In Body
     */
    public doubleLinkedList sortAscendingByNumOfAttachments() throws ParseException, IOException;
    /**
     * it sort Descending the double linked list by its Num Of Attachments of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Attachments(Descending)
     */
    public doubleLinkedList sortDescendingByNumOfAttachments() throws ParseException, IOException;
}
