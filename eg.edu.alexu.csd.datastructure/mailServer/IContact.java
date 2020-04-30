package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.SingleLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.doubleLinkedList;

import java.io.IOException;

public interface IContact {
    /**
     * chwck the validity of the e_mail (in the format)
     * the e_mail should be @MYM.com
     * there must be only characters, numbers, under score"_", dash "-" and "@" sign and dot"." only
     * @param email the email wanted to be checked
     * @return true if the email follow the format and false if not
     */
    public boolean checkEmail(String email);
    /**
     * set the name of the contact
     * @param Name
     */
    public void setName(String Name);
    /**
     * add email to the contact
     * @param email
     */
    public void setEmails(String email);
    /**
     * set the password of the contact
     * @param password
     */
    public void setPassword(String password);
    /**
     * set the BirthDate of the contact
     * @param birthDate
     */
    public void setBirthDate(String birthDate);
    /**
     * set the Gender of the contact
     * @param address
     */
    public void setGender(String address);
    /**
     * get the name of the contact
     * @return get the name of the contact
     */
    public String getName();
    /**
     * get the password of the contact
     * @return get the password of the contact
     */
    public String getPassword();
    /**
     * get the BirthDate of the contact
     * @return get the BirthDate of the contact
     */
    public String getBirthDate();
    /**
     * get the linked list of  Emails of the contact
     * @return et the linked list of  Emails of the contact
     */
    public SingleLinkedList getEmails();
    /**
     * get the gendr of the contact
     * @return get the gendr of the contact
     */
    public String getGender();
    /**
     * get the First Email in the contact
     * @return get the First Email in the contact
     */
    public String getFirstEmail();
    /**
     * make the contact file in the user folder
     * @param emails the linked list of the e_mails in the contact
     * @throws IOException if the file was null
     */
    public void addContact(SingleLinkedList emails) throws IOException;
    /**
     * remove the contact file from the folder of the user
     * @throws IOException if the file was null
     */
    public void removeContact() throws IOException;
    /**
     * rename the file of the contact in the user folder
     * @param newName the new name
     * @throws IOException if the file was null
     */
    public void renameContact(String newName) throws IOException;
    /**
     * delete email from the file of the contact in the user folder
     * @param email the name of the email wanted to be deleted
     * @throws IOException if the file was null
     */
    public void deleteEmail(String email) throws IOException;
    /**
     * add email to the file of the contact in the user folder
     * @param email the name of the email wanted to be added
     * @throws IOException if the file was null
     */
    public void addEmail(String email) throws IOException;
    /**
     * get the folder of that contact
     * @return the folder of that contact
     */
    public folder getFolder();
    /**
     * set the folder of that contact
     * @param folder the new folder of that contact
     */
    public void setFolder(folder folder);
    /**
     * check if the contact is valid for sign up or not
     * @return false if the contact is not available for sign up or true if the contact is available
     */
    public  boolean checkContactForSignUp();
    /**
     * check if the contact is valid or not
     * @return false if the contact is not available or true if the contact is available
     */
    public  boolean checkContact();
}
