package stacks;

import java.util.EmptyStackException;

import linkedList.doubleLinkedList;

/**
 * that class is an implementation of Stack depends on the Double Linked List
 *
 */
public class Stack implements IStack{
    @SuppressWarnings("unused")
	private int size;
    private Object peek;
    doubleLinkedList s=new doubleLinkedList();

    /**
     * initialize Stack
     *
     */
    public Stack(){
        size= s.size();
        peek=null;//there is no elements in the stack
    }

    /**
     * Removes the element at the top of stack and returns that element.
     *
     * @return top of stack element, or through exception if empty
     */
    @Override
    public Object pop() {
        if(s==null){
            NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
        }
        else if (s.size()>0) {
            Object peakElement = peek();
            s.remove(s.size()-1);
            if (s.size()!=0) {
                peek = s.get(s.size() - 1);
            }
            else{
                peek=null;
            }
            size--;
            return peakElement;
        }
        else{
            EmptyStackException EmptyStack = new EmptyStackException();
            throw EmptyStack;
        }
    }

    /**
     * Get the element at the top of stack without removing it from stack.
     *
     * @return top of stack element, or through exception if empty
     */
    @Override
    public Object peek() {
        if(s==null){
            NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
        }
        else if (s.size()>0){
            return peek;
        }
        else {
            EmptyStackException EmptyStack = new EmptyStackException();
            throw EmptyStack;
        }
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param object
     * to insert
     */
    @Override
    public void push(Object element) {
        if (s==null|element==null){
            NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
        }
        s.add(element);
        peek=s.get(s.size()-1);
        size++;
    }

    /**
     * Tests if this stack is empty
     *
     * @return true if stack empty
     */
    @Override
    public boolean isEmpty() {
        if (s==null){
            NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
        }
        else if (s.size()==0){
            return true;
        }
        else
            return false;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    @Override
    public int size() {
        if (s==null){
            NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
        }
        return s.size();
    }
    public void showStack(){
        s.show();
    }
}
