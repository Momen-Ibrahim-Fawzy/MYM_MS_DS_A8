package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.doubleLinkedList;

import java.io.*;

public class contact implements IContact{
    private String Name;
    private doubleLinkedList emails;
    private String password;
    private String birthDate;
    private String gender;
    private folder folder;
    //private SingleLinkedList.SingleLinkedListNode n= emails.head;
    public contact(){
        Name=null;
        password=null;
        birthDate=null;
        gender=null;
        emails = new doubleLinkedList();
    }
    /**
     * chwck the validity of the e_mail (in the format)
     * the e_mail should be @MYM.com
     * there must be only characters, numbers, under score"_", dash "-" and "@" sign and dot"." only
     * @param email the email wanted to be checked
     * @return true if the email follow the format and false if not
     */
    @Override
    public boolean checkEmail(String email){
        if (email!=null) {
            if (!email.matches("^[a-zA-Z0-9-_@.]*$")) {
                return false;
            }
            String[] arr = email.split("@", 5);
            if (arr.length > 2) {
                return false;
            }
            if (arr[1].length() != 7) {
                return false;
            }
            if (!email.contains("@mym.com")) {
                return false;
            }
            return true;
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * set the name of the contact
     * @param Name
     */
    @Override
    public void setName(String Name){
        this.Name=Name;
    }
    /**
     * add email to the contact
     * @param email
     */
    @Override
    public void setEmails(String email){
        if(checkEmail(email)==false){
            throw new RuntimeException("email is wrong");
        }
        emails.add(email);
    }
    /**
     * set the password of the contact
     * @param password
     */
    @Override
    public void setPassword(String password){
        if(!password.matches("^[a-zA-Z0-9-_]*$" )){
            throw new RuntimeException("error");
        }
        this.password=password;
    }
    /**
     * set the BirthDate of the contact
     * @param birthDate
     */
    @Override
    public void setBirthDate(String birthDate){
        this.birthDate=birthDate;
    }
    /**
     * set the Gender of the contact
     * @param address
     */
    @Override
    public void setGender(String address){
        this.gender=address;
    }
    /**
     * get the name of the contact
     * @return get the name of the contact
     */
    @Override
    public String getName(){
        return this.Name;
    }
    /**
     * get the password of the contact
     * @return get the password of the contact
     */
    @Override
    public String getPassword(){
        return this.password;
    }
    /**
     * get the BirthDate of the contact
     * @return get the BirthDate of the contact
     */
    @Override
    public String getBirthDate(){
        return this.birthDate;
    }
    /**
     * get the linked list of  Emails of the contact
     * @return et the linked list of  Emails of the contact
     */
    @Override
    public doubleLinkedList getEmails(){
        return this.emails;
    }
    /**
     * get the gendr of the contact
     * @return get the gendr of the contact
     */
    @Override
    public String getGender(){
        return this.gender;
    }
    /**
     * get the First Email in the contact
     * @return get the First Email in the contact
     */
    @Override
    public String getFirstEmail(){
        return (String)emails.get(0);
    }
    /**
     * make the contact file in the user folder
     * @param emails the linked list of the e_mails in the contact
     * @throws IOException if the file was null
     */
    @Override
    public void addContact(doubleLinkedList emails) throws IOException {
        if (emails!=null) {
            for (int i = 0; i < emails.size(); i++) {
                if (!folder.checkExistUserName((String) emails.get(i))) {
                    throw new RuntimeException("email is not in server");
                }

            }
            File file = new File(getFolder().getPath() + "/" + getName() + ".txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            for (int j = 0; j < emails.size(); j++) {
                fw.write((String) emails.get(j));
                fw.write("\r\n");   // write new line

            }
            fw.flush();
            fw.close();
        }
        else {
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
    /**
     * remove the contact file from the folder of the user
     * @throws IOException if the file was null
     */
    @Override
    public void removeContact() throws IOException {
        File file=new File(getFolder().getPath()+"/"+getName()+".txt");
        file.delete();
    }
    /**
     * rename the file of the contact in the user folder
     * @param newName the new name
     * @throws IOException if the file was null
     */
    @Override
    public void renameContact(String newName) throws IOException {
        File file=new File(getFolder().getPath()+"/"+getName()+".txt");
        File file1=new File(getFolder().getPath()+"/"+newName+".txt");
        file.renameTo(file1);
    }
    /**
     * delete email from the file of the contact in the user folder
     * @param email the name of the email wanted to be deleted
     * @throws IOException if the file was null
     */
    @Override
    public void deleteEmail(String email) throws IOException {
        File file=new File(getFolder().getPath()+"/"+getName()+".txt");
        folder.deleteLine(email,file);
        File des = new File(getFolder().getPath()+"/return.txt");
        folder.copyFileUsingChannel(des,file);
        des.delete();
    }
    /**
     * add email to the file of the contact in the user folder
     * @param email the name of the email wanted to be added
     * @throws IOException if the file was null
     */
    @Override
    public void addEmail(String email) throws IOException {
        if(folder.checkExistUserName(email))
            throw new RuntimeException("email is not in server");
        emails.add(email);
        addContact(emails);
    }
    /**
     * get the folder of that contact
     * @return the folder of that contact
     */
    @Override
    public eg.edu.alexu.csd.datastructure.mailServer.folder getFolder() {
        return folder;
    }
    /**
     * set the folder of that contact
     * @param folder the new folder of that contact
     */
    @Override
    public void setFolder(eg.edu.alexu.csd.datastructure.mailServer.folder folder) {
        this.folder = folder;
    }
    /**
     * check if the contact is valid for sign up or not
     * @return false if the contact is not available for sign up or true if the contact is available
     */
    @Override
    public  boolean checkContactForSignUp(){
        if(getName()==null ||getFirstEmail()==null || getPassword()==null|| getBirthDate()==null||getGender()==null){
            return false;
        }
        return true;
    }
    /**
     * check if the contact is valid or not
     * @return false if the contact is not available or true if the contact is available
     */
    @Override
    public  boolean checkContact(){
        if(getName()==null ||getEmails()==null ){
            return false;
        }
        return true;
    }



    public void sort() throws IOException {

    }
    public void search(){

    }
}

