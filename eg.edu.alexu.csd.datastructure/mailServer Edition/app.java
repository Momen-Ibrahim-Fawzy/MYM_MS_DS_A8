package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.doubleLinkedList;

import java.io.File;
import java.io.IOException;

public class app implements IApp{
    public folder folder;
    private doubleLinkedList mails=new doubleLinkedList();//the double linked lis of arrays of mails
    /**
     * set the double linked list of arrays of mails
     * @param m should be double linked list of arrays of mails
     */
    public void setMails(doubleLinkedList m){
        if (m!=null) {
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

    @Override
    public boolean signin(String email, String password) {
        boolean check1=folder.checkExistUserName(email);
        boolean check2=folder.checkPassword(email,password);
        if(check1==true && check2==true)
            return true;
        return false;
    }

    @Override
    public boolean signup(IContact contact) {
        if(folder.checkExistUserName(contact.getFirstEmail()))
            return  false;

        return true;
    }
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
                    }
                    try {
                        mailsToBeShown=folder.mails(sortedMails);
                    } catch (Exception e) {
                        RuntimeException Runtime = new RuntimeException();
                        throw Runtime;
                    }
                }
                else {
                    try {
                        mailsToBeShown=folder.mails(filteredMails);
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
                    }
                    try {
                        mailsToBeShown=folder.mails(sortedMails);
                    } catch (Exception e) {
                        RuntimeException Runtime = new RuntimeException();
                        throw Runtime;
                    }
                }
                else {
                    try {
                        mailsToBeShown=folder.mails(mails);
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
    @Override
    public IMail[] listEmails(int page) {
        if (page>0&mailsToBeShown!=null) {
            return (IMail[]) mailsToBeShown.get(page - 1);
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    @Override
    public void deleteEmails(ILinkedList mails) {
        IFolder des = new folder() ;
        des.setPath(folder.backStep()+"/Trash");
        moveEmails(mails,des);
    }

    @Override
    public void moveEmails(ILinkedList mails, IFolder des) {
        for (int i=0;i<mails.size();i++){
            try {
                folder.move(((File)mails.get(i)),new File(des.getPath()+"/"+((File)mails.get(i)).getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean compose(IMail email) {
        return false;
    }
    ///////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws IOException, ParseException {
        app momen = new app();
        folder fold = new folder();
        fold.setPath("System\\Ahmed\\index");
        sort s=new sort();
        s.setType("sortByDateNewestToOldest");
        filter f=new filter();
        f.setType("filterByPriority");
        f.setPriority(2);
        momen.setViewingOptions(fold,f,s);
        for (int i=0;i<10;i++){
            if(((IMail[])momen.getMailsToBeShown().get(0))[i]!=null){
                System.out.println(((IMail[])momen.getMailsToBeShown().get(0))[i].getSender());
            }
        }
        System.out.println("///////////////////////////////");
        f.setType("filterBySender");
        f.setSender("mohammed Ahmed");
        momen.setViewingOptions(fold,f,s);
        for (int i=0;i<10;i++){
            if(((IMail[])momen.getMailsToBeShown().get(0))[i]!=null){
                System.out.println(((IMail[])momen.getMailsToBeShown().get(0))[i].getSender());
            }
        }
        System.out.println("///////////////////////////////");
        f.setType("filterBySubject");
        f.setSubject("yougert");
        momen.setViewingOptions(fold,f,s);
        for (int i=0;i<10;i++){
            if(((IMail[])momen.getMailsToBeShown().get(0))[i]!=null){
                System.out.println(((IMail[])momen.getMailsToBeShown().get(0))[i].getSender());
            }
        }
        System.out.println("///////////////////////////////");
        f.setType("");
        momen.setViewingOptions(fold,f,s);
        for (int i=0;i<10;i++){
            if(((IMail[])momen.getMailsToBeShown().get(0))[i]!=null){
                System.out.println(((IMail[])momen.getMailsToBeShown().get(0))[i].getSender());
            }
        }
        System.out.println("///////////////////////////////");
        f.setType("");
        s.setType("sortAscendingBySubject");
        momen.setViewingOptions(fold,f,s);
        for (int i=0;i<10;i++){
            if(((IMail[])momen.getMailsToBeShown().get(0))[i]!=null){
                System.out.println(((IMail[])momen.getMailsToBeShown().get(0))[i].getSender());
            }
        }
        System.out.println("///////////////////////////////");
        f.setType("filterByDate");
        f.setDate(new SimpleDateFormat("dd/MM/yyy").parse("9/7/2017"));
        momen.setViewingOptions(fold,f,s);
        for (int i=0;i<10;i++){
            if(((IMail[])momen.getMailsToBeShown().get(0))[i]!=null){
                System.out.println(((IMail[])momen.getMailsToBeShown().get(0))[i].getSender());
            }
        }
        System.out.println("///////////////////////////////");
        f.setType("filterByDate");
        f.setDate(new SimpleDateFormat("dd/MM/yyy").parse("12/7/2017"));
        momen.setViewingOptions(fold,f,s);
        for (int i=0;i<10;i++){
            if(((IMail[])momen.getMailsToBeShown().get(0))[i]!=null){
                System.out.println(((IMail[])momen.getMailsToBeShown().get(0))[i].getSender());
            }
        }
    }
}
