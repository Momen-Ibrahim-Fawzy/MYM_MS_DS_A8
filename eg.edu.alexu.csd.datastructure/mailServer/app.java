package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class app implements IApp {
    public folder folder;

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
