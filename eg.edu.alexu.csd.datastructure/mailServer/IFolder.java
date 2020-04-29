package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.File;
import java.io.IOException;

public interface IFolder {
    /**
     *
     * @param username
     * @return
     */
    boolean check_exist_username(String username);

    /**
     *
     * @param userName
     * @param password
     * @return
     */
     boolean check_password(String userName ,String password);

    /**
     *
     * @param contact
     */
     void creat_users_folder(contact contact);

    /**
     *
     * @param source
     * @param dest
     * @throws IOException
     */
     void copyFileUsingChannel(File source, File dest) throws IOException;

    /**
     *
     * @param f1
     * @param f2
     * @throws IOException
     */
     void move(String path1,String path2) throws IOException;

    /**
     *
     * @param line
     * @param file
     */
     void delete_line(String line,File file);

    /**
     *
     * @param line
     */
     void delete_folder(String line);

    /**
     *
     * @return
     */
     String getPath();

    /**
     *
     * @param path
     */
     void setPath(String path);

    /**
     *
     * @return
     */
     String backStep();

    /**
     *
      * @param file
     * @return
     */

     String back(File file);

    }



