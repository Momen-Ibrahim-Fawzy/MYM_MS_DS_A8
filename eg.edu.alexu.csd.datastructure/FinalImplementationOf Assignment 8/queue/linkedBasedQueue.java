package queue;

import linkedList.SingleLinkedList;

public class linkedBasedQueue implements IQueue, ILinkedBased{
    SingleLinkedList.SingleLinkedListNode head;//work as a pointer to the head of the queue
    SingleLinkedList.SingleLinkedListNode tail;//work as a pointer to the tail of the queue
    int size;//the size of the queue

    /**
     * to initialize the queue
     */
    public linkedBasedQueue(){
        head=null;
        tail=null;
    }

    /**
     * Inserts an item to the queue.
     */
    @Override
    public void enqueue(Object item) {
        if (item!=null) {
            SingleLinkedList.SingleLinkedListNode newNode = new SingleLinkedList.SingleLinkedListNode(item);
            if (size == 0)
                head = newNode;
            else
                tail.setNext(newNode);
            tail = newNode;
            size++;
        }
        else{
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * Removes the object at the queue rear and returns it.
     * and throw a RuntimeException if the queue was empty
     */
    @Override
    public Object dequeue() throws RuntimeException {
        if(size==0) {
            RuntimeException runtime = new RuntimeException();
            throw runtime;
        }
        Object temp=head.getElement();
        head=head.getNext();
        size--;
        if(size==0)
            tail=null;
        return temp;
    }

    /**
     * Tests if this queue is empty.
     */
    @Override
    public boolean isEmpty() {
        if (size==0) {
            return true;
        }
        else
            return false;
    }

    /**
     * Returns the number of elements in the queue
     */
    @Override
    public int size() {
        return size;
    }
}
