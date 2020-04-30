package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.SingleLinkedList;

import java.io.*;
import java.util.Collections;

public class contact implements IContact{
    private String Name;
    private SingleLinkedList emails;
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
        emails = new SingleLinkedList();
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
        if(!email.matches("^[a-zA-Z0-9-_@.]*$" )){
            return false;
        }
        String[] arr=email.split("@",5);
        if (arr.length>2){
            return false;
        }
        if(arr[1].length()!=7){
            return false;
        }
        if(!email.contains("@mym.com")){
            return false;
        }
        return true;
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
     * 
     * @return
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
     * get the gendr of the contact
     * @return get the gendr of the contact
     */
    @Override
    public SingleLinkedList getEmails(){
        return this.emails;
    }
    /**
     * get the First Email in the contact
     * @return get the First Email in the contact
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
    public void addContact(SingleLinkedList emails) throws IOException {
        for(int i=0;i<emails.size();i++) {
            if (!folder.checkExistUsername((String) emails.get(i))) {
                throw new RuntimeException("email is not in server");
            }

        }
        File file=new File(getFolder().getPath()+"/"+getName()+".txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        for(int j=0;j<emails.size();j++) {
               fw.write((String) emails.get(j));
               fw.write("\r\n");   // write new line

        }
        fw.flush();
        fw.close();
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
        if(folder.checkExistUsername(email))
            throw new RuntimeException("email is not in server");
        emails.add(email);
        addContact(emails);
    }

    /**
     * get the folder of that contact
     * @return the folder of that contact
     */
    public folder getFolder() {
        return folder;
    }
    /**
     * set the folder of that contact
     * @param folder the new folder of that contact
     */
    @Override
    public void setFolder(folder folder) {
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
}

