package mailServer;

import linkedList.doubleLinkedList;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public interface IFolder {
    /**
     * check if the user name is stored or not
     * @param username the user name which wanted to be checked
     * @return false if the user name is not stored or true if it stored
     */
    public boolean checkExistUsername(String username);
    /**
     * check if two strings are equal or not
     * @param s1 the first string
     * @param s2 the second string
     * @return
     */
    public boolean checkEqualityOfTwoStrings(String s1, String s2);
    /**
     * check if the user name is stored and then compare its password with the taken one
     * @param userName the name of the user
     * @param password the password which wanted to be checked of that user name
     * @return true if the user name is stored and the password is true or return false in any other case
     */
    public boolean checkPassword(String userName , String password);
    /**
     * creat a folder for user
     * @param contact which contain the user nameof that user
     */
    public void creatUsersFolder(contact contact);
    /**
     * after login we need to create a folders to the new account.
     * @param contact
     */
    public void createSubFolders(contact contact);
    /**
     * make sure of the sub folders of the file  of the user
     * @param username which wanted to check the folders in its folder
     */
    public void checkSubFolders(String username);
    /**
     * delete the Index Of the User
     */
    public void deleteIndexOfUser();
    /**
     * copy File to other file Using Channel
     * @param source the source file which wanted to copied
     * @param dest the destination file which wanted to copy in
     * @throws IOException if the file was null
     */
    public  void copyFileUsingChannel(File source, File dest) throws IOException;
    /**
     * move File to other file Using Channel
     * @param path1 the source file which wanted to be moved
     * @param path2 the destination file which wanted to moove to
     * @throws IOException if the file was null
     */
    public  void move(String path1,String path2) throws IOException;
    /**
     * delete a specific line from a file
     * @param line the line which wanted to be deleted
     * @param file the file in which the line will be deleted
     */
    public void deleteLine(String line, File file);
    /**
     * copy file to other one
     * @param name1 the source file
     * @param name2 the destination file
     */
    public void copyFiles(String name1 , String name2);
    /**
     * sent the path of the folder then it will delete
     * @param filePath the path of the folder to be deleted
     */
    public void deleteFolder(String filePath);
    /**
     * check If the file is Empty
     * @param f the file which wanted to check if it i empty or not
     * @return true if the file is empty or false if it is not empty
     */
    public boolean checkIfIsEmpty(File f);
    /**
     * return the path of that folder
     * @return the path of that folder
     */
    public String getPath();
    /**
     * set the path of that folder
     * @param path the new path
     */
    public void setPath(String path);
    /**
     * get the name of the folder which contain that folder
     * @return the name of the folder which contain that folder
     */
    public String backStep();
    /**
     * get the name of the folder which contain parameter folder
     * @param file the parameter folder which we want to know the name of the folder which contain it
     * @return the name of the folder which contain that folder
     */
    public String back(File file);
    /**
     * get the mails in that folder in double linked list form
     * @return the mails in that folder in double linked list form of folders
     */
    public doubleLinkedList getMailsFolders ();
    /**
     * convert the double linked of folders of emails
     * to a double linked list of arrays(of size 10) of IMails
     * @param emails the double linked list which wanted to be converted
     * @return double linked list of arrays(of size 10) of IMails
     * @throws IOException if the file was null
     * @throws ParseException if the parse was null
     */
    public doubleLinkedList mails(doubleLinkedList emails) throws IOException, ParseException;
    /**
     * You should use setViewingOptions function first
     * @param page to handle paging
     * @param contacts1 the double linked list of array of 10 contacts
     * @return list of emails
     */
    public File[] listContact(int page,doubleLinkedList contacts1);
    

}
