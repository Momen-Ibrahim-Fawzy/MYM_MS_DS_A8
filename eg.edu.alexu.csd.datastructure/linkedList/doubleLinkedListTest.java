package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class doubleLinkedListTest {
    @org.junit.jupiter.api.Test
    void addTestOne() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        assertEquals(45,e.trailer.getPrev().getElement());
    }
    @org.junit.jupiter.api.Test
    void addTestTwo() {
        //linked list with one element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        assertEquals(50,e.trailer.getPrev().getElement());
    }
    @org.junit.jupiter.api.Test
    void addTestThere() {
        //linked list with two element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);
        assertEquals(55,e.trailer.getPrev().getElement());
    }
    @org.junit.jupiter.api.Test
    void addTestFour() {
        //linked list with there element
        //add in index:
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);
        e.add(3,60);
        assertEquals(60,e.trailer.getPrev().getElement());
        assertThrows(RuntimeException.class,()->e.add(5,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void addTestFive() {
        //linked list with there element
        //add in index:
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        e.add(2,60);//45,50,60,55
        assertEquals(55,e.trailer.getPrev().getElement());
        assertEquals(60,e.trailer.getPrev().getPrev().getElement());
        assertEquals(50,e.trailer.getPrev().getPrev().getPrev().getElement());
        e.add(4,70);
        assertEquals(70,e.trailer.getPrev().getElement());
        assertThrows(RuntimeException.class,()->e.add(6,60));//the list is short
        assertThrows(RuntimeException.class,()->e.add(7,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void addTestSix() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        assertThrows(RuntimeException.class,()->e.add(1,60));//the list is short
        e.add(0,45);
        assertEquals(45,e.trailer.getPrev().getElement());
        assertThrows(RuntimeException.class,()->e.add(3,60));//the list is short
        assertThrows(RuntimeException.class,()->e.add(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void addTestSeven() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        assertThrows(RuntimeException.class,()->e.add(1,60));//the list is short
        assertThrows(RuntimeException.class,()->e.add(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void getTestOne() {
        //linked list with there element
        //add in index:
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        assertEquals(45,e.get(0));
        assertEquals(50,e.get(1));
        assertEquals(55,e.get(2));
        assertThrows(RuntimeException.class,()->e.get(3));//the list is short
        assertThrows(NullPointerException.class,()->e.get(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void getTestTwo() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        assertThrows(RuntimeException.class,()->e.get(3));//the list is short
        assertThrows(RuntimeException.class,()->e.get(2));//the list is short
        assertThrows(RuntimeException.class,()->e.get(1));//the list is short
        assertThrows(RuntimeException.class,()->e.get(0));//the list is short
        assertThrows(NullPointerException.class,()->e.get(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void getTestTrere() {
        //linked list with one element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);//45
        assertEquals(45,e.get(0));
        assertThrows(RuntimeException.class,()->e.get(3));//the list is short
        assertThrows(RuntimeException.class,()->e.get(2));//the list is short
        assertThrows(RuntimeException.class,()->e.get(1));//the list is short
        assertThrows(NullPointerException.class,()->e.get(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void setTestOne() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        assertThrows(RuntimeException.class,()->e.set(2,60));//the list is short
        assertThrows(RuntimeException.class,()->e.set(1,60));//the list is short
        assertThrows(RuntimeException.class,()->e.set(0,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void setTestTwo() {
        //linked list with one element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);//45
        e.set(0,60);//60
        assertEquals(60,e.get(0));
        assertThrows(RuntimeException.class,()->e.set(2,60));//the list is short
        assertThrows(RuntimeException.class,()->e.set(1,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void setTestTrere() {
        //linked list with there element
        //add in index:
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        e.set(2,60);//45,50,60
        assertEquals(60,e.get(2));
        assertThrows(RuntimeException.class,()->e.set(3,60));//the list is short
        assertThrows(RuntimeException.class,()->e.set(4,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void clearTestZero() {
        //null linked list
        doubleLinkedList m = null;
        assertThrows(NullPointerException.class,()->m.clear());
    }
    @org.junit.jupiter.api.Test
    void clearTestOne() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        e.clear();
        assertEquals(e.header,e.trailer.getPrev());
        assertEquals(e.trailer,e.header.getNext());
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void clearTestTwo() {
        //linked list with one element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.clear();
        assertEquals(e.header,e.trailer.getPrev());
        assertEquals(e.trailer,e.header.getNext());
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void clearTestTrere() {
        //linked list with there element
        //add in index:
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        e.clear();
        assertEquals(e.header,e.trailer.getPrev());
        assertEquals(e.trailer,e.header.getNext());
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestOne() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        assertEquals(true,e.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestTwo() {
        //linked list with one element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        assertEquals(false,e.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestTrere() {
        //linked list with there element
        //add in index:
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        assertEquals(false,e.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void removeTestOne() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        assertThrows(RuntimeException.class,()->e.remove(0));//the list is short
        assertThrows(RuntimeException.class,()->e.remove(1));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void removeTestTwo() {
        //linked list with one element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.remove(0);
        assertEquals(true,e.isEmpty());
        e.add(45);
        e.remove(0);
        assertThrows(RuntimeException.class,()->e.remove(1));//the list is short
        assertThrows(RuntimeException.class,()->e.remove(2));//the list is short
        assertThrows(RuntimeException.class,()->e.remove(0));//the list is short
        e.add(45);
        assertThrows(RuntimeException.class,()->e.remove(1));//the list is short
        assertThrows(RuntimeException.class,()->e.remove(2));//the list is short
        e.remove(0);
        assertEquals(true,e.isEmpty());
        assertThrows(RuntimeException.class,()->e.remove(0));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void removeTestThere() {
        //linked list with two element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);//45,50
        e.remove(0);//50
        assertEquals(50,e.trailer.getPrev().getElement());
        assertEquals(50,e.header.getNext().getElement());
        e.add(45);//50,45
        e.remove(1);//50
        assertEquals(50,e.trailer.getPrev().getElement());
        assertEquals(50,e.header.getNext().getElement());
        assertThrows(RuntimeException.class,()->e.remove(2));//the list is short
        assertThrows(RuntimeException.class,()->e.remove(1));//the list is short
        e.remove(0);
        assertEquals(true,e.isEmpty());
        assertThrows(NullPointerException.class,()->e.remove(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void sizeTestOne() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestTwo() {
        //linked list with one element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        assertEquals(1,e.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestThere() {
        //linked list with two element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        assertEquals(2,e.size());
    }
    @org.junit.jupiter.api.Test
    void containsTestOne() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        assertEquals(false,e.contains(1));
        assertEquals(false,e.contains(2));
        assertEquals(false,e.contains(100));
    }
    @org.junit.jupiter.api.Test
    void containsTestTwo() {
        //linked list with one element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        assertEquals(true,e.contains(45));
        assertEquals(false,e.contains(1));
        assertEquals(false,e.contains(2));
        assertEquals(false,e.contains(100));
    }
    @org.junit.jupiter.api.Test
    void containsTestThere() {
        //linked list with two element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        assertEquals(true,e.contains(45));
        assertEquals(true,e.contains(50));
        assertEquals(false,e.contains(1));
        assertEquals(false,e.contains(2));
        assertEquals(false,e.contains(100));
    }
    @org.junit.jupiter.api.Test
    void sublistTestZero() {
        //empty linked list
        doubleLinkedList e = null;
        assertThrows(NullPointerException.class,()->e.sublist(0,5));
        assertThrows(NullPointerException.class,()->e.sublist(0,0));
    }
    @org.junit.jupiter.api.Test
    void sublistTestOne() {
        //empty linked list
        doubleLinkedList e = new doubleLinkedList();
        assertThrows(RuntimeException.class,()->e.sublist(0,5));
        assertThrows(RuntimeException.class,()->e.sublist(0,0));
    }
    @org.junit.jupiter.api.Test
    void sublistTestTwo() {
        //linked list with one element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        ILinkedList l = new doubleLinkedList();
        l=e.sublist(0,0);
        assertEquals(true,e.contains(45));
        assertEquals(45,e.get(0));
        assertThrows(RuntimeException.class,()->e.sublist(0,5));
        assertThrows(RuntimeException.class,()->e.sublist(0,-1));
    }
    @org.junit.jupiter.api.Test
    void sublistTestThere() {
        //linked list with two element
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        ILinkedList l = new doubleLinkedList();
        l=e.sublist(0,0);
        assertEquals(true,l.contains(45));
        assertEquals(45,l.get(0));
        ILinkedList i = new doubleLinkedList();
        i=e.sublist(0,1);
        assertEquals(true,i.contains(45));
        assertEquals(45,i.get(0));
        assertEquals(true,i.contains(50));
        assertEquals(50,i.get(1));
        assertThrows(RuntimeException.class,()->e.sublist(0,5));
        assertThrows(RuntimeException.class,()->e.sublist(0,-1));
    }
    @org.junit.jupiter.api.Test
    void sublistTestFour() {
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        ILinkedList l = new doubleLinkedList();
        l=e.sublist(0,0);
        assertEquals(true,l.contains(45));
        assertEquals(45,l.get(0));
        ILinkedList i = new doubleLinkedList();
        i=e.sublist(0,1);
        assertEquals(true,i.contains(45));
        assertEquals(45,i.get(0));
        assertEquals(true,i.contains(50));
        assertEquals(50,i.get(1));
        assertThrows(RuntimeException.class,()->e.sublist(0,5));
        assertThrows(RuntimeException.class,()->e.sublist(0,-1));
        ILinkedList j = new doubleLinkedList();
        j=e.sublist(0,2);
        assertEquals(true,j.contains(45));
        assertEquals(45,j.get(0));
        assertEquals(true,j.contains(50));
        assertEquals(50,j.get(1));
        assertEquals(true,j.contains(55));
        assertEquals(55,j.get(2));
        assertThrows(RuntimeException.class,()->e.sublist(0,5));
        assertThrows(RuntimeException.class,()->e.sublist(0,-1));
    }
    @org.junit.jupiter.api.Test
    void sublistTestFive() {
        doubleLinkedList e = new doubleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        ILinkedList j = new doubleLinkedList();
        j=e.sublist(0,e.size()-1);
        assertEquals(true,j.contains(45));
        assertEquals(45,j.get(0));
        assertEquals(true,j.contains(50));
        assertEquals(50,j.get(1));
        assertEquals(true,j.contains(55));
        assertEquals(55,j.get(2));
        assertEquals(3,j.size());
    }
}
