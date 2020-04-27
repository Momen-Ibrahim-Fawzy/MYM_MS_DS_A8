package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class folder implements IFolder {
    private File system=new File("System");
    private File index=new File("System/indexOfUser.txt");
    private File num=new File("System/num.txt");
    private String UserName;
    private String PassWord;
    private String path;


    /////constructor to create system folder and its index
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void SignIn(String userName ,String password) {
        if(check_exist_username(userName)) {
            while(true) {
                if(check_password(userName ,password)) {
                    UserName=userName;
                    PassWord=password;
                    check_sub_folders(UserName);
                    break;
                }
                else {
                    System.out.println("email is found and wrong password");
                    System.out.println("please enter the correct password");
                }
            }
        }
        else {
            System.out.println("sign up to create anew email");
        }

    }


    /*public void SignUP(String userName ,String password) {
        creat_users_folder(userName ,password);
    }
*/

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean check_exist_username(String username) {
        if(username==null)
            return false;
        for(File f:system.listFiles()) {
            if(f.getName().contains(username))
                return true;
        }
        return false;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean check_string(String check,String check1) {
        if(check==null||check1==null) {
            return false;
        }
        int i=0;
        while(i<check.length()){
            if(check.charAt(i)!=check1.charAt(i))
                return false;
            else
                i++;
        }
        if(i==check.length()&&i==check1.length())
            return true;
        else
            return false;

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean check_password(String userName ,String password) {
        try {
            FileReader fr = new FileReader(index);
            @SuppressWarnings("resource")
            BufferedReader in=new BufferedReader(fr);
            String line;
            while((line=in.readLine())!=null) {
                //System.out.println(line);
                if(check_string(line,userName)) {
                    line=in.readLine();
                    if(check_string(line,password)) {
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void creat_users_folder(contact contact) {
        boolean check=check_exist_username(contact.getFirstEmail());
        System.out.println(check);
        if(check)
            System.out.println("folder is exist");
        else {
            File user=new File("System/"+contact.getFirstEmail());
            user.mkdir();
            create_sub_folders(contact);
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /////////after login we need to create a folders to the new account.
    public void create_sub_folders(contact contact) {
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void CheckExistOfIndexOfUsers() {
        boolean check=check_exist_username("indexOfUser");
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void check_sub_folders(String username) {
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void delet_indexOfUser() {
        index.delete();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("resource")
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


    public  void move(File f1,File f2) throws IOException {
        Path temp = Files.move
                (Paths.get(f1.getPath()),
                        Paths.get(f2.getPath()));

        if(temp != null)
        {
            System.out.println("File renamed and moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void delete_line(String line,File file) {
        File new_file=new File(back(file)+"/return.txt");
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
                if(!check_string(line,line1)) {
                    writer_method(line1,new_file);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void copy_files(String name1 , String name2) {
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


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////sent the path of the folder then it will delete
    public void delete_folder(String line) {
        File f1=new File(line);
        if(!check_ifisempty(f1)) {
            for(File f:f1.listFiles()) {
                delete_folder(line+"/"+f.getName());
            }
        }
        f1.delete();
    }

    public boolean check_ifisempty(File f) {
        if(f.isDirectory()&&f.list().length>0) {
            return false;
        }
        return true;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String backStep(){
        String[] arr = getPath().split("/", 5);
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


}
