package mailServer;

import java.io.File;
import java.io.IOException;

import linkedList.ILinkedList;
import linkedList.doubleLinkedList;

public class app implements IApp{
    public folder folder;
    private doubleLinkedList mails=new doubleLinkedList();//the double linked lis of arrays of mails
    /**
     * set the double linked list of arrays of mails
     * @param m should be double linked list of arrays of mails
     */
    public void setMails(doubleLinkedList m){
        if (!m.isEmpty()) {
            mails = (doubleLinkedList) m.sublist(0, m.size() - 1);
        }
        else mails=null;
    }
    /**
     * get the double linked list of arrays of mails
     * @return the double linked list of arrays of mails
     */
    public doubleLinkedList getMails(){
        return mails;
    }
    public app(){
        folder=new folder();
        folder.setPath("System");
    }

    private doubleLinkedList mailsToBeShown=new doubleLinkedList();
    /**
     * set the mails to be shown
     * @param mailsToBeShown the new emails to be shown
     */
    public void setMailsToBeShown(doubleLinkedList mailsToBeShown) {
        this.mailsToBeShown = mailsToBeShown;
    }
    /**
     * return the double linked list of the mails to be shown
     * @return the double linked list of the mails to be shown
     */
    public doubleLinkedList getMailsToBeShown() {
        return mailsToBeShown;
    }
    /**
     * Sign in to the application
     * @param email
     * @param password
     * @return false if the email name not exist
     */
    @Override
    public boolean signin(String email, String password) {
        boolean check1=folder.checkExistUsername(email);
        boolean check2=folder.checkPassword(email,password);
        if(check1==true && check2==true)
            return true;
        return false;
    }
    /**
     * Create new account
     * @param contact
     * @return false if the email name already exist
     */
    @Override
    public boolean signup(IContact contact) {
        if(folder.checkExistUsername(contact.getFirstEmail()))
            return  false;

        return true;
    }
    /**
     * This function should be called before reading from the index file
     * and apply the sort and search parameters
     * @param folder currently shown, can be null
     * @param filter to apply search, can be null
     * @param sort to apply sort
     */
    @Override
    public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
        if(folder!=null){
            folder fold = (folder)folder;
            doubleLinkedList mails=new doubleLinkedList();
            if (new File(folder.getPath()).getName().equals("Trash")){
                try {
                    mails =fold.getMailsFoldersForTrash();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (new File(folder.getPath()).getName().equals("Contact")){
                File f= new File(folder.getPath());
                File[] files = f.listFiles();
                for (int i=0 ; i<files.length;i++){
                    if (files[i].isFile()){
                        mails.add(files[i]);
                    }
                }
            }
            else {
                mails = fold.getMailsFolders();
            }
            if (filter!=null){
                filter filt = (filter) filter;
                filt.setMails(mails);
                doubleLinkedList filteredMails=new doubleLinkedList();
                switch (filt.getType()) {
                    case "":
                        filteredMails=mails;
                        break;
                    case "filterByDate":
                        try {
                            filteredMails = filt.filterByCompleteDate(filt.getDate());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterBySubject":
                        try {
                            filteredMails = filt.filterBySubject(filt.getSubject());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterBySender":
                        try {
                            filteredMails = filt.filterBySender(filt.getSender());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterByPriority":
                        try {
                            filteredMails = filt.filterByPriority(filt.getPriority());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterByNumOfReceivers":
                        try {
                            filteredMails = filt.filterByNumOfReceivers(filt.getNumOfReceivers());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterByNumOfAttachments":
                        try {
                            filteredMails = filt.filterByNumOfAttachments(filt.getNumOfAttachments());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterByNumOfLinesInBody":
                        try {
                            filteredMails = filt.filterByNumOfLinesInBody(filt.getNumOfLinesInBody());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterByNumOfWordsInBody":
                        try {
                            filteredMails = filt.filterByNumOfWordsInBody(filt.getNumOfWordsInBody());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterByNumOfLettersInBody":
                        try {
                            filteredMails = filt.filterByNumOfLettersInBody(filt.getNumOfLettersInBody());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterByReceiver":
                        try {
                            filteredMails = filt.filterByReceiver(filt.getReceiver());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                    case "filterContactByName":
                        try {
                            filteredMails = filt.filterContactByName(filt.getNameOfContact());
                        } catch (Exception e) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                        break;
                }
                if (sort!=null) {
                    sort s = (sort) sort;
                    s.setMails(filteredMails);
                    doubleLinkedList sortedMails = new doubleLinkedList();
                    switch (s.getType()){
                        case "" :
                            sortedMails=filteredMails;
                            break;
                        case"sortByDateOldestToNewest":
                            try {
                                sortedMails=s.sortByDateOldestToNewest();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortByDateNewestToOldest":
                            try {
                                sortedMails=s.sortByDateNewestToOldest();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingBySubject":
                            try {
                                sortedMails=s.sortAscendingBySubject();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingBySubject":
                            try {
                                sortedMails=s.sortDescendingBySubject();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingBySender":
                            try {
                                sortedMails=s.sortAscendingBySender();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingBySender":
                            try {
                                sortedMails=s.sortDescendingBySender();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByPriority":
                            try {
                                sortedMails=s.sortAscendingByPriority();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByPriority":
                            try {
                                sortedMails=s.sortDescendingByPriority();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfLinesInBody":
                            try {
                                sortedMails=s.sortAscendingByNumOfLinesInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfLinesInBody":
                            try {
                                sortedMails=s.sortDescendingByNumOfLinesInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfWordsInBody":
                            try {
                                sortedMails=s.sortAscendingByNumOfWordsInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfWordsInBody":
                            try {
                                sortedMails=s.sortDescendingByNumOfWordsInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfLettersInBody":
                            try {
                                sortedMails=s.sortAscendingByNumOfLettersInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfLettersInBody":
                            try {
                                sortedMails=s.sortDescendingByNumOfLettersInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfReceivers":
                            try {
                                sortedMails=s.sortAscendingByNumOfReceivers();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfReceivers":
                            try {
                                sortedMails=s.sortDescendingByNumOfReceivers();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfAttachments":
                            try {
                                sortedMails=s.sortAscendingByNumOfAttachments();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfAttachments":
                            try {
                                sortedMails=s.sortDescendingByNumOfAttachments();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortContactAscending":
                            try {
                                sortedMails=s.sortContactAscending();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortContactDescending":
                            try {
                                sortedMails=s.sortContactDescending();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                    }
                    try {
                        if (new File(folder.getPath()).getName().equals("Contact")){
                            doubleLinkedList list=new doubleLinkedList();
                            int num=0;
                            int count=0;
                            if(sortedMails.size()%10==0){
                                num=sortedMails.size()/10;
                            }
                            else {
                                num=(sortedMails.size()/10)+1;
                            }
                            //System.out.println("/"+num);
                            for (int i=0;i<num;i++){
                                File[] arr=new File[10];
                                for (int j=0;j<arr.length;j++){
                                    if(count>=sortedMails.size())
                                        break;
                                    arr[j]=(File)sortedMails.get(count);
                                    count++;
                                }
                                list.add(arr);
                            }
                            mailsToBeShown =list;
                        }
                        else {
                            mailsToBeShown = folder.mails(sortedMails);
                        }
                    } catch (Exception e) {
                    	
                        RuntimeException Runtime = new RuntimeException();
                    	throw Runtime;
                    }
                }
                else {
                    try {
                        if (new File(folder.getPath()).getName().equals("Contact")){
                            doubleLinkedList list=new doubleLinkedList();
                            int num=0;
                            int count=0;
                            if(filteredMails.size()%10==0){
                                num=filteredMails.size()/10;
                            }
                            else {
                                num=(filteredMails.size()/10)+1;
                            }
                            //System.out.println("/"+num);
                            for (int i=0;i<num;i++){
                                File[] arr=new File[10];
                                for (int j=0;j<arr.length;j++){
                                    if(count>=filteredMails.size())
                                        break;
                                    arr[j]=(File)filteredMails.get(count);
                                    count++;
                                }
                                list.add(arr);
                            }
                            mailsToBeShown =list;
                        }
                        else {
                            mailsToBeShown = folder.mails(filteredMails);
                        }
                    } catch (Exception e) {
                        RuntimeException Runtime = new RuntimeException();
                        throw Runtime;
                    }
                }
            }
            else{
                if (sort!=null){
                    sort s = (sort) sort;
                    s.setMails(mails);
                    doubleLinkedList sortedMails = new doubleLinkedList();
                    switch (s.getType()){
                        case"sortByDateOldestToNewest":
                            try {
                                sortedMails=s.sortByDateOldestToNewest();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortByDateNewestToOldest":
                            try {
                                sortedMails=s.sortByDateNewestToOldest();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingBySubject":
                            try {
                                sortedMails=s.sortAscendingBySubject();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingBySubject":
                            try {
                                sortedMails=s.sortDescendingBySubject();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingBySender":
                            try {
                                sortedMails=s.sortAscendingBySender();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingBySender":
                            try {
                                sortedMails=s.sortDescendingBySender();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByPriority":
                            try {
                                sortedMails=s.sortAscendingByPriority();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByPriority":
                            try {
                                sortedMails=s.sortDescendingByPriority();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfLinesInBody":
                            try {
                                sortedMails=s.sortAscendingByNumOfLinesInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfLinesInBody":
                            try {
                                sortedMails=s.sortDescendingByNumOfLinesInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfWordsInBody":
                            try {
                                sortedMails=s.sortAscendingByNumOfWordsInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfWordsInBody":
                            try {
                                sortedMails=s.sortDescendingByNumOfWordsInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfLettersInBody":
                            try {
                                sortedMails=s.sortAscendingByNumOfLettersInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfLettersInBody":
                            try {
                                sortedMails=s.sortDescendingByNumOfLettersInBody();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfReceivers":
                            try {
                                sortedMails=s.sortAscendingByNumOfReceivers();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfReceivers":
                            try {
                                sortedMails=s.sortDescendingByNumOfReceivers();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortAscendingByNumOfAttachments":
                            try {
                                sortedMails=s.sortAscendingByNumOfAttachments();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortDescendingByNumOfAttachments":
                            try {
                                sortedMails=s.sortDescendingByNumOfAttachments();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "" :
                            sortedMails=mails;
                            break;
                        case "sortContactAscending":
                            try {
                                sortedMails=s.sortContactAscending();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                        case "sortContactDescending":
                            try {
                                sortedMails=s.sortContactDescending();
                            } catch (Exception e) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            break;
                    }
                    try {
                        if (new File(folder.getPath()).getName().equals("Contact")){
                            doubleLinkedList list=new doubleLinkedList();
                            int num=0;
                            int count=0;
                            if(sortedMails.size()%10==0){
                                num=sortedMails.size()/10;
                            }
                            else {
                                num=(sortedMails.size()/10)+1;
                            }
                            System.out.println("/"+num);
                            for (int i=0;i<num;i++){
                                File[] arr=new File[10];
                                for (int j=0;j<arr.length;j++){
                                    if(count>=sortedMails.size())
                                        break;
                                    arr[j]=(File)sortedMails.get(count);
                                    count++;
                                }
                                list.add(arr);
                            }
                            mailsToBeShown =list;
                        }
                        else {
                            mailsToBeShown = folder.mails(sortedMails);
                        }
                    } catch (Exception e) {
                        RuntimeException Runtime = new RuntimeException();
                        throw Runtime;
                    }
                }
                else {
                    try {
                        if (new File(folder.getPath()).getName().equals("Contact")){
                            doubleLinkedList list=new doubleLinkedList();
                            int num=0;
                            int count=0;
                            if(mails.size()%10==0){
                                num=mails.size()/10;
                            }
                            else {
                                num=(mails.size()/10)+1;
                            }
                            System.out.println("/"+num);
                            for (int i=0;i<num;i++){
                                File[] arr=new File[10];
                                for (int j=0;j<arr.length;j++){
                                    if(count>=mails.size())
                                        break;
                                    arr[j]=(File)mails.get(count);
                                    count++;
                                }
                                list.add(arr);
                            }
                            mailsToBeShown =list;
                        }
                        else {
                            mailsToBeShown = folder.mails(mails);
                        }
                    } catch (Exception e) {
                        RuntimeException Runtime = new RuntimeException();
                        throw Runtime;
                    }
                }
            }
        }
        else {
            //there is no folder to be shown its e_mauls
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
        //here i have the mails to be shown to the user in form Linked List Of Arrays of IMails
        //and it is set
    }
    /**
     * You should use setViewingOptions function first
     * @param page to handle paging
     * @return list of emails
     */
    @Override
    public IMail[] listEmails(int page) {
        if (page>0 && (!mailsToBeShown.isEmpty())) {
            return (IMail[]) mailsToBeShown.get(page - 1);
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * You should use setViewingOptions function first
     * @param mails to be moved to trash
     */
    @Override
    public void deleteEmails(ILinkedList mails) {
        IFolder des = new folder() ;
        des.setPath(folder.backStep()+"/Trash");
        moveEmails(mails,des);
    }
    /**
     * You should use setViewingOptions function first
     * @param mails to be moved
     * @param des the destination folder
     */
    @Override
    public void moveEmails(ILinkedList mails, IFolder des) {
        for (int i=0;i<mails.size();i++){
            try {
                folder.move(((File)mails.get(i)).getPath(),des.getPath()+"/"+((File)mails.get(i)).getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Send a new email
     * @param email should contain all the information needed
     * sender, list of receivers, list of attachments, email body, ...
     * @return false if something wrong happened like sending to non-existing user.
     */
    @Override
    public boolean compose(IMail email)
    {
        if(!email.checkMail())
            return false;
        return true;

    }
	
}
