package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.doubleLinkedList;

public class trying {
    /*
    private File file;
    public folder(String name,folder inside){
        if(!inside.getFolder().isFile()) {
            String place;
            if (inside.getFolder().getName()==""){
                place= name;
                file=new File(place);
                if(!file.exists()) {
                    file.mkdir();

                }
                else {
                    RuntimeException runtime = new RuntimeException();
                    throw runtime;               //the folder is exist
                }
            }
            else {
                place = inside.getFolder().getName()+"/" +name;
                file = new File(place);
                if (!file.exists()) {
                    file.mkdir();
                } else {
                    RuntimeException runtime = new RuntimeException();
                    throw runtime;               //the folder is exist
                }
            }
        }
        else {
            RuntimeException runtime = new RuntimeException();
            throw runtime;        //the inside folder is file
        }
    }
    public folder(String name){
        String defaultPlace ="";//the place were all files must be in
        String place = defaultPlace;
        place += "/" +name;
        file=new File(place);
        if(!file.exists()) {
            file.mkdir();

        }
        else {
            RuntimeException runtime = new RuntimeException();
            throw runtime;               //the folder is exist
        }
    }
    public File getFolder(){
        if (!file.isFile()){
            return file;
        }
        else {
            RuntimeException runtime = new RuntimeException();
            throw runtime;
        }
    }
    public void setFolder(File newFile){
        try {
            Files.copy(newFile.toPath(),file.toPath());
        }
        catch(Exception e) {
            RuntimeException runtime = new RuntimeException();
            throw runtime;                             //error
        }
    }
    public boolean creatFile(String name){
        if (!file.isFile()){
            if (!file.exists()) {
                file.mkdir();
            }
            String[] nameSplitted=name.split(".");
            if (nameSplitted[nameSplitted.length-1]=="txt") {
                String place = file.getName()+ "/" +name;
                folder file= new folder(name);
                File f = new File(place);
                try {
                    f.createNewFile();
                    file.setFolder(f);
                    return true;
                } catch (IOException e) {
                    return false;//Exception happend while crating the file
                }
            }
            else{
                if (nameSplitted.length==1){
                    String place = file.getName()+ "/" +name+".txt";
                    folder file= new folder(name);
                    File f = new File(place);
                    try {
                        f.createNewFile();
                        file.setFolder(f);
                        return true;
                    } catch (IOException e) {
                        return false;//Exception happend while crating the file
                    }
                }
                else {
                    RuntimeException runtime = new RuntimeException();//the file name contain " . " in its name
                    throw runtime;
                }
            }
        }
        else {
            RuntimeException runtime = new RuntimeException();//the folder is a file not a folder
            throw runtime;
        }
    }
     */

    /*
        //////////

        int l = 0, r = e.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if ((int)e.get(m) == x)
                return m;

            // If x greater, ignore left half
            if ((int)e.get(m) < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    // Returns index of x if it is present in arr[],
    // else return -1
    /*int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        filter ob = new filter();
        int arr[] = { 2, 3, 4, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                    + "index " + result);
    }
     */


  /*  public static void main(String[] args) {
        filter f = new filter();
        doubleLinkedList i = new doubleLinkedList();
        i.add(5);
        i.add(6);
        i.add(7);
        i.add(7);
        i.add(8);
        f.setMails(i);
        System.out.println(f.binarySearch(7));
        i.remove(f.binarySearch(7));
        System.out.println(f.binarySearch(7));
    }



   */
}
