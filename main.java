package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.SingleLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.doubleLinkedList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class main {

    public static void main(String[]args) throws IOException, ParseException {
     /*   folder folder = new folder();
        folder.setPath("System/marwangabal@mym.com/Contact");
        contact x=new contact();
        x.setFolder(folder);
        x.setName("youssef");
        x.setEmails("youssefhassan@mym.com");
        try {
            x.addContact(x.getEmails());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

*/
/*
        folder folder = new folder();
        mail y=new mail();
        y.setSender("youssefhassan@mym.com");
        y.setReceiver("marwangabal@mym.com");
        Date date=new Date();
        y.setDate(date);
        y.setTextBody("hello every one " +
                "nice to see you");
        y.setSubject("circle");
        y.setPriority(6);
        System.out.println(y.getDate());



 */

/*
       app app=new app();
       app.folder.setPath("System/marwangabal@mym.com/Sent");
       File file1 =new File("System/marwangabal@mym.com/Sent");
       File[] files = file1.listFiles();
       doubleLinkedList x=new doubleLinkedList();
       for(int i=0;i<files.length;i++){
           if(files[i].isDirectory())
               x.add(files[i]);
       }
        doubleLinkedList list=app.folder.mails(x);

        mail[] arr= (mail[]) list.get(0);
        System.out.println(arr[0].getSubject());


 */
       /*
       sort c = new sort();
       c.setMails(x);
        doubleLinkedList z=new doubleLinkedList();
        try {
         z = c.sortAscendingByNumOfReceivers();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        z.show();
*/





     /*  File file = new File("System/num.txt");
        FileWriter f=new FileWriter(file);
        f.write("2");
        f.flush();
        f.close();
       FileReader fr = new FileReader(file);
        BufferedReader in=new BufferedReader(fr);
        String line;
        while((line=in.readLine())!=null) {
            System.out.println(line);
        }
        in.close();*/
/*
     app app=new app();
     contact contact=new contact();
     contact.setName("youssef");
     contact.setEmails("youssefhassan@mym.com");
     contact.setBirthDate("11/11/1999");
     contact.setPassword("123456");
     contact.setGender("Male");
     app.folder.creat_users_folder(contact);
*/
      /*  File file = new File("System/x.txt");
        file.createNewFile();
        String textToAppend = "Happy Learning !!";

        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath(), true) );
        writer.write(textToAppend);
        writer.newLine();
        writer.close();
*/

      File file=new File("System/marwangabal@mym.com/Sent/1");

        String date1 = Files.readAllLines(Paths.get((file).getPath() + "/index.txt")).get(0);
        String[] arr = date1.split(" ", 6);

        Date d1=new Date();
        String date2=d1.toString();
        String[] arr2 = date2.split(" ", 6);
        System.out.println(Integer.parseInt(arr[2])-Integer.parseInt(arr2[2]));


    }
}



