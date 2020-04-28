package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class app implements IApp {
    public folder folder;
    ////////momenEdition///////
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
    /////////////////////////
    public app(){
        folder=new folder();
        folder.setPath("System");
    }

    @Override
    public boolean signin(String email, String password) {
        boolean check1=folder.check_exist_username(email);
        boolean check2=folder.check_password(email,password);
        if(check1==true && check2==true)
            return true;
        return false;
    }

    @Override
    public boolean signup(contact contact) {
        if(folder.check_exist_username(contact.getFirstEmail()))
            return  false;

        return true;
    }

    @Override
    public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
        doubleLinkedList mailsToBeShown=new doubleLinkedList();
        if(folder!=null){
            folder fold = (folder)folder;
            doubleLinkedList mails = (fold).getMailsFolders();
            if (filter!=null){
                filter filt = (filter) filter;
                filt.setMails(mails);
                doubleLinkedList filteredMails=new doubleLinkedList();
                switch (filt.getType()) {
                    case "filterByDate":
                        try {
                            filteredMails = filt.filterByDate(filt.getDate());
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
                    //maisToBeShown=LinkedListOfArrays(sortedMails);
                    //then set it
                }
                else {
                    //maisToBeShown=LinkedListOfArrays(filteredMails);
                    //then set it
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
                    }
                }
                else {
                    //maisToBeShown=LinkedListOfArrays(mails);
                    //then set it
                }
            }
        }
        else {
            //maisToBeShown=LinkedListOfArrays(mailsToBeShown);
            //then set it
        }
        //here i have the mails to be shown to the user in form Linked List Of Arrays of IMails
        //and it is set
    }

    @Override
    public IMail[] listEmails(int page) {
        return new IMail[0];
    }

    @Override
    public void deleteEmails(ILinkedList mails) {

    }

    @Override
    public void moveEmails(ILinkedList mails, IFolder des) {

    }

    @Override
    public boolean compose(IMail email) {
        return false;
    }
}
