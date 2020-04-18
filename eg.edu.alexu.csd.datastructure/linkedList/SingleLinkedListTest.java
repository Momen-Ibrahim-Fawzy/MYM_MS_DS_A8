package eg.edu.alexu.csd.datastructure.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SingleLinkedListTest {
    @org.junit.jupiter.api.Test
    void addTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.head.getElement());
    }
    @org.junit.jupiter.api.Test
    void addTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
    }
    @org.junit.jupiter.api.Test
    void addTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
        assertEquals(55,e.head.getNext().getNext().getElement());
    }
    @org.junit.jupiter.api.Test
    void addTestFour() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);
        e.add(3,60);
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
        assertEquals(55,e.head.getNext().getNext().getElement());
        assertThrows(NullPointerException.class,()->e.add(5,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void addTestFive() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        e.add(2,60);//45,50,60,55
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
        assertEquals(60,e.head.getNext().getNext().getElement());
        assertEquals(55,e.head.getNext().getNext().getNext().getElement());
        e.add(4,70);//45,50,60,55,70
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
        assertEquals(60,e.head.getNext().getNext().getElement());
        assertEquals(55,e.head.getNext().getNext().getNext().getElement());
        assertEquals(70,e.head.getNext().getNext().getNext().getNext().getElement());
        assertThrows(NullPointerException.class,()->e.add(6,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(7,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void addTestSix() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.add(1,60));//the list is short
        e.add(0,45);
        assertEquals(45,e.head.getElement());
        assertThrows(NullPointerException.class,()->e.add(3,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void addTestSeven() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.add(1,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void getTestOne() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        assertEquals(45,e.get(0));
        assertEquals(50,e.get(1));
        assertEquals(55,e.get(2));
        assertThrows(NullPointerException.class,()->e.get(3));//the list is short
        assertThrows(NullPointerException.class,()->e.get(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void getTestTwo() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.get(3));//the list is short
        assertThrows(NullPointerException.class,()->e.get(2));//the list is short
        assertThrows(NullPointerException.class,()->e.get(1));//the list is short
        assertThrows(NullPointerException.class,()->e.get(0));//the list is short
        assertThrows(NullPointerException.class,()->e.get(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void getTestTrere() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);//45
        assertEquals(45,e.get(0));
        assertThrows(NullPointerException.class,()->e.get(3));//the list is short
        assertThrows(NullPointerException.class,()->e.get(2));//the list is short
        assertThrows(NullPointerException.class,()->e.get(1));//the list is short
        assertThrows(NullPointerException.class,()->e.get(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void setTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.set(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(1,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(0,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void setTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);//45
        e.set(0,60);//60
        assertEquals(60,e.get(0));
        assertThrows(NullPointerException.class,()->e.set(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(1,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void setTestTrere() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        e.set(2,60);//45,50,60
        assertEquals(60,e.get(2));
        assertThrows(NullPointerException.class,()->e.set(3,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(4,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void clearTestZero() {
        //null linked list
        SingleLinkedList e = null;
        assertThrows(NullPointerException.class,()->e.clear());
    }
    @org.junit.jupiter.api.Test
    void clearTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        e.clear();
        assertEquals(null,e.head);
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void clearTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.clear();
        assertEquals(null,e.head);
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void clearTestTrere() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        e.clear();
        assertEquals(null,e.head);
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertEquals(true,e.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        assertEquals(false,e.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestTrere() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        assertEquals(false,e.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void removeTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.remove(0));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(1));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void removeTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.remove(0);
        assertEquals(true,e.isEmpty());
        e.add(45);
        e.remove(0);
        assertThrows(NullPointerException.class,()->e.remove(1));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(2));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(0));//the list is short
        e.add(45);
        assertThrows(NullPointerException.class,()->e.remove(1));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(2));//the list is short
        e.remove(0);
        assertEquals(true,e.isEmpty());
        assertThrows(NullPointerException.class,()->e.remove(0));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void removeTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);//45,50
        e.remove(0);//50
        assertEquals(50,e.head.getElement());
        e.add(45);//50,45
        e.remove(1);//50
        assertEquals(50,e.head.getElement());
        assertThrows(NullPointerException.class,()->e.remove(2));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(1));//the list is short
        e.remove(0);
        assertEquals(true,e.isEmpty());
        assertThrows(NullPointerException.class,()->e.remove(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void sizeTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        assertEquals(1,e.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        assertEquals(2,e.size());
    }
    @org.junit.jupiter.api.Test
    void containsTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertEquals(false,e.contains(1));
        assertEquals(false,e.contains(2));
        assertEquals(false,e.contains(100));
    }
    @org.junit.jupiter.api.Test
    void containsTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        assertEquals(true,e.contains(45));
        assertEquals(false,e.contains(1));
        assertEquals(false,e.contains(2));
        assertEquals(false,e.contains(100));
    }
    @org.junit.jupiter.api.Test
    void containsTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        assertEquals(true,e.contains(45));
        assertEquals(true,e.contains(50));
        assertEquals(false,e.contains(1));
        assertEquals(false,e.contains(2));
        assertEquals(false,e.contains(100));
    }
    @org.junit.jupiter.api.Test
    void sublistTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();

    }
    @org.junit.jupiter.api.Test
    void sublistTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);

    }
    @org.junit.jupiter.api.Test
    void sublistTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
    }
    @org.junit.jupiter.api.Test
    void generalTest() {
        SingleLinkedList list = new SingleLinkedList();
        //insert element to list
        list.add(1);
        list.add(2);
        list.add(0,4);
        list.add(3);


        //check this elements
        assertEquals(true,list.contains(2));
        assertEquals(4,list.get(0));
        assertEquals(1,list.get(1));
        assertEquals(2,list.get(2));
        assertEquals(3,list.get(3));


        //check that his index out of range and value is "null"
        NullPointerException thrown = assertThrows(NullPointerException.class,() -> list.get(5));
        assertEquals(null, thrown.getMessage());

        //check size
        assertEquals(false,list.isEmpty());
        assertEquals(4,list.size());

        //check that list contains these elements or not
        assertEquals(true,list.contains(2));
        assertEquals(false,list.contains(10));

        //making sub list and check its elements
        list.sublist(0,2);
        assertEquals(3,list.sublist(0,2).size());
        assertEquals(4,list.sublist(0,2).get(0));
        assertEquals(1,list.sublist(0,2).get(1));
        assertEquals(2,list.sublist(0,2).get(2));
        assertEquals(3,list.sublist(0, 2).size());


        //check if we insert element to out of range index the value will be "null"
        NullPointerException thrown2 = assertThrows(NullPointerException.class,() -> list.add(6,13));
        assertEquals(null, thrown2.getMessage());


        //changing value of one element and check it
        list.set(2, 5);
        assertEquals(5,list.get(2));

        //check that index to be set is out of range
        NullPointerException thrown5 = assertThrows(NullPointerException.class,() -> list.set(15,5));
        assertEquals(null, thrown5.getMessage());



        //remove an element and check that size was decreased
        list.remove(2);
        assertEquals(false,list.contains(5));
        assertEquals(3,list.size());


        //check that index to be removed is out of range
        NullPointerException thrown4 = assertThrows(NullPointerException.class,() -> list.remove(10));
        assertEquals(null, thrown4.getMessage());

        //check that one of indexes of sub list is out of range
        NullPointerException thrown1 = assertThrows(NullPointerException.class,() -> list.sublist(1,3).size());
        assertEquals(null, thrown1.getMessage());


        //check that one of indexes of sub list is out of range
        NullPointerException thrown3 = assertThrows(NullPointerException.class,() -> list.sublist(1,3));
        assertEquals(null, thrown3.getMessage());

        //clear all elements of list and check that
        list.clear();
        assertEquals(true,list.isEmpty());
        assertEquals(0,list.size());
    }
}