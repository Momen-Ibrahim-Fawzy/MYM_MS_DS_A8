package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.doubleLinkedList;
import eg.edu.alexu.csd.datastructure.stacks.Stack;

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
    private doubleLinkedList e = new doubleLinkedList();
    /**
     * @param mails the double linked list of the e_mails to be sort
     * it set the double linked list of the e_mails
     */
    @Override
    public void setMails(doubleLinkedList mails){
        e= (doubleLinkedList) mails.sublist(0,mails.size()-1);
    }
    /**
     * @return the double linked list of the e_mails which we want it to be sorted
     */
    @Override
    public doubleLinkedList getMails(){
        return e;
    }
    /**
     * @param x is the Date that we search for
     * @return Returns index of x (Date) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByDate(Date x) throws ParseException, IOException{
        doubleLinkedList mails = new doubleLinkedList();
        sort sorting = new sort();
        sorting.setMails((doubleLinkedList) e.sublist(0, e.size() - 1));
        mails = sorting.sortByDateNewestToOldest();
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
                if (x.compareTo(inMid)<0) {
                    s.push(start);
                    s.push(mid);
                }
                else if (x.compareTo(inMid)>0) {
                    s.push(mid+1);
                    s.push(end);
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**
     * @param x is the Date that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Date
     */
    @Override
    public doubleLinkedList filterByDate(Date x) throws IOException, ParseException {
        doubleLinkedList past = (doubleLinkedList)e.sublist(0,e.size()-1);
        doubleLinkedList filtered = new doubleLinkedList();
        int i= binarySearchByDate(x);
        while (i>-1){
            filtered.add(e.get(i));
            e.remove(i);
            i= binarySearchByDate(x);
        }
        e=past;
        return filtered;
    }
    /**
     * @param x is the Subject that we search for
     * @return Returns index of x (Subject) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchBySubject(String x) throws ParseException, IOException{
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
                if (x.toLowerCase().compareTo(inMid)<0) {
                    s.push(start);
                    s.push(mid);
                }
                else if (x.toLowerCase().compareTo(inMid)>0) {
                    s.push(mid+1);
                    s.push(end);
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**
     * @param x is the Subject that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Subject
     */
    @Override
    public doubleLinkedList filterBySubject(String x) throws IOException, ParseException {
        doubleLinkedList past = (doubleLinkedList)e.sublist(0,e.size()-1);
        doubleLinkedList filtered = new doubleLinkedList();
        int i= binarySearchBySubject(x);
        while (i>-1){
            filtered.add(e.get(i));
            e.remove(i);
            i= binarySearchBySubject(x);
        }
        e=past;
        return filtered;
    }
    /**
     * @param x is the Sender that we search for
     * @return Returns index of x (Sender) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchBySender(String x) throws ParseException, IOException{
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
                if (x.toLowerCase().compareTo(inMid)<0) {
                    s.push(start);
                    s.push(mid);
                }
                else if (x.toLowerCase().compareTo(inMid)>0) {
                    s.push(mid+1);
                    s.push(end);
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**
     * @param x is the Sender that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Sender
     */
    public doubleLinkedList filterBySender(String x) throws IOException, ParseException {
        doubleLinkedList past = (doubleLinkedList)e.sublist(0,e.size()-1);
        doubleLinkedList filtered = new doubleLinkedList();
        int i= binarySearchBySender(x);
        while (i>-1){
            filtered.add(e.get(i));
            e.remove(i);
            i= binarySearchBySender(x);
        }
        e=past;
        return filtered;
    }
    /**
     * @param x is the Priority that we search for
     * @return Returns index of x (Priority) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByPriority(int x) throws ParseException, IOException{
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
                if (x<inMid) {
                    s.push(start);
                    s.push(mid);
                }
                else if (x>inMid) {
                    s.push(mid+1);
                    s.push(end);
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**
     * @param x is the Priority that we to filter with
     * @return Returns double Linked List Of the E_Mails with that Priority
     */
    public doubleLinkedList filterByPriority(int x) throws IOException, ParseException {
        doubleLinkedList past = (doubleLinkedList)e.sublist(0,e.size()-1);
        doubleLinkedList filtered = new doubleLinkedList();
        int i= binarySearchByPriority(x);
        while (i>-1){
            filtered.add(e.get(i));
            e.remove(i);
            i= binarySearchByPriority(x);
        }
        e=past;
        return filtered;
    }
    /**
     * it returns the number of the lines in the Receivers file of the mail
     * @param f is a file that we want to calculate its number of lines(Receivers)
     * @return the number of lines in the Receivers file in that folder
     */
    private int numOfLinesInReceivers(File f) throws IOException {
        Scanner sc = new Scanner(new File(f + "\\Receivers.txt"));
        FileReader fr=new FileReader(new File(f + "\\Receivers.txt"));
        BufferedReader br=new BufferedReader(fr);
        int numOfLines = 0;
        String line1;
        while (!((line1=br.readLine())==null)) {
            numOfLines++;
        }
        return numOfLines;
    }
    /**
     * @param x is the Num Of Receivers that we search for
     * @return Returns index of x (Num Of Receivers) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfReceivers(int x) throws ParseException, IOException{
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
                if (x<inMid) {
                    s.push(start);
                    s.push(mid);
                }
                else if (x>inMid) {
                    s.push(mid+1);
                    s.push(end);
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**
     * @param x is the Num Of Receivers that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Receivers
     */
    public doubleLinkedList filterByNumOfReceivers(int x) throws IOException, ParseException {
        doubleLinkedList past = (doubleLinkedList)e.sublist(0,e.size()-1);
        doubleLinkedList filtered = new doubleLinkedList();
        int i= binarySearchByNumOfReceivers(x);
        while (i>-1){
            filtered.add(e.get(i));
            e.remove(i);
            i= binarySearchByNumOfReceivers(x);
        }
        e=past;
        return filtered;
    }

    /**
     * it returns the number of the lines in the Attachments file of the mail
     * @param f is a file that we want to calculate its number of lines(Attachments)
     * @return the number of lines in the Attachments file in that folder
     */
    private int numOfLinesInAttachments(File f) throws IOException {
        Scanner sc = new Scanner(new File(f + "\\Attachments.txt"));
        FileReader fr=new FileReader(new File(f + "\\Attachments.txt"));
        BufferedReader br=new BufferedReader(fr);
        int numOfLines = 0;
        String line1;
        while (!((line1=br.readLine())==null)) {
            numOfLines++;
        }
        return numOfLines;
    }
    /**
     * @param x is the Num Of Attachments that we search for
     * @return Returns index of x (Num Of Attachments) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfAttachments(int x) throws ParseException, IOException{
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
                int inMid = numOfLinesInAttachments((File) mails.get(mid));
                if (x<inMid) {
                    s.push(start);
                    s.push(mid);
                }
                else if (x>inMid) {
                    s.push(mid+1);
                    s.push(end);
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**
     * @param x is the Num Of Attachments that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Attachments
     */
    @Override
    public doubleLinkedList filterByNumOfAttachments(int x) throws IOException, ParseException {
        doubleLinkedList past = (doubleLinkedList)e.sublist(0,e.size()-1);
        doubleLinkedList filtered = new doubleLinkedList();
        int i= binarySearchByNumOfAttachments(x);
        while (i>-1){
            filtered.add(e.get(i));
            e.remove(i);
            i= binarySearchByNumOfAttachments(x);
        }
        e=past;
        return filtered;
    }

    /**
     * it returns the number of the lines in the body file of the mail
     * @param f is a file that we want to calculate its number of lines
     * @return the number of lines in the body file in that folder
     */
    private int numOfLinesInBody(File f) throws IOException {
        Scanner sc = new Scanner(new File(f + "\\body.txt"));
        FileReader fr=new FileReader(new File(f + "\\body.txt"));
        BufferedReader br=new BufferedReader(fr);
        int numOfLines = 0;
        String line1;
        while (!((line1=br.readLine())==null)) {
            numOfLines++;
        }
        return numOfLines;
    }
    /**
     * @param x is the Num Of Lines In Body that we search for
     * @return Returns index of x (Num Of Lines In Body) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfLinesInBody(int x) throws ParseException, IOException{
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
                if (x<inMid) {
                    s.push(start);
                    s.push(mid);
                }
                else if (x>inMid) {
                    s.push(mid+1);
                    s.push(end);
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**
     * @param x is the Num Of Lines In Body that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Lines In Body
     */
    public doubleLinkedList filterByNumOfLinesInBody(int x) throws IOException, ParseException {
        doubleLinkedList past = (doubleLinkedList)e.sublist(0,e.size()-1);
        doubleLinkedList filtered = new doubleLinkedList();
        int i= binarySearchByNumOfLinesInBody(x);
        while (i>-1){
            filtered.add(e.get(i));
            e.remove(i);
            i= binarySearchByNumOfLinesInBody(x);
        }
        e=past;
        return filtered;
    }

    /**
     * it returns the number of the words in the body file of the mail
     * @param f is a file that we want to calculate its number of words
     * @return the number of words in the body file in that folder
     */
    private int numOfWordsInBody(File f) throws IOException {
        FileReader fr=new FileReader(new File(f + "\\body.txt"));
        BufferedReader br=new BufferedReader(fr);
        int numOfWords=0;
        String line1;
        while (!((line1=br.readLine())==null)) {
            String[] s=(line1.split(" "));
            numOfWords+=s.length;
        }
        return numOfWords;
    }
    /**
     * @param x is the Num Of Words In Body that we search for
     * @return Returns index of x (Num Of Words In Body) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfWordsInBody(int x) throws ParseException, IOException{
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
                if (x<inMid) {
                    s.push(start);
                    s.push(mid);
                }
                else if (x>inMid) {
                    s.push(mid+1);
                    s.push(end);
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**
     * @param x is the Num Of Words In Body that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Words In Body
     */
    @Override
    public doubleLinkedList filterByNumOfWordsInBody(int x) throws IOException, ParseException {
        doubleLinkedList past = (doubleLinkedList)e.sublist(0,e.size()-1);
        doubleLinkedList filtered = new doubleLinkedList();
        int i= binarySearchByNumOfWordsInBody(x);
        while (i>-1){
            filtered.add(e.get(i));
            e.remove(i);
            i= binarySearchByNumOfWordsInBody(x);
        }
        e=past;
        return filtered;
    }

    /**
     * it returns the number of the Letters in the body file of the mail
     * @param f is a file that we want to calculate its number of Letters
     * @return the number of Letters in the body file in that folder
     */
    private int numOfLettersInBody(File f) throws IOException {
        FileReader fr=new FileReader(new File(f + "\\body.txt"));
        BufferedReader br=new BufferedReader(fr);
        int numOfLetters=0;
        String line1;
        while (!((line1=br.readLine())==null)) {
            String[] s=(line1.split(" "));
            for (int i=0 ; i<s.length;i++) {
                numOfLetters += s[i].length();
            }
        }
        return numOfLetters;
    }
    /**
     * @param x is the Num Of Letters In Body that we search for
     * @return Returns index of x (Num Of Letters In Body) if it is present in double Linked List ,
     * else return -1
     */
    private int binarySearchByNumOfLettersInBody(int x) throws ParseException, IOException{
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
                if (x<inMid) {
                    s.push(start);
                    s.push(mid);
                }
                else if (x>inMid) {
                    s.push(mid+1);
                    s.push(end);
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**
     * @param x is the Num Of Letters In Body that we want to filter with
     * @return Returns double Linked List Of the E_Mails with that Num Of Letters In Body
     */
    @Override
    public doubleLinkedList filterByNumOfLettersInBody(int x) throws IOException, ParseException {
        doubleLinkedList past = (doubleLinkedList)e.sublist(0,e.size()-1);
        doubleLinkedList filtered = new doubleLinkedList();
        int i= binarySearchByNumOfLettersInBody(x);
        while (i>-1){
            filtered.add(e.get(i));
            e.remove(i);
            i= binarySearchByNumOfLettersInBody(x);
        }
        e=past;
        return filtered;
    }
}
