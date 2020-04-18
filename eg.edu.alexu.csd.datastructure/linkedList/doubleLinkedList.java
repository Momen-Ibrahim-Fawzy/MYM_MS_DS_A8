package eg.edu.alexu.csd.datastructure.linkedList;

import java.util.Arrays;

public class doubleLinkedList implements ILinkedList{
    public static class doubleLinkedListNode{
        private Object element;
        private doubleLinkedListNode next, prev;
        public doubleLinkedListNode(){
            element = null;
            prev = null;
            next = null;
        }
        public doubleLinkedListNode(Object e, doubleLinkedListNode p, doubleLinkedListNode n) {
            element = e;
            prev = p;
            next = n;
        }
        /** Returns the element of this node */
        public Object getElement() {
            return element;
        }
        /** Returns the previous node of this node */
        public doubleLinkedListNode getPrev() {
            return prev;
        }
        /** Returns the next node of this node */
        public doubleLinkedListNode getNext() {
            return next;
        }
        /** Sets the element of this node */
        public void setElement(Object newElem) {
            element = newElem;
        }
        /** Sets the previous node of this node */
        public void setPrev(doubleLinkedListNode newPrev) {
            prev = newPrev;
        }
        /** Sets the next node of this node */
        public void setNext(doubleLinkedListNode newNext) {
            next = newNext;
        }
    }
    ///////////////////////the linked list//////////////////////////
    private int size; // number of elements
    public doubleLinkedListNode header, trailer; // sentinels
    // Constructor that creates an empty list
    public doubleLinkedList() {
        int Size = 0;
        header = new doubleLinkedListNode(null, null, null); // create header
        trailer = new doubleLinkedListNode(null, header, null); // create trailer
        header.setNext(trailer); // make header and trailer point to each other
    }
    /*
     * Inserts a specified element at the specified position in the list.
     * @param index
     * @param element
     */
    @Override
    public void add(int index, Object element){
        if (index>=0) {
            doubleLinkedListNode newNode = new doubleLinkedListNode(element, null, null);
            doubleLinkedListNode temp = header;
            int i = -1;
            while (temp.getNext() != trailer & i < index) {
                i++;
                temp = temp.getNext();
            }
            if (temp.getNext() == trailer & (i < index | index - i == 0)) {
                if (index - i == 1) {
                    add(element);
                }
                else if (index-i==0){
                    temp.getPrev().setNext(newNode);
                    newNode.setPrev(temp.getPrev());
                    temp.setPrev(newNode);
                    newNode.setNext(temp);
                }
                else {
                    //System.out.println("the list is short");
                    RuntimeException Runtime = new RuntimeException();
                    throw Runtime;
                }
            } else {

                temp = temp.getNext();
                temp.getPrev().setNext(newNode);
                newNode.setPrev(temp.getPrev());
                temp.setPrev(newNode);
                newNode.setNext(temp);
                size++;
            }
        }
        else{
            NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
        }
    }
    /**
     *  Inserts the specified element at the end of the list.
     *  @param element
     */
    @Override
    public void add(Object element){
        doubleLinkedListNode newNode=new doubleLinkedListNode(element, null, null);
        trailer.getPrev().setNext(newNode);
        newNode.setPrev(trailer.getPrev());
        trailer.setPrev(newNode);
        newNode.setNext(trailer);
        size++;
    }
    /**
     *  @param index
     *  @return the element at the specified position in this list.
     */
    @Override
    public Object get(int index){
        if (index>=0) {
            doubleLinkedListNode temp = header;
            int i = -1;
            while (temp.getNext() != trailer & i < index) {
                i++;
                temp = temp.getNext();
            }
            if (temp.getNext() == trailer & i < index ){
                //System.out.println("the list is short");
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
            else {
                return temp.getElement();
            }
        }
        else {
            NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
        }
    }
    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index
     * @param element
     */
    @Override
    public void set(int index, Object element){
            if (index>=0) {
                doubleLinkedListNode temp = header;
                int i = 0;
                while (temp.getNext() != trailer & i < index) {
                    i++;
                    temp = temp.getNext();
                }
                if (temp.getNext() == trailer & (i < index | index - i == 0)) {
                    //System.out.println("the list is short");
                    RuntimeException Runtime = new RuntimeException();
                    throw Runtime;
                } else {
                    temp = temp.getNext();
                    temp.setElement(element);
                }
            }
            else {
                NullPointerException nullPointer = new NullPointerException();
                throw nullPointer;
            }
    }
    /**
     *  Removes all of the elements from this list.
     */
    @Override
    public void clear(){
        if (header.getNext()!=trailer) {
            this.header.getNext().setPrev(null);
            this.trailer.getPrev().setNext(null);
            this.header.setNext(trailer);
            this.trailer.setPrev(header);
            this.size = 0;
        }
    }
    /**
     *  @return true if this list contains no elements.
     */
    @Override
    public boolean isEmpty(){
        boolean empty = false;
        if (header.getNext()==trailer&trailer.getPrev()==header){
            empty=true;
        }
        return empty;
    }
    /**
     *  Removes the element at the specified position in this list.
     *  @param index
     */
    @Override
    public void remove(int index){
            if (index>=0) {
                doubleLinkedListNode temp = header;
                int i = 0;
                while (temp.getNext() != trailer & i < index) {
                    i++;
                    temp = temp.getNext();
                }
                if (temp.getNext() == trailer & (i < index | index - i == 0)) {
                    //System.out.println("the list is short");
                    RuntimeException Runtime = new RuntimeException();
                    throw Runtime;
                } else {
                    temp = temp.getNext();
                    temp.getPrev().setNext(temp.getNext());
                    temp.getNext().setPrev(temp.getPrev());
                    temp.setPrev(null);
                    temp.setNext(null);
                }
            }
            else {
                NullPointerException nullPointer = new NullPointerException();
                throw nullPointer;
            }
    }
    /**
     *  @return the number of elements in this list.
     */
    @Override
    public int size(){
        doubleLinkedListNode temp = header;
        int i=0;
        while (temp.getNext()!=trailer){
            i++;
            temp=temp.getNext();
        }
        return i;
    }
    /**
     *  @param fromIndex
     *  @param toIndex
     *  @return a view of the portion of this list between the specified
     *  fromIndex and toIndex, inclusively.
     */
    @Override
    public ILinkedList sublist(int fromIndex, int toIndex){
        int size = toIndex-fromIndex+1;
        ILinkedList newList;
        doubleLinkedList newOne = new doubleLinkedList();
        doubleLinkedListNode temp;
        temp = header;
        int i=0;
        while (temp.getNext()!=trailer&i<fromIndex){
            i++;
            temp=temp.getNext();
        }
        if (temp.getNext()==trailer&i<fromIndex){
            //here should be an exception
        }
        else{
            doubleLinkedListNode newNode=temp;
            newOne.header=new doubleLinkedListNode(null,null,newNode);
            newOne.trailer=new doubleLinkedListNode(null,newNode,null);
            i=1;
            newOne.size++;
            while (i<=size){
                temp=temp.getNext();
                newOne.add(temp.getElement());
            }
        }
        newList = newOne;
        return newList;
    }
    /**
     *  @param o
     *  @return true if this list contains an element with the same value as the
     *  specified element.
     */
    @Override
    public boolean contains(Object o){
        boolean found = false;
        doubleLinkedListNode temp = header;
        temp=temp.getNext();
        while (temp!=trailer){
            if (temp.getElement()==o){
                found=true;
            }
            temp=temp.getNext();
        }
        return found;
    }
    public void sort() {
        for(int i=0;i<size();i++) {
            for(int j=i+1;j<size();j++) {
                int [] temp1 =(int[])get(i);
                int [] temp2 =(int[])get(j);
                if(temp2[1]>temp1[1]) {
                    set(i, temp2);
                    set(j, temp1);
                }
            }
        }
    }
    public void dublicates() {
        for(int i=0;i<size()-1;i++) {
            int [] temp1= (int[]) get(i);
            int [] temp2 =(int[]) get(i+1);
            if(temp1[1]==temp2[1]){
                temp1[0]=temp1[0]+temp2[0];
                set(i, temp1);
                remove(i+1);
                i--;
            }

        }
    }
    public void removeZeroes() {
        for(int i=0;i<size();i++) {
            int [] temp1= (int[]) get(i);
            if(temp1[0]==0) {
                remove(i);
                i--;
            }
        }

    }
    public void show() {
        doubleLinkedListNode n = header;
        while(n.getNext()!=trailer) {
            n=n.getNext();
            System.out.println(Arrays.toString((int[])n.getElement()));
        }
    }
}

