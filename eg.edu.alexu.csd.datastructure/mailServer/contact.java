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




    public void setName(String Name){
        this.Name=Name;
    }
    public void setEmails(String email){
        if(checkEmail(email)==false){
            throw new RuntimeException("email is wrong");
        }
        emails.add(email);
    }
    public void setPassword(String password){
        if(!password.matches("^[a-zA-Z0-9-_]*$" )){
            throw new RuntimeException("error");
        }
        this.password=password;
    }
    public void setBirthDate(String birthDate){
        this.birthDate=birthDate;
    }
    public void setGender(String address){
        this.gender=address;
    }
    public String getName(){
        return this.Name;
    }
    public String getPassword(){
        return this.password;
    }

    public String getBirthDate(){
        return this.birthDate;
    }
    public SingleLinkedList getEmails(){
        return this.emails;
    }
    public String getGender(){
        return this.gender;
    }
    public String getFirstEmail(){
        return (String)emails.get(0);
    }


    public void addContact(SingleLinkedList emails) throws IOException {
        for(int i=0;i<emails.size();i++) {
            if (!folder.check_exist_username((String) emails.get(i))) {
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
    public void removeContact() throws IOException {
        File file=new File(getFolder().getPath()+"/"+getName()+".txt");
        file.delete();
    }
    public void renameContact(String newName) throws IOException {
        File file=new File(getFolder().getPath()+"/"+getName()+".txt");
        File file1=new File(getFolder().getPath()+"/"+newName+".txt");
        file.renameTo(file1);
    }
    public void deleteEmail(String email) throws IOException {
        File file=new File(getFolder().getPath()+"/"+getName()+".txt");
        folder.delete_line(email,file);
        File des = new File(getFolder().getPath()+"/return.txt");
        folder.copyFileUsingChannel(des,file);
        des.delete();


    }
    public void addEmail(String email) throws IOException {
        if(folder.check_exist_username(email))
            throw new RuntimeException("email is not in server");
        emails.add(email);
        addContact(emails);
    }

    public void sort() throws IOException {

    }
    public void search(){

    }


    public eg.edu.alexu.csd.datastructure.mailServer.folder getFolder() {
        return folder;
    }

    public void setFolder(eg.edu.alexu.csd.datastructure.mailServer.folder folder) {
        this.folder = folder;
    }


    public  boolean checkContactForSignUp(){
        if(getName()==null ||getFirstEmail()==null || getPassword()==null|| getBirthDate()==null||getGender()==null){
            return false;
        }
        return true;
    }

    public  boolean checkContact(){
        if(getName()==null ||getEmails()==null ){
            return false;
        }
        return true;
    }
}

