package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.doubleLinkedList;
import eg.edu.alexu.csd.datastructure.stacks.Stack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class sort implements ISort{
    /**
     * sortByDateOldestToNewest or sortByDateNewestToOldest or sortAscendingBySubject or sortDescendingBySubject
     * or sortAscendingBySender or sortDescendingBySender or sortAscendingByPriority or sortDescendingByPriority
     * or sortAscendingByNumOfLinesInBody or sortDescendingByNumOfLinesInBody or sortAscendingByNumOfWordsInBody
     * or sortDescendingByNumOfWordsInBody or sortAscendingByNumOfLettersInBody or sortDescendingByNumOfLettersInBody
     * or sortAscendingByNumOfReceivers or sortDescendingByNumOfReceivers or sortAscendingByNumOfAttachments
     * or sortDescendingByNumOfAttachments
     */
    private String type="";
    private doubleLinkedList m = new doubleLinkedList();
    /**
     * get the type of the sorting
     * @return type of the sorting
     */
    public String getType() {
        return type;
    }
    /**
     * set the type of the sorting
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @param mails the double linked list of the e_mails to be sort
     * it set the double linked list of the e_mails
     */
    public void setMails(doubleLinkedList mails){
        if(mails!=null&&!mails.isEmpty()) {
            m = (doubleLinkedList) mails.sublist(0, mails.size() - 1);
        }
        else if(mails.isEmpty()){
            m=new doubleLinkedList();
        }
        else{
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * @return the double linked list of the e_mails which we want it to be sorted
     */
    public doubleLinkedList getMails(){
        return m;
    }
    /**
     * it sort the double linked list by the date of each e_main(Newest To Oldest)
     * @return a sorted double linked list of folders of e_mails by date(Newest To Oldest)
     */
    @Override
    public doubleLinkedList sortByDateOldestToNewest() throws ParseException, IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    String line = Files.readAllLines(Paths.get(((File) mails.get(p)).getPath() + "\\index.txt")).get(0);
                    Date piv = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(line);
                    mails.swap(p, end - 1);
                    while (l < h) {
                        line = Files.readAllLines(Paths.get(((File) mails.get(l)).getPath() + "\\index.txt")).get(0);
                        Date inl = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(line);
                        line = Files.readAllLines(Paths.get(((File) mails.get(h)).getPath() + "\\index.txt")).get(0);
                        Date inh = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(line);
                        if (inl.before(piv)) {
                            l++;
                        } else if (inh.after(piv) | inh.equals(piv)) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    line = Files.readAllLines(Paths.get(((File) mails.get(h)).getPath() + "\\index.txt")).get(0);
                    Date inh = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(line);
                    if (inh.before(piv)) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * it sort the double linked list by the date of each e_main(Oldest To Newest)
     * @return a sorted double linked list of folders of e_mails by date(Oldest To Newest)
     */
    @Override
    public doubleLinkedList sortByDateNewestToOldest() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortByDateOldestToNewest();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
    }
    /**
     * it sort the double linked list by the name of subject of each e_main
     * @return a sorted double linked list of folders of e_mails by the name of subject
     */
    @Override
    public doubleLinkedList sortAscendingBySubject() throws ParseException, IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    String line = Files.readAllLines(Paths.get(((File) mails.get(p)).getPath() + "\\index.txt")).get(1);
                    String piv = line.toLowerCase();
                    mails.swap(p, end - 1);
                    while (l < h) {
                        line = Files.readAllLines(Paths.get(((File) mails.get(l)).getPath() + "\\index.txt")).get(1);
                        String inl = line.toLowerCase();
                        line = Files.readAllLines(Paths.get(((File) mails.get(h)).getPath() + "\\index.txt")).get(1);
                        String inh = line.toLowerCase();
                        if (inl.compareTo(piv) < 0) {
                            l++;
                        } else if (inh.compareTo(piv) > 0 | inh.equals(piv)) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    line = Files.readAllLines(Paths.get(((File) mails.get(h)).getPath() + "\\index.txt")).get(1);
                    String inh = line.toLowerCase();
                    if (inh.compareTo(piv) < 0) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * it sort the double linked list Descending by the name of subject of each e_main
     * @return a sorted double linked list of folders of e_mails by the name of subject(Descending)
     */
    @Override
    public doubleLinkedList sortDescendingBySubject() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortAscendingBySubject();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
    }

    /**
     * it sort the double linked list by the name of Sender of each e_main
     * @return a sorted double linked list of folders of e_mails by the name of Sender
     */
    @Override
    public doubleLinkedList sortAscendingBySender() throws ParseException, IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    String line = Files.readAllLines(Paths.get(((File) mails.get(p)).getPath() + "\\index.txt")).get(2);
                    String piv = line.toLowerCase();
                    mails.swap(p, end - 1);
                    while (l < h) {
                        line = Files.readAllLines(Paths.get(((File) mails.get(l)).getPath() + "\\index.txt")).get(2);
                        String inl = line.toLowerCase();
                        line = Files.readAllLines(Paths.get(((File) mails.get(h)).getPath() + "\\index.txt")).get(2);
                        String inh = line.toLowerCase();
                        if (inl.compareTo(piv) < 0) {
                            l++;
                        } else if (inh.compareTo(piv) > 0 | inh.equals(piv)) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    line = Files.readAllLines(Paths.get(((File) mails.get(h)).getPath() + "\\index.txt")).get(2);
                    String inh = line.toLowerCase();
                    if (inh.compareTo(piv) < 0) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * it sort the double linked list Descending by the name of Sender of each e_main
     * @return a sorted double linked list of folders of e_mails by the name of Sender(Descending)
     */
    @Override
    public doubleLinkedList sortDescendingBySender() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortAscendingBySender();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
    }

    /**
     * it sort the double linked list by its priority(degree of importance) of subject of each e_main
     * @return a sorted double linked list of folders of e_mails by the its priority(degree of importance)
     */
    @Override
    public doubleLinkedList sortAscendingByPriority() throws ParseException, IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    String line = Files.readAllLines(Paths.get(((File) mails.get(p)).getPath() + "\\index.txt")).get(3);
                    int piv = Integer.parseInt(line);
                    mails.swap(p, end - 1);
                    while (l < h) {
                        line = Files.readAllLines(Paths.get(((File) mails.get(l)).getPath() + "\\index.txt")).get(3);
                        int inl = Integer.parseInt(line);
                        line = Files.readAllLines(Paths.get(((File) mails.get(h)).getPath() + "\\index.txt")).get(3);
                        int inh = Integer.parseInt(line);
                        if (inl < piv) {
                            l++;
                        } else if (inh >= piv) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    line = Files.readAllLines(Paths.get(((File) mails.get(h)).getPath() + "\\index.txt")).get(3);
                    int inh = Integer.parseInt(line);
                    if (inh < piv) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        else{
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * it sort the double linked list Descending by its priority(degree of importance) of subject of each e_main
     * @return a sorted double linked list of folders of e_mails by the its priority(degree of importance)(Descending)
     */
    @Override
    public doubleLinkedList sortDescendingByPriority() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortAscendingByPriority();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
    }

    /**
     * it returns the number of the lines in the body file of the mail
     * @param f is a file that we want to calculate its number of lines
     * @return the number of lines in the body file in that folder
     */
    private int numOfLinesInBody(File f) throws IOException {
        if (f!=null) {
            String line = Files.readAllLines(Paths.get((f.getPath() + "\\index.txt"))).get(1);
            FileReader fr = new FileReader(new File(f + "\\" + line + ".txt"));
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
     * it sort the double linked list by its Num Of Lines In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Lines In Body
     */
    @Override
    public doubleLinkedList sortAscendingByNumOfLinesInBody() throws ParseException, IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    int piv = numOfLinesInBody((File) mails.get(p));
                    mails.swap(p, end - 1);
                    while (l < h) {
                        int inl = numOfLinesInBody((File) mails.get(l));
                        int inh = numOfLinesInBody((File) mails.get(h));
                        if (inl < piv) {
                            l++;
                        } else if (inh >= piv) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    int inh = numOfLinesInBody((File) mails.get(h));
                    if (inh < piv) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        else{
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * it sort Descending the double linked list by its Num Of Lines In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Lines In Body(Descending)
     */
    @Override
    public doubleLinkedList sortDescendingByNumOfLinesInBody() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortAscendingByNumOfLinesInBody();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
    }

    /**
     * it returns the number of the words in the body file of the mail
     * @param f is a file that we want to calculate its number of words
     * @return the number of words in the body file in that folder
     */
    private int numOfWordsInBody(File f) throws IOException {
        if (f!=null) {
            String line = Files.readAllLines(Paths.get((f.getPath() + "\\index.txt"))).get(1);
            FileReader fr = new FileReader(new File(f + "\\" + line + ".txt"));
            BufferedReader br = new BufferedReader(fr);
            int numOfWords = 0;
            String line1;
            while (!((line1 = br.readLine()) == null)) {
                String[] s = (line1.split(" "));
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
     * it sort the double linked list by its Num Of Words In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Words In Body
     */
    @Override
    public doubleLinkedList sortAscendingByNumOfWordsInBody() throws ParseException, IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    int piv = numOfWordsInBody((File) mails.get(p));
                    mails.swap(p, end - 1);
                    while (l < h) {
                        int inl = numOfWordsInBody((File) mails.get(l));
                        int inh = numOfWordsInBody((File) mails.get(h));
                        if (inl < piv) {
                            l++;
                        } else if (inh >= piv) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    int inh = numOfWordsInBody((File) mails.get(h));
                    if (inh < piv) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * it sort Descending the double linked list by its Num Of Words In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Words In Body (Descending)
     */
    @Override
    public doubleLinkedList sortDescendingByNumOfWordsInBody() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortAscendingByNumOfWordsInBody();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
    }

    /**
     * it returns the number of the Letters in the body file of the mail
     * @param f is a file that we want to calculate its number of Letters
     * @return the number of Letters in the body file in that folder
     */
    private int numOfLettersInBody(File f) throws IOException {
        if (f!=null) {
            String line = Files.readAllLines(Paths.get((f.getPath() + "\\index.txt"))).get(1);
            FileReader fr = new FileReader(new File(f + "\\" + line + ".txt"));
            BufferedReader br = new BufferedReader(fr);
            int numOfLetters = 0;
            String line1;
            while (!((line1 = br.readLine()) == null)) {
                String[] s = (line1.split(" "));
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
     * it sort the double linked list by its Num Of Letters In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by its Num Of Letters In Body
     */
    @Override
    public doubleLinkedList sortAscendingByNumOfLettersInBody() throws ParseException, IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    int piv = numOfLettersInBody((File) mails.get(p));
                    mails.swap(p, end - 1);
                    while (l < h) {
                        int inl = numOfLettersInBody((File) mails.get(l));
                        int inh = numOfLettersInBody((File) mails.get(h));
                        if (inl < piv) {
                            l++;
                        } else if (inh >= piv) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    int inh = numOfLettersInBody((File) mails.get(h));
                    if (inh < piv) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * it sort Descending the double linked list by its Num Of Letters In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by its Num Of Letters In Body Descending
     */
    @Override
    public doubleLinkedList sortDescendingByNumOfLettersInBody() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortAscendingByNumOfLettersInBody();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
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
     * it sort the double linked list by its Num Of Receivers of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Receivers
     */
    @Override
    public doubleLinkedList sortAscendingByNumOfReceivers() throws ParseException, IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    int piv = numOfLinesInReceivers((File) mails.get(p));
                    mails.swap(p, end - 1);
                    while (l < h) {
                        int inl = numOfLinesInReceivers((File) mails.get(l));
                        int inh = numOfLinesInReceivers((File) mails.get(h));
                        if (inl < piv) {
                            l++;
                        } else if (inh >= piv) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    int inh = numOfLinesInReceivers((File) mails.get(h));
                    if (inh < piv) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * it sort Descending the double linked list by its Num Of Receivers of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Receivers(Descending)
     */
    @Override
    public doubleLinkedList sortDescendingByNumOfReceivers() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortAscendingByNumOfReceivers();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
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
     * it sort the double linked list by its Num Of Lines In Body of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Lines In Body
     */
    @Override
    public doubleLinkedList sortAscendingByNumOfAttachments() throws ParseException, IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    int piv = numOfAttachments((File) mails.get(p));
                    mails.swap(p, end - 1);
                    while (l < h) {
                        int inl = numOfAttachments((File) mails.get(l));
                        int inh = numOfAttachments((File) mails.get(h));
                        if (inl < piv) {
                            l++;
                        } else if (inh >= piv) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    int inh = numOfAttachments((File) mails.get(h));
                    if (inh < piv) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * it sort Descending the double linked list by its Num Of Attachments of each e_main
     * @return a sorted double linked list of folders of e_mails by the its Num Of Attachments(Descending)
     */
    @Override
    public doubleLinkedList sortDescendingByNumOfAttachments() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortAscendingByNumOfAttachments();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
    }
    /**
     * it sort a double linked list of contacts by them name(Ascending)
     * @return the sorted double linked list of contacts by them name
     * @throws IOException
     */
    public doubleLinkedList sortContactAscending() throws IOException {
        if (m!=null) {
            if (m.size() > 0) {
                doubleLinkedList mails = new doubleLinkedList();
                mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
                Stack s = new Stack();
                s.push(0);
                s.push(mails.size());
                while (!s.isEmpty()) {
                    int end = (int) s.pop();
                    int start = (int) s.pop();
                    if (end - start < 2) {
                        continue;
                    }
                    int p = start + ((end - start) / 2);
                    int l = start;
                    int h = end - 2;
                    String line = ((File) mails.get(p)).getName();
                    String temp[]=line.split(".txt");
                    String piv = temp[0].toLowerCase();
                    mails.swap(p, end - 1);
                    while (l < h) {
                        line = ((File) mails.get(l)).getName();
                        temp=line.split(".txt");
                        String inl = temp[0].toLowerCase();
                        line = ((File) mails.get(h)).getName() ;
                        temp=line.split(".txt");
                        String inh = temp[0].toLowerCase();
                        if (inl.compareTo(piv) < 0) {
                            l++;
                        } else if (inh.compareTo(piv) > 0 | inh.equals(piv)) {
                            h--;
                        } else {
                            mails.swap(l, h);
                        }
                    }
                    int idx = h;
                    line = ((File) mails.get(h)).getName();
                    temp=line.split(".txt");
                    String inh = temp[0].toLowerCase();
                    if (inh.compareTo(piv) < 0) {
                        idx++;
                    }
                    mails.swap(end - 1, idx);
                    p = idx;
                    s.push(p + 1);
                    s.push(end);
                    s.push(start);
                    s.push(p);
                }
                return mails;
            }
            else if(m.isEmpty()){
                return new doubleLinkedList();
            }
            else {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * it sort a double linked list of contacts by them name(Descending)
     * @return the sorted double linked list of contacts by them name
     * @throws IOException
     */
    public doubleLinkedList sortContactDescending() throws ParseException, IOException {
        doubleLinkedList mails = new doubleLinkedList();
        mails = sortContactAscending();
        for (int i=0;i<mails.size()/2;i++){
            mails.swap(i,mails.size()-1-i);
        }
        return  mails;
    }
}
