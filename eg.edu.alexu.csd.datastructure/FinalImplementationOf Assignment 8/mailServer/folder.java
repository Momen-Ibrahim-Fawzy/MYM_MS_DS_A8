package mailServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import linkedList.ILinkedList;
import linkedList.doubleLinkedList;

public class folder implements IFolder {
    private File system=new File("System");
    private File index=new File("System/indexOfUser.txt");
    private File num=new File("System/num.txt");
    @SuppressWarnings("unused")
	private String UserName;
    @SuppressWarnings("unused")
	private String PassWord;
    private String path;

    /**
     * constructor to create system folder and its index
     */
    public folder() {
        if(!system.exists()) {
            system.mkdir();
            try {
                index.createNewFile();
                num.createNewFile();
                FileWriter x1=new FileWriter(num);
                x1.write(Integer.toString(1));
                x1.flush();
                x1.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    /**
     * check if the user name is stored or not
     * @param username the user name which wanted to be checked
     * @return false if the user name is not stored or true if it stored
     */
    public boolean checkExistUsername(String username) {
        if(username==null)
            return false;
        for(File f:system.listFiles()) {
            if(f.getName().equals(username))
                return true;
        }
        return false;
    }
    /**
     * check if two strings are equal or not
     * @param s1 the first string
     * @param s2 the second string
     * @return
     */
    public boolean checkEqualityOfTwoStrings(String s1,String s2) {
        if(s1==null||s2==null) {
            return false;
        }
        int i=0;
        while(i<s1.length()){
            if(s1.charAt(i)!=s2.charAt(i))
                return false;
            else
                i++;
        }
        if(i==s1.length()&&i==s2.length())
            return true;
        else
            return false;

    }
    /**
     * check if the user name is stored and then compare its password with the taken one
     * @param userName the name of the user
     * @param password the password which wanted to be checked of that user name
     * @return true if the user name is stored and the password is true or return false in any other case
     */
    public boolean checkPassword(String userName ,String password) {
        try {
            FileReader fr = new FileReader(index);
            @SuppressWarnings("resource")
            BufferedReader in=new BufferedReader(fr);
            String line;
            while((line=in.readLine())!=null) {
                //System.out.println(line);
                if(checkEqualityOfTwoStrings(line,userName)) {
                    line=in.readLine();
                    if(checkEqualityOfTwoStrings(line,password)) {
                        System.out.println("email is found and correct password");
                        return true;
                    }
                    else {
                        System.out.println("email is found and wrong password");
                        return false;
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    /**
     * creat a folder for user
     * @param contact which contain the user nameof that user
     */
    public void creatUsersFolder(contact contact) {
        boolean check=checkExistUsername(contact.getFirstEmail());
        System.out.println(check);
        if(check)
            System.out.println("folder is exist");
        else {
            File user=new File("System/"+contact.getFirstEmail());
            user.mkdir();
            createSubFolders(contact);
            System.out.println("folder is create");
            try {
                BufferedWriter write=new BufferedWriter(new FileWriter(index,true));
                write.write(contact.getFirstEmail());
                write.newLine();
                write.write(contact.getPassword());
                write.newLine();
                write.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    /**
     * after login we need to create a folders to the new account.
     * @param contact
     */
    public void createSubFolders(contact contact) {
        File user=new File("System/"+contact.getFirstEmail()+"/Contact");
        File user1=new File("System/"+contact.getFirstEmail()+"/Draft");
        File user2=new File("System/"+contact.getFirstEmail()+"/Inbox");
        File user3=new File("System/"+contact.getFirstEmail()+"/Sent");
        File user4=new File("System/"+contact.getFirstEmail()+"/Trash");
        File user5=new File("System/"+contact.getFirstEmail()+"/IndexUserInfo.txt");
        File user6=new File("System/"+contact.getFirstEmail()+"/Contact/index.txt");
        File user7=new File("System/"+contact.getFirstEmail()+"/Draft/index.txt");
        File user8=new File("System/"+contact.getFirstEmail()+"/Inbox/index.txt");
        File user9=new File("System/"+contact.getFirstEmail()+"/Sent/index.txt");
        File user10=new File("System/"+contact.getFirstEmail()+"/Trash/index.txt");
        user.mkdir();
        user1.mkdir();
        user2.mkdir();
        user3.mkdir();
        user4.mkdir();
        try {
            user5.createNewFile();
            BufferedWriter write=new BufferedWriter(new FileWriter(user5,true));
            write.write(contact.getName());
            write.newLine();
            write.write(contact.getFirstEmail());
            write.newLine();
            write.write(contact.getPassword());
            write.newLine();
            write.write(contact.getBirthDate());
            write.newLine();
            write.write(contact.getGender());
            write.newLine();
            DateFormat df=new SimpleDateFormat("dd/MM/yyyy \nHH:mm:ss");
            Calendar co=Calendar.getInstance();
            write.write(df.format(co.getTime()));
            write.newLine();
            write.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void CheckExistOfIndexOfUsers() {
        boolean check=checkExistUsername("indexOfUser");
        //System.out.println(check);
        if(!check) {
            returnInboxUser();
        }

    }
    public void returnInboxUser() {
        File returnFile=new File("return");
        try {
            returnFile.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        for(File f:system.listFiles()) {
            File f1=new File("System/"+f.getName()+"/IndexUserInfo");
            FileReader fr;
            try {
                fr = new FileReader(f1);
                BufferedReader in=new BufferedReader(fr);
                String line;
                int i=0;
                while(i<2) {
                    line=in.readLine();
                    writer_method(line,returnFile);
                    i++;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        copy_files(returnFile);
        returnFile.delete();

    }
    public void writer_method(String line , File name ) {
        try {
            BufferedWriter write=new BufferedWriter(new FileWriter(name,true));
            write.write(line);
            write.newLine();
            write.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void copy_files(File name){
        try {
            Files.copy(name.toPath(),index.toPath());
        }
        catch(Exception e) {
            System.out.print("error");
        }
    }
    /**
     * make sure of the sub folders of the file  of the user
     * @param username which wanted to check the folders in its folder
     */
    public void checkSubFolders(String username) {
        check_Contact(username);
        check_draft(username);
        check_Sent(username);
        check_Trash(username);
        check_inbox(username);
    }
    private void check_Contact(String username) {
        File s=new File("System/"+username);
        boolean check=false;
        for(File f:s.listFiles()) {
            if(f.getName().contains("Contact"))
                check=true;
        }
        if(!check) {
            File user=new File("System/"+username+"/Contact");
            user.mkdir();
        }
    }
    private void check_draft(String username) {
        File s=new File("System/"+username);
        boolean check=false;
        for(File f:s.listFiles()) {
            if(f.getName().contains("Draft"))
                check=true;
        }
        if(!check) {
            File user=new File("System/"+username+"/Draft");
            user.mkdir();
        }
    }
    private void check_Sent(String username) {
        File s=new File("System/"+username);
        boolean check=false;
        for(File f:s.listFiles()) {
            if(f.getName().contains("Sent"))
                check=true;
        }
        if(!check) {
            File user=new File("System/"+username+"/Sent");
            user.mkdir();
        }
    }
    private void check_Trash(String username) {
        File s=new File("System/"+username);
        boolean check=false;
        for(File f:s.listFiles()) {
            if(f.getName().contains("Trash"))
                check=true;
        }
        if(!check) {
            File user=new File("System/"+username+"/Trash");
            user.mkdir();
        }
    }
    private void check_inbox(String username) {
        File s=new File("System/"+username);
        boolean check=false;
        for(File f:s.listFiles()) {
            if(f.getName().contains("Inbox"))
                check=true;
        }
        if(!check) {
            File user=new File("System/"+username+"/Inbox");
            user.mkdir();
        }
    }
    /**
     * delete the Index Of the User
     */
    public void deleteIndexOfUser() {
        index.delete();
    }
    /**
     * copy File to other file Using Channel
     * @param source the source file which wanted to copied
     * @param dest the destination file which wanted to copy in
     * @throws IOException if the file was null
     */
    public  void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }finally{
            sourceChannel.close();
            destChannel.close();
        }
    }
    /**
     * move File to other file Using Channel
     * @param path1 the source file which wanted to be moved
     * @param path2 the destination file which wanted to moove to
     * @throws IOException if the file was null
     */
    public  void move(String path1,String path2) throws IOException {
        Path temp = Files.move
                (Paths.get(path1),
                        Paths.get(path2));
        if(temp != null)
        {
            System.out.println("File renamed and moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    }
    /**
     * delete a specific line from a file
     * @param line the line which wanted to be deleted
     * @param file the file in which the line will be deleted
     */
    public void deleteLine(String line,File file) {
        File new_file=new File(getPath()+"/return.txt");
        try {
            new_file.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        FileReader fr;
        try {

        	fr = new FileReader(file) ;
            @SuppressWarnings("resource")
            BufferedReader in=new BufferedReader(fr);
            String line1;
            while(!((line1=in.readLine())==null)) {
                if(!checkEqualityOfTwoStrings(line,line1)) {
                    writer_method(line1,new_file);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * copy file to other one
     * @param name1 the source file
     * @param name2 the destination file
     */
    public void copyFiles(String name1 , String name2) {
        File f1=new File(name1);
        File f2=new File(name2);
        if(!f2.exists()) {
            try {
                f2.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        FileReader fr;
        try {
            fr = new FileReader(f1);
            @SuppressWarnings("resource")
            BufferedReader in=new BufferedReader(fr);
            String line1;
            while(!((line1=in.readLine())==null)) {
                writer_method(line1,f2);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     * sent the path of the folder then it will delete
     * @param filePath the path of the folder to be deleted
     */
    public void deleteFolder(String filePath) {
        File f1=new File(filePath);
        if(!checkIfIsEmpty(f1)) {
            for(File f:f1.listFiles()) {
                deleteFolder(filePath+"/"+f.getName());
            }
        }
        f1.delete();
    }
    /**
     * check If the file is Empty
     * @param f the file which wanted to check if it i empty or not
     * @return true if the file is empty or false if it is not empty
     */
    public boolean checkIfIsEmpty(File f) {
        if(f.isDirectory()&&f.list().length>0) {
            return false;
        }
        return true;
    }
    public int [][] num_of_word(String path_name) {
        int[][]arr=new int[1][2];
        File f1=new File(path_name);
        int num_of_word=0;
        int num_of_line=0;
        FileReader fr;
        try {
            fr = new FileReader(f1);
            @SuppressWarnings("resource")
            BufferedReader in=new BufferedReader(fr);
            String line1;
            while(!((line1=in.readLine())==null)) {
                num_of_word+=num_in_line(line1);
                num_of_line++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        arr[0][0]=num_of_line;
        arr[0][1]=num_of_word;
        return arr;
    }
    private int num_in_line(String line1) {
        if(line1==null||line1.isEmpty())
            return 0;
        String []words=line1.split("\\s+");
        return words.length;
    }
    /**
     * return the path of that folder
     * @return the path of that folder
     */
    public String getPath() {
        return path;
    }
    /**
     * set the path of that folder
     * @param path the new path
     */
    public void setPath(String path) {
        this.path = path;
    }
    /**
     * get the name of the folder which contain that folder
     * @return the name of the folder which contain that folder
     */
    public String backStep(){
        String[] arr = getPath().split("/" , 5);
        String[] arr2=new String[arr.length-1];
        for (int i=0;i<arr.length-1;i++){
            arr2[i]=arr[i];
        }
        String back="";
        for (int i=0;i<arr2.length;i++){
            back+=arr2[i];
            if(i!=arr.length-2){
                back+="/";
            }
        }
        return back;
    }
    /**
     * get the name of the folder which contain parameter folder
     * @param file the parameter folder which we want to know the name of the folder which contain it
     * @return the name of the folder which contain that folder
     */
    public String back(File file){
        String[] arr = file.getPath().split("/", 5);
        String[] arr2=new String[arr.length-1];
        for (int i=0;i<arr.length-1;i++){
            arr2[i]=arr[i];
        }
        String back="";
        for (int i=0;i<arr2.length;i++){
            back+=arr2[i];
            if(i!=arr.length-2){
                back+="/";
            }
        }
        return back;
    }
    /**
     * get the mails in that folder in double linked list form
     * @return the mails in that folder in double linked list form of folders
     */
    public doubleLinkedList getMailsFolders (){
        File f =new File(getPath());
        File[] files = f.listFiles();
        doubleLinkedList mails = new doubleLinkedList();
        for (int i=0 ; i<files.length;i++){
            if (files[i].isDirectory()){
                mails.add(files[i]);
            }
        }
        return mails;
    }
    private doubleLinkedList contactFile() {
    	File f =new File(getPath());
        File[] files = f.listFiles();
        doubleLinkedList contacts = new doubleLinkedList();
        for (int i=0 ; i<files.length;i++){
            if (files[i].isFile()){
                contacts.add(files[i]);
            }
        }
        doubleLinkedList list=new doubleLinkedList();
        int num=0;
        int count=0;
        if(contacts.size()%10==0){
            num=contacts.size()/10;
        }
        else {
            num=(contacts.size()/10)+1;
        }
        System.out.println("/"+num);
        for (int i=0;i<num;i++){
            File[] arr=new File[10];
            for (int j=0;j<arr.length;j++){
                if(count>=contacts.size())
                    break;
                arr[j]=(File)contacts.get(count);
                count++;
            }
            list.add(arr);
        }
        return list;
    }
    /**
     * You should use setViewingOptions function first
     * @param page to handle paging
     * @param contacts1 the double linked list of array of 10 contacts
     * @return list of emails
     */
    public File[] listContact(int page,doubleLinkedList contacts1) {
    	//doubleLinkedList contacts1=new doubleLinkedList();
    	//contacts1=contactFile();
    	  if (page>0 && (!contacts1.isEmpty()))
    		  return (File[])contacts1.get(page-1);
    	  else {
              NullPointerException NullPointer = new NullPointerException();
              throw NullPointer;
          }
    }
    public boolean checkContactName(String name) {
    	File f =new File(getPath());
        File[] files = f.listFiles();
        doubleLinkedList contacts = new doubleLinkedList();
        for (int i=0 ; i<files.length;i++){
            if (files[i].isFile()){
                contacts.add(files[i]);
            }
        }
        for(int j=0;j<contacts.size();j++) {
        	String name2=((File)contacts.get(j)).getName();
			String[] name1=name2.split(".txt");
			if(name.equals(name1[0]))
				return false;
        }
        return true;
    }

    private int monthToNum(String month){
         int num = 0;
         if(month.equals("Jan")){
             num=1;
         }
         else if(month.equals("Feb")){
             num=2;
         }
         else if(month.equals("Mar")){
             num=3;
         }
         else if(month.equals("Apr")){
             num=4;
         }
         else if(month.equals("May")){
             num=5;
         }
         else if(month.equals("Jun")){
             num=6;
         }
         else if(month.equals("Jul")){
             num=7;
         }
         else if(month.equals("Aug")){
             num=8;
         }
         else if(month.equals("Sept")){
             num=9;
         }
         else if(month.equals("Oct")){
             num=10;
         }
         else if(month.equals("Nov")){
             num=11;
         }
         else if(month.equals("Dec")){
             num=12;
         }
         return num;
    }
    private boolean leapYear(int year){
         if(year%400==0)
         {
             return true;
         }
         else if(year%100!=0 && year%4==0)
         {
             return true;
         }
         else
         {
             return false;
         }
    }
    public doubleLinkedList getMailsFoldersForTrash () throws IOException {
         File f =new File(getPath());
         File[] files = f.listFiles();
         for(int i=0;i<files.length;i++) {
            if(files[i].isDirectory()) {
                String date1 = Files.readAllLines(Paths.get((files[i]).getPath() + "/index.txt")).get(0);
                String[] arr = date1.split(" ", 6);
                Date d1 = new Date();
                String date2 = d1.toString();
                String[] arr2 = date2.split(" ", 6);
                if((Integer.parseInt(arr2[5])-Integer.parseInt(arr[5]))==0) {
                    if ((monthToNum(arr2[1]) - monthToNum(arr[1])) > 0) {
                        if (leapYear(Integer.parseInt(arr[5]))) {
                            if (arr[1] == "Jan" || arr[1] == "Mar" || arr[1] == "May" || arr[1] == "Jul" || arr[1] == "Aug" || arr[1] == "Oct" || arr[1] == "Dec") {
                                if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2]) - 1) <= 0) {
                                    deleteFolder(files[i].getPath());
                                }
                            } else if (arr[1] == "Feb") {
                                if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2]) + 1) <= 0) {
                                    deleteFolder(files[i].getPath());
                                }
                            } else {
                                if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2])) <= 0) {
                                    deleteFolder(files[i].getPath());
                                }
                            }
                        } else {
                            if (arr[1] == "Jan" || arr[1] == "Mar" || arr[1] == "May" || arr[1] == "Jul" || arr[1] == "Aug" || arr[1] == "Oct" || arr[1] == "Dec") {
                                if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2]) - 1) <= 0) {
                                    deleteFolder(files[i].getPath());
                                }
                            } else if (arr[1] == "Feb") {
                                if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2]) + 2) <= 0) {
                                    deleteFolder(files[i].getPath());
                                }
                            } else {
                                if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2])) <= 0) {
                                    deleteFolder(files[i].getPath());
                                }
                            }

                        }
                    }
                }
                else if((Integer.parseInt(arr2[5])-Integer.parseInt(arr[5]))>0){
                    if (leapYear(Integer.parseInt(arr[5]))) {
                        if (arr[1] == "Jan" || arr[1] == "Mar" || arr[1] == "May" || arr[1] == "Jul" || arr[1] == "Aug" || arr[1] == "Oct" || arr[1] == "Dec") {
                            if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2]) - 1) <= 0) {
                                deleteFolder(files[i].getPath());
                            }
                        } else if (arr[1] == "Feb") {
                            if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2]) + 1) <= 0) {
                                deleteFolder(files[i].getPath());
                            }
                        } else {
                            if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2])) <= 0) {
                                deleteFolder(files[i].getPath());
                            }
                        }
                    } else {
                        if (arr[1] == "Jan" || arr[1] == "Mar" || arr[1] == "May" || arr[1] == "Jul" || arr[1] == "Aug" || arr[1] == "Oct" || arr[1] == "Dec") {
                            if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2]) - 1) <= 0) {
                                deleteFolder(files[i].getPath());
                            }
                        } else if (arr[1] == "Feb") {
                            if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2]) + 2) <= 0) {
                                deleteFolder(files[i].getPath());
                            }
                        } else {
                            if ((Integer.parseInt(arr[2]) - Integer.parseInt(arr2[2])) <= 0) {
                                deleteFolder(files[i].getPath());
                            }
                        }

                    }
                }
            }
         }
         File[] files1 = f.listFiles();
         doubleLinkedList mails = new doubleLinkedList();
         for (int i=0 ; i<files1.length;i++){
             if (files1[i].isDirectory()){
                 System.out.println(files1[i]);
                 mails.add(files1[i]);

             }
         }
         return mails;
    }
    /**
     * convert the double linked of folders of emails
     * to a double linked list of arrays(of size 10) of IMails
     * @param emails the double linked list which wanted to be converted
     * @return double linked list of arrays(of size 10) of IMails
     * @throws IOException if the file was null
     * @throws ParseException if the parse was null
     */
    public doubleLinkedList mails(doubleLinkedList emails) throws IOException, ParseException {
        doubleLinkedList list=new doubleLinkedList();
        int num=0;
        int count=0;
        if(emails.size()%10==0){
            num=emails.size()/10;
        }
        else {
            num=(emails.size()/10)+1;
        }
        for (int i=0;i<num;i++){
            mail[] arr=new mail[10];
            for (int j=0;j<arr.length;j++){
                if(count>=emails.size())
                    break;

                mail mail=new mail();
                String subject=Files.readAllLines(Paths.get(((File) emails.get(count)).getPath() + "/index.txt")).get(1);
                File receivers=new File(((File)emails.get(count)).getPath()+"/receivers.txt");
                File attachments=new File(((File)emails.get(count)).getPath()+"/attachments");
                File body=new File(((File)emails.get(count)).getPath()+"/"+subject+".txt");

                String date = Files.readAllLines(Paths.get(((File) emails.get(count)).getPath() + "/index.txt")).get(0);
                Date piv = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(date);
                mail.setDate(piv);
                mail.setSubject(Files.readAllLines(Paths.get(((File) emails.get(count)).getPath() + "/index.txt")).get(1));
                mail.setSender(Files.readAllLines(Paths.get(((File) emails.get(count)).getPath() + "/index.txt")).get(2));
                mail.setPriority(Integer.parseInt(Files.readAllLines(Paths.get(((File) emails.get(count)).getPath() + "/index.txt")).get(3)));
                mail.setId(Integer.parseInt(Files.readAllLines(Paths.get(((File) emails.get(count)).getPath() + "/index.txt")).get(4)));
                FileReader fr = new FileReader(receivers);
                BufferedReader in=new BufferedReader(fr);
                String line;
                while((line=in.readLine())!=null) {
                    mail.setReceiver(line);
                }
                in.close();

                String TextBody="";
                FileReader fr1 = new FileReader(body);
                BufferedReader in1=new BufferedReader(fr1);
                String line1;
                while((line1=in1.readLine())!=null) {
                	TextBody+=line1;
                	TextBody+="\n";
                }
                in1.close();
                mail.setTextBody(TextBody);
                //mail.setTextBody((Files.readAllLines(Paths.get(((File) emails.get(count)).getPath() + "/"+subject+".txt")).get(0)));
                arr[j]=mail;
                count++;
            }
            list.add(arr);
        }
        return list;
    }
}
