package mailServer;

import linkedList.doubleLinkedList;
import stacks.Stack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class filter implements IFilter{
  
	/**
     * filterByDate or filterBySubject or filterBySender or filterByPriority
     * or filterByNumOfReceivers or filterByNumOfAttachments or filterByNumOfLinesInBody
     * or filterByNumOfWordsInBody or filterByNumOfLettersInBody
     */
    private String type="";
    /**
     * get the type of the sorting
     * @return type of the sorting
     */
    @Override
    public String getType() {
        return type;
    }
    /**
     * set the type of the sorting
     * @param type
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }
    private doubleLinkedList e = new doubleLinkedList();
    /**
     * @param mails the double linked list of the e_mails to be sort
     * it set the double linked list of the e_mails
     */
    @Override
    public void setMails(doubleLinkedList mails){
        if(mails!=null&&!mails.isEmpty()) {
            e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
        }
        else if(mails.isEmpty()){
            e=new doubleLinkedList();
        }
        else{
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @return the double linked list of the e_mails which we want it to be sorted
     */
    @Override
    public doubleLinkedList getMails(){
        return e;
    }
    private Date d;
    /**
     * set the date
     * @param d
     */
    @Override
    public void setDate(Date d) {
        this.d = d;
    }
    /**
     * get the date
     * @return the date
     */
    @Override
    public Date getDate() {
        return d;
    }
    private String subject;
    /**
     * set the subject
     * @param subject
     */
    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * get the Subject
     * @return the Subject
     */
    @Override
    /**
     * return the subject
     */
    public String getSubject() {
        return subject;
    }
    private String receiver;
    /**
     * set the receiver
     * @param receiver
     */
    @Override
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    /**
     * get the receiver
     * @return the receiver
     */
    @Override
    public String getReceiver() {
        return receiver;
    }
    private String sender;
    /**
     * set the sender
     * @param sender
     */
    @Override
    public void setSender(String sender) {
        this.sender = sender;
    }
    /**
     * get the sender
     * @return the sender
     */
    @Override
    public String getSender() {
        return sender;
    }
    private int priority;
    /**
     * set the priority
     * @param priority
     */
    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }
    /**
     * get the priority
     * @return the priority
     */
    @Override
    public int getPriority() {
        return priority;
    }
    private int numOfReceivers;
    /**
     * set the numOfReceivers
     * @param numOfReceivers
     */
    @Override
    public void setNumOfReceivers(int numOfReceivers) {
        this.numOfReceivers = numOfReceivers;
    }
    /**
     * get the numOfReceivers
     * @return numOfReceivers
     */
    @Override
    public int getNumOfReceivers() {
        return numOfReceivers;
    }
    private int numOfAttachments;
    /**
     * set the numOfAttachments
     * @param numOfAttachments
     */
    @Override
    public void setNumOfAttachments(int numOfAttachments) {
        this.numOfAttachments = numOfAttachments;
    }
    /**
     * get the numOfAttachments
     * @return numOfAttachments
     */
    @Override
    public int getNumOfAttachments() {
        return numOfAttachments;
    }
    private int numOfLinesInBody;
    /**
     * set the numOfLinesInBody
     * @param numOfLinesInBody
     */
    @Override
    public void setNumOfLinesInBody(int numOfLinesInBody) {
        this.numOfLinesInBody = numOfLinesInBody;
    }
    /**
     * get the numOfLinesInBody
     * @return numOfLinesInBody
     */
    @Override
    public int getNumOfLinesInBody() {
        return numOfLinesInBody;
    }
    private int numOfWordsInBody;
    /**
     * set the numOfWordsInBody
     * @param numOfWordsInBody
     */
    @Override
    public void setNumOfWordsInBody(int numOfWordsInBody) {
        this.numOfWordsInBody = numOfWordsInBody;
    }
    /**
     * get the numOfWordsInBody
     * @return numOfWordsInBody
     */
    @Override
    public int getNumOfWordsInBody() {
        return numOfWordsInBody;
    }
    private int numOfLettersInBody;
    /**
     * set the numOfLettersInBody
     * @param numOfLettersInBody
     */
    @Override
    public void setNumOfLettersInBody(int numOfLettersInBody) {
        this.numOfLettersInBody = numOfLettersInBody;
    }
    /**
     * get the numOfLettersInBody
     * @return numOfLettersInBody
     */
    @Override
    public int getNumOfLettersInBody() {
        return numOfLettersInBody;
    }
    /**
     * @param x is the Date that we search for
     * @return Returns index of x (complete Date) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByCompleteDate(Date x) throws ParseException, IOException{
        if (x!=null) {
            if (e!=null&&e.size() > 0) {
                Date d = new Date();
                d.setTime(x.getTime());
                doubleLinkedList mails = new doubleLinkedList();
                sort sorting = new sort();
                sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
                mails = sorting.sortByDateOldestToNewest();
                Stack s = new Stack();
                s.push(0);
                s.push(e.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (start < end) {
                        int mid = start + (end - start) / 2;
                        String line = Files.readAllLines(Paths.get(((File) mails.get(mid)).getPath() + "\\index.txt")).get(0);
                        Date inMid = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(line);
                        inMid.setMinutes(0);
                        inMid.setHours(0);
                        inMid.setSeconds(0);
                        d.setMinutes(0);
                        d.setHours(0);
                        d.setSeconds(0);
                        if (d.compareTo(inMid) < 0) {
                            s.push(start);
                            s.push(mid);
                        } else if (d.compareTo(inMid) > 0) {
                            s.push(mid + 1);
                            s.push(end);
                        } else {
                            return mid;
                        }
                    }
                }
                return -1;
            }
            else if(e.isEmpty()){
                return (-1);
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Date that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Date
     */
    @Override
    public doubleLinkedList filterByCompleteDate(Date x) throws IOException, ParseException {
        if (x!=null) {
            if (e!=null&&e.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                doubleLinkedList past = new doubleLinkedList();
                past = (doubleLinkedList) e.sublist(0, e.size() - 1);
                sort sorting = new sort();
                sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
                mails = sorting.sortByDateOldestToNewest();
                doubleLinkedList filtered = new doubleLinkedList();
                int i = binarySearchByCompleteDate(x);
                while (i > -1) {
                    filtered.add(mails.get(i));
                    mails.remove(i);
                    if(mails.isEmpty()) {
                    	e=new doubleLinkedList();
                    }
                    else {
                    e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                    }
                    i = binarySearchByCompleteDate(x);
                }
                e = past;
                return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Date that we search for
     * @return Returns index of d (Date (Day)) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByDayOfDate(Date x) throws ParseException, IOException{
        if (x!=null) {
            if (e!=null&&e.size() > 0) {
                Date d = new Date();
                d.setTime(x.getTime());
                doubleLinkedList mails = new doubleLinkedList();
                sort sorting = new sort();
                sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
                mails = sorting.sortByDateOldestToNewest();
                Stack s = new Stack();
                s.push(0);
                s.push(e.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (start < end) {
                        int mid = start + (end - start) / 2;
                        String line = Files.readAllLines(Paths.get(((File) mails.get(mid)).getPath() + "\\index.txt")).get(0);
                        Date inMid = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(line);
                        inMid.setMinutes(0);
                        inMid.setHours(0);
                        inMid.setSeconds(0);
                        inMid.setMonth(0);
                        inMid.setYear(0);
                        d.setMinutes(0);
                        d.setHours(0);
                        d.setSeconds(0);
                        d.setMonth(0);
                        d.setYear(0);
                        if (d.compareTo(inMid) < 0) {
                            s.push(start);
                            s.push(mid);
                        } else if (d.compareTo(inMid) > 0) {
                            s.push(mid + 1);
                            s.push(end);
                        } else {
                            return mid;
                        }
                    }
                }
                return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Date that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Date
     */
    @Override
    public doubleLinkedList filterByDayOfDate(Date x) throws IOException, ParseException {
        if (x!=null) {
            if (e != null && e.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                doubleLinkedList past = new doubleLinkedList();
                past = (doubleLinkedList) e.sublist(0, e.size() - 1);
                sort sorting = new sort();
                sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
                mails = sorting.sortByDateOldestToNewest();
                doubleLinkedList filtered = new doubleLinkedList();
                int i = binarySearchByDayOfDate(x);
                while (i > -1) {
                    filtered.add(mails.get(i));
                    mails.remove(i);
                    if(mails.isEmpty()) {
                    	e=new doubleLinkedList();
                    }
                    else {
                    e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                    }
                    i = binarySearchByDayOfDate(x);
                }
                e = past;
                return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * @param x is the Subject that we search for
     * @return Returns index of x (Subject) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchBySubject(String x) throws ParseException, IOException{
        if (x!=null) {
            if (e != null && e.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                sort sorting = new sort();
                sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
                mails = sorting.sortAscendingBySubject();
                Stack s = new Stack();
                s.push(0);
                s.push(e.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (start < end) {
                        int mid = start + (end - start) / 2;
                        String line = Files.readAllLines(Paths.get(((File) mails.get(mid)).getPath() + "\\index.txt")).get(1);
                        String inMid = line.toLowerCase();
                        if (x.toLowerCase().compareTo(inMid) < 0) {
                            s.push(start);
                            s.push(mid);
                        } else if (x.toLowerCase().compareTo(inMid) > 0) {
                            s.push(mid + 1);
                            s.push(end);
                        } else {
                            return mid;
                        }
                    }
                }
                return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Subject that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Subject
     */
    @Override
    public doubleLinkedList filterBySubject(String x) throws IOException, ParseException {
        if (x!=null) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            doubleLinkedList past = new doubleLinkedList();
            past=(doubleLinkedList) e.sublist(0, e.size() - 1);
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingBySubject();
            doubleLinkedList filtered = new doubleLinkedList();
            int i = binarySearchBySubject(x);
            while (i > -1) {
                filtered.add(mails.get(i));
                mails.remove(i);
                if(mails.isEmpty()) {
                	e=new doubleLinkedList();
                }
                else {
                e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                }
                i = binarySearchBySubject(x);
            }
            e=past;
            return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Sender that we search for
     * @return Returns index of x (Sender) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchBySender(String x) throws ParseException, IOException{
        if (x!=null) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingBySender();
            Stack s = new Stack();
            s.push(0);
            s.push(e.size());
            while (!s.isEmpty()) {
                int end = (int) s.pop();
                int start = (int) s.pop();
                if (start < end) {
                    int mid = start + (end - start) / 2;
                    String line = Files.readAllLines(Paths.get(((File) mails.get(mid)).getPath() + "\\index.txt")).get(2);
                    String inMid = line.toLowerCase();
                    if (x.toLowerCase().compareTo(inMid) < 0) {
                        s.push(start);
                        s.push(mid);
                    } else if (x.toLowerCase().compareTo(inMid) > 0) {
                        s.push(mid + 1);
                        s.push(end);
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Sender that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Sender
     */
    public doubleLinkedList filterBySender(String x) throws IOException, ParseException {
        if (x!=null) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            doubleLinkedList past = new doubleLinkedList();
            past=(doubleLinkedList) e.sublist(0, e.size() - 1);
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingBySender();
            doubleLinkedList filtered = new doubleLinkedList();
            int i = binarySearchBySender(x);
            while (i > -1) {
                filtered.add(mails.get(i));
                mails.remove(i);
                if(mails.isEmpty()) {
                	e=new doubleLinkedList();
                }
                else {
                e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                }
                i = binarySearchBySender(x);
            }
            e = past;
            return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Priority that we search for
     * @return Returns index of x (Priority) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByPriority(int x) throws ParseException, IOException{
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByPriority();
            Stack s = new Stack();
            s.push(0);
            s.push(e.size());
            while (!s.isEmpty()) {
                int end = (int) s.pop();
                int start = (int) s.pop();
                if (start < end) {
                    int mid = start + (end - start) / 2;
                    String line = Files.readAllLines(Paths.get(((File) mails.get(mid)).getPath() + "\\index.txt")).get(3);
                    int inMid = Integer.parseInt(line);
                    if (x < inMid) {
                        s.push(start);
                        s.push(mid);
                    } else if (x > inMid) {
                        s.push(mid + 1);
                        s.push(end);
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }
    /**
     * @param x is the Priority that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Priority
     */
    public doubleLinkedList filterByPriority(int x) throws IOException, ParseException {
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            doubleLinkedList past = new doubleLinkedList();
            past=(doubleLinkedList) e.sublist(0, e.size() - 1);
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByPriority();
            doubleLinkedList filtered = new doubleLinkedList();
            int i = binarySearchByPriority(x);
            while (i > -1) {
                filtered.add(mails.get(i));
                mails.remove(i);
                if(mails.isEmpty()) {
                	e=new doubleLinkedList();
                }
                else {
                e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                }
                i = binarySearchByPriority(x);
            }
            e = past;
            return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }
    /**
     * it returns the number of the lines in the Receivers file of the mail
     * @param f is a file that we want to calculate its number of lines(Receivers)
     * @return the number of lines in the Receivers file in that folder
     */
    private int numOfLinesInReceivers(File f) throws IOException {
        //Scanner sc = new Scanner(new File(f + "\\Receivers.txt"));
        if (f!=null) {
            FileReader fr = new FileReader(new File(f + "\\Receivers.txt"));
            BufferedReader br = new BufferedReader(fr);
            int numOfLines = 0;
            String line1;
            while (!((line1 = br.readLine()) == null)) {
                numOfLines++;
            }
            return numOfLines;
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Num Of Receivers that we search for
     * @return Returns index of x (Num Of Receivers) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfReceivers(int x) throws ParseException, IOException{
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfReceivers();
            Stack s = new Stack();
            s.push(0);
            s.push(e.size());
            while (!s.isEmpty()) {
                int end = (int) s.pop();
                int start = (int) s.pop();
                if (start < end) {
                    int mid = start + (end - start) / 2;
                    int inMid = numOfLinesInReceivers((File) mails.get(mid));
                    if (x < inMid) {
                        s.push(start);
                        s.push(mid);
                    } else if (x > inMid) {
                        s.push(mid + 1);
                        s.push(end);
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }
    /**
     * @param x is the Num Of Receivers that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Receivers
     */
    public doubleLinkedList filterByNumOfReceivers(int x) throws IOException, ParseException {
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            doubleLinkedList past = new doubleLinkedList();
            past=(doubleLinkedList) e.sublist(0, e.size() - 1);
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfReceivers();
            doubleLinkedList filtered = new doubleLinkedList();
            int i = binarySearchByNumOfReceivers(x);
            while (i > -1) {
                filtered.add(mails.get(i));
                mails.remove(i);
                if(mails.isEmpty()) {
                	e=new doubleLinkedList();
                }
                else {
                e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                }
                i = binarySearchByNumOfReceivers(x);
            }
            e = past;
            return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }
    /**
     * check if the mail has ths receiver with the name receiver
     * @param f the file of the email
     * @param receiver the name of receiver i search with
     * @return true  if the file has receiver with that name
     * @throws IOException
     */
    private boolean ifReceiverInFile(File f,String receiver) throws IOException {
        //Scanner sc = new Scanner(new File(f + "\\Receivers.txt"));
        if (f!=null&receiver!=null) {
            FileReader fr = new FileReader(new File(f + "\\Receivers.txt"));
            BufferedReader br = new BufferedReader(fr);
            int numOfLines = 0;
            String line1;
            while (!((line1 = br.readLine()) == null)) {
                if (line1.toLowerCase().equals(receiver.toLowerCase())){
                    return true;
                }
                numOfLines++;
            }
            return false;
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Receiver that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that seme Receiver x
     */
    @Override
    public doubleLinkedList filterByReceiver(String x) throws IOException, ParseException {
        if (x!=null) {
            if (e!=null) {
                doubleLinkedList filtered = new doubleLinkedList();
                int i = 0;
                for (i = 9; i < e.size(); i++) {
                    if (ifReceiverInFile((File) e.get(i), x)) {
                        filtered.add(e.get(i));
                    }
                }
                return filtered;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }
    /**
     * it returns the number of the lines in the Attachments file of the mail
     * @param f is a file that we want to calculate its number of lines(Attachments)
     * @return the number of lines in the Attachments file in that folder
     */
    private int numOfAttachments(File f) throws IOException {
        /*
        Scanner sc = new Scanner(new File(f + "\\Attachments.txt"));
        FileReader fr=new FileReader(new File(f + "\\Attachments.txt"));
        BufferedReader br=new BufferedReader(fr);
        int numOfLines = 0;
        String line1;
        while (!((line1=br.readLine())==null)) {
            numOfLines++;
        }
        return numOfLines;
         */
        if (f!=null) {
            File file = new File(f.getPath() + "\\Attachments\\");
            File[] files = file.listFiles();
            int num = files.length;
            return num;
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Num Of Attachments that we search for
     * @return Returns index of x (Num Of Attachments) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfAttachments(int x) throws ParseException, IOException{
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfAttachments();
            Stack s = new Stack();
            s.push(0);
            s.push(e.size());
            while (!s.isEmpty()) {
                int end = (int) s.pop();
                int start = (int) s.pop();
                if (start < end) {
                    int mid = start + (end - start) / 2;
                    int inMid = numOfAttachments((File) mails.get(mid));
                    if (x < inMid) {
                        s.push(start);
                        s.push(mid);
                    } else if (x > inMid) {
                        s.push(mid + 1);
                        s.push(end);
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }
    /**
     * @param x is the Num Of Attachments that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Attachments
     */
    @Override
    public doubleLinkedList filterByNumOfAttachments(int x) throws IOException, ParseException {
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            doubleLinkedList past = new doubleLinkedList();
            past=(doubleLinkedList) e.sublist(0, e.size() - 1);
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfAttachments();
            doubleLinkedList filtered = new doubleLinkedList();
            int i = binarySearchByNumOfAttachments(x);
            while (i > -1) {
                filtered.add(mails.get(i));
                mails.remove(i);
                if(mails.isEmpty()) {
                	e=new doubleLinkedList();
                }
                else {
                e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                }
                i = binarySearchByNumOfAttachments(x);
            }
            e = past;
            return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }

    /**
     * it returns the number of the lines in the body file of the mail
     * @param f is a file that we want to calculate its number of lines
     * @return the number of lines in the body file in that folder
     */
    private int numOfLinesInBody(File f) throws IOException {
        if (f!=null) {
            Scanner sc = new Scanner(new File(f +"\\"+ Files.readAllLines(Paths.get((f.getPath() + "\\index.txt"))).get(1) + ".txt"));
            FileReader fr = new FileReader(new File(f +"\\"+ Files.readAllLines(Paths.get((f.getPath() + "\\index.txt"))).get(1) + ".txt"));
            BufferedReader br = new BufferedReader(fr);
            int numOfLines = 0;
            String line1;
            while (!((line1 = br.readLine()) == null)) {
                numOfLines++;
            }
            return numOfLines;
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Num Of Lines In Body that we search for
     * @return Returns index of x (Num Of Lines In Body) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfLinesInBody(int x) throws ParseException, IOException{
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfLinesInBody();
            Stack s = new Stack();
            s.push(0);
            s.push(e.size());
            while (!s.isEmpty()) {
                int end = (int) s.pop();
                int start = (int) s.pop();
                if (start < end) {
                    int mid = start + (end - start) / 2;
                    int inMid = numOfLinesInBody((File) mails.get(mid));
                    if (x < inMid) {
                        s.push(start);
                        s.push(mid);
                    } else if (x > inMid) {
                        s.push(mid + 1);
                        s.push(end);
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }
    /**
     * @param x is the Num Of Lines In Body that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Lines In Body
     */
    public doubleLinkedList filterByNumOfLinesInBody(int x) throws IOException, ParseException {
        if(x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            doubleLinkedList past = new doubleLinkedList();
            past=(doubleLinkedList) e.sublist(0, e.size() - 1);
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfLinesInBody();
            doubleLinkedList filtered = new doubleLinkedList();
            int i = binarySearchByNumOfLinesInBody(x);
            while (i > -1) {
                filtered.add(mails.get(i));
                mails.remove(i);
                if(mails.isEmpty()) {
                	e=new doubleLinkedList();
                }
                else {
                e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                }
                i = binarySearchByNumOfLinesInBody(x);
            }
            e = past;
            return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }

    /**
     * it returns the number of the words in the body file of the mail
     * @param f is a file that we want to calculate its number of words
     * @return the number of words in the body file in that folder
     */
    private int numOfWordsInBody(File f) throws IOException {
        if (f!=null) {
            FileReader fr = new FileReader(new File(f +"\\"+ Files.readAllLines(Paths.get((f.getPath() + "\\index.txt"))).get(1) + ".txt"));
            BufferedReader br = new BufferedReader(fr);
            int numOfWords = 0;
            String line1;
            while (!((line1 = br.readLine()) == null)) {
                String[] s = (line1.split("\\s+"));
                numOfWords += s.length;
            }
            return numOfWords;
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Num Of Words In Body that we search for
     * @return Returns index of x (Num Of Words In Body) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfWordsInBody(int x) throws ParseException, IOException{
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfWordsInBody();
            Stack s = new Stack();
            s.push(0);
            s.push(e.size());
            while (!s.isEmpty()) {
                int end = (int) s.pop();
                int start = (int) s.pop();
                if (start < end) {
                    int mid = start + (end - start) / 2;
                    int inMid = numOfWordsInBody((File) mails.get(mid));
                    if (x < inMid) {
                        s.push(start);
                        s.push(mid);
                    } else if (x > inMid) {
                        s.push(mid + 1);
                        s.push(end);
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }
    /**
     * @param x is the Num Of Words In Body that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Words In Body
     */
    @Override
    public doubleLinkedList filterByNumOfWordsInBody(int x) throws IOException, ParseException {
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            doubleLinkedList past = new doubleLinkedList();
            past=(doubleLinkedList) e.sublist(0, e.size() - 1);
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfWordsInBody();
            doubleLinkedList filtered = new doubleLinkedList();
            int i = binarySearchByNumOfWordsInBody(x);
            while (i > -1) {
                filtered.add(mails.get(i));
                mails.remove(i);
                if(mails.isEmpty()) {
                	e=new doubleLinkedList();
                }
                else {
                e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                }
                i = binarySearchByNumOfWordsInBody(x);
            }
            e = past;
            return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }

    /**
     * it returns the number of the Letters in the body file of the mail
     * @param f is a file that we want to calculate its number of Letters
     * @return the number of Letters in the body file in that folder
     */
    private int numOfLettersInBody(File f) throws IOException {
        if (f!=null) {
            FileReader fr = new FileReader(new File(f +"\\"+ Files.readAllLines(Paths.get((f.getPath() + "\\index.txt"))).get(1) + ".txt"));
            BufferedReader br = new BufferedReader(fr);
            int numOfLetters = 0;
            String line1;
            while (!((line1 = br.readLine()) == null)) {
                String[] s = (line1.split("\\s+"));
                for (int i = 0; i < s.length; i++) {
                    numOfLetters += s[i].length();
                }
            }
            return numOfLetters;
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Num Of Letters In Body that we search for
     * @return Returns index of x (Num Of Letters In Body) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfLettersInBody(int x) throws ParseException, IOException{
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfLettersInBody();
            Stack s = new Stack();
            s.push(0);
            s.push(e.size());
            while (!s.isEmpty()) {
                int end = (int) s.pop();
                int start = (int) s.pop();
                if (start < end) {
                    int mid = start + (end - start) / 2;
                    int inMid = numOfLettersInBody((File) mails.get(mid));
                    if (x < inMid) {
                        s.push(start);
                        s.push(mid);
                    } else if (x > inMid) {
                        s.push(mid + 1);
                        s.push(end);
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }
    /**
     * @param x is the Num Of Letters In Body that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Letters In Body
     */
    @Override
    public doubleLinkedList filterByNumOfLettersInBody(int x) throws IOException, ParseException {
        if (x>-1) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            doubleLinkedList past = new doubleLinkedList();
            past=(doubleLinkedList) e.sublist(0, e.size() - 1);
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortAscendingByNumOfLettersInBody();
            doubleLinkedList filtered = new doubleLinkedList();
            int i = binarySearchByNumOfLettersInBody(x);
            while (i > -1) {
                filtered.add(mails.get(i));
                mails.remove(i);
                if(mails.isEmpty()) {
                	e=new doubleLinkedList();
                }
                else {
                e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                }
                i = binarySearchByNumOfLettersInBody(x);
            }
            e = past;
            return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            RuntimeException Runtime = new RuntimeException();
            throw Runtime;
        }
    }

    /**
     * @param x is the Contact that we search for
     * @return Returns index of x (Contact) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchInContactBySName(String x) throws ParseException, IOException{
        if (x!=null) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortContactAscending();
            Stack s = new Stack();
            s.push(0);
            s.push(e.size());
            while (!s.isEmpty()) {
                int end = (int) s.pop();
                int start = (int) s.pop();
                if (start < end) {
                    int mid = start + (end - start) / 2;
                    String line = ((File) mails.get(mid)).getName();
                    String temp[]=line.split(".txt");
                    String inMid = temp[0].toLowerCase();
                    if (x.toLowerCase().compareTo(inMid) < 0) {
                        s.push(start);
                        s.push(mid);
                    } else if (x.toLowerCase().compareTo(inMid) > 0) {
                        s.push(mid + 1);
                        s.push(end);
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
            }
            else if(e.isEmpty()){
                return -1;
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * @param x is the Subject that we to filter the contacts with
     * @return Returns double Linked List Of the contacts with that Subject
     */
    @Override
    public doubleLinkedList filterContactByName(String x) throws IOException, ParseException {
        if (x!=null) {
            if (e != null && e.size() > 0) {
            doubleLinkedList mails = new doubleLinkedList();
            doubleLinkedList past = new doubleLinkedList();
            past=(doubleLinkedList) e.sublist(0, e.size() - 1);
            sort sorting = new sort();
            sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
            mails = sorting.sortContactAscending();
            doubleLinkedList filtered = new doubleLinkedList();
            int i = binarySearchInContactBySName(x);
            while (i > -1) {
                filtered.add(mails.get(i));
                mails.remove(i);
                if(mails.isEmpty()) {
                	e=new doubleLinkedList();
                }
                else {
                e = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
                }
                i = binarySearchInContactBySName(x);
            }
            e=past;
            return filtered;
            }
            else if(e.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                NullPointerException NullPointer = new NullPointerException();
                throw NullPointer;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
}
