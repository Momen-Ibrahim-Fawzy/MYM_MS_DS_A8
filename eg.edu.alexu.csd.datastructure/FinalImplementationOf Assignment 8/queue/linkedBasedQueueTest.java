package queue;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * it is the test class of the implementation of the linkedBasedQueue
 * using some types of situations of the linkedBasedQueue
 *
 */
public class linkedBasedQueueTest {

    @org.junit.jupiter.api.Test
    void dequeueTestZero(){
        linkedBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.dequeue());
    }

    @org.junit.jupiter.api.Test
    void dequeueTestOne(){
        linkedBasedQueue s = new linkedBasedQueue();
        assertThrows(RuntimeException.class,()->s.dequeue());
    }

    @org.junit.jupiter.api.Test
    void dequeueTestTwo(){
        linkedBasedQueue s = new linkedBasedQueue();
        s.enqueue(5);//5
        assertEquals(5,s.dequeue());//-
        assertThrows(RuntimeException.class,()->s.dequeue());
    }

    @org.junit.jupiter.api.Test
    void dequeueTestThere(){
        linkedBasedQueue s = new linkedBasedQueue();
        s.enqueue(5);//5
        assertEquals(5,s.dequeue());//-
        s.enqueue(3);//3
        s.enqueue(4);//3,4
        assertEquals(3,s.dequeue());//3
        assertEquals(4,s.dequeue());//-
        assertThrows(RuntimeException.class,()->s.dequeue());
    }

    @org.junit.jupiter.api.Test
    void enqueueTestZero(){
        linkedBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.enqueue(5));
    }

    @org.junit.jupiter.api.Test
    void enqueueTestOne(){
        linkedBasedQueue s = new linkedBasedQueue();
        s.enqueue(4);//4
        assertEquals(4,s.dequeue());//-
    }

    @org.junit.jupiter.api.Test
    void enqueueTestTwo(){
        linkedBasedQueue s = new linkedBasedQueue();
        s.enqueue(5);//5
        assertEquals(5,s.dequeue());//-
        s.enqueue(4);//4
        s.enqueue(5);//4,5
        assertEquals(4,s.dequeue());//5
        s.enqueue(3);//5,3
        assertEquals(5,s.dequeue());//3
        s.enqueue(2);//3,2
        assertEquals(3,s.dequeue());//2
        assertEquals(2,s.dequeue());//-
    }

    @org.junit.jupiter.api.Test
    void enqueueTestThere(){
        linkedBasedQueue s = new linkedBasedQueue();
        s.enqueue(5);//5
        assertEquals(5,s.dequeue());//-
        s.enqueue(4);//4
        assertEquals(4,s.dequeue());//-
        s.enqueue(3);//3
        s.enqueue(1);//3,1
        s.enqueue(100000);//3,1,100000
        assertEquals(3,s.dequeue());//1,100000
        assertEquals(1,s.dequeue());//100000
        assertEquals(100000,s.dequeue());//-
    }

    @org.junit.jupiter.api.Test
    void enqueueTestFour(){
        linkedBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.enqueue(null));
    }

    @org.junit.jupiter.api.Test
    void isEmptyTestZero(){
        linkedBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyTestOne(){
        linkedBasedQueue s = new linkedBasedQueue();
        assertEquals(true,s.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestTwo(){
        linkedBasedQueue s = new linkedBasedQueue();
        s.enqueue(5);//5
        assertEquals(false,s.isEmpty());//5
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestThere(){
        linkedBasedQueue s = new linkedBasedQueue();
        assertEquals(true,s.isEmpty());
        s.enqueue(5);//5
        assertEquals(false,s.isEmpty());
        s.enqueue(3);//5,3
        assertEquals(false,s.isEmpty());
        s.enqueue(4);//5,3,4
        assertEquals(false,s.isEmpty());
        s.enqueue(2);//5,3,4,1
        assertEquals(false,s.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void sizeTestZero(){
        linkedBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestOne(){
        linkedBasedQueue s = new linkedBasedQueue();
        assertEquals(0,s.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestTwo(){
        linkedBasedQueue s = new linkedBasedQueue();
        s.enqueue(5);//5
        assertEquals(1,s.size());//5
    }
    @org.junit.jupiter.api.Test
    void sizeTestThere() {
        linkedBasedQueue s = new linkedBasedQueue();
        assertEquals(0, s.size());
        s.enqueue(5);//5
        assertEquals(1, s.size());
        s.enqueue(3);//5,3
        assertEquals(2, s.size());
        s.enqueue(4);//5,3,4
        assertEquals(3, s.size());
        s.enqueue(2);//5,3,4,2
        assertEquals(4, s.size());
    }

    @org.junit.jupiter.api.Test
    void generalTest() {
        linkedBasedQueue test1;
        test1=new linkedBasedQueue();
        assertEquals(true,test1.isEmpty());
        assertEquals(0,test1.size());
        test1.enqueue(3);
        assertEquals(1,test1.size());
        test1.enqueue(4);
        test1.enqueue(5);
        test1.enqueue(6);
        test1.enqueue(7);
        test1.enqueue(8);
        assertEquals(false,test1.isEmpty());
        assertEquals(6,test1.size());
        assertEquals(3,test1.dequeue());
        assertEquals(4,test1.dequeue());
        assertEquals(5,test1.dequeue());
        assertEquals(6,test1.dequeue());
        assertEquals(7,test1.dequeue());
        assertEquals(8,test1.dequeue());
        assertEquals(0,test1.size());
        assertEquals(true,test1.isEmpty());

    }
}
