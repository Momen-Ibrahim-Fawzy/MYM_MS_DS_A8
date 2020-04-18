package eg.edu.alexu.csd.datastructure.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * it is the test class of the implementation of the arrayBasedQueue
 * using some types of situations of the arrayBasedQueue
 *
 */
public class arrayBasedQueueTest {

    @org.junit.jupiter.api.Test
    void dequeueTestZero(){
        arrayBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.dequeue());
    }

    @org.junit.jupiter.api.Test
    void dequeueTestOne(){
        arrayBasedQueue s = new arrayBasedQueue();
        assertThrows(RuntimeException.class,()->s.dequeue());
    }

    @org.junit.jupiter.api.Test
    void dequeueTestTwo(){
        arrayBasedQueue s = new arrayBasedQueue();
        s.enqueue(5);//5
        assertEquals(5,s.dequeue());//-
        assertThrows(RuntimeException.class,()->s.dequeue());
    }

    @org.junit.jupiter.api.Test
    void dequeueTestThere(){
        arrayBasedQueue s = new arrayBasedQueue();
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
        arrayBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.enqueue(5));
    }

    @org.junit.jupiter.api.Test
    void enqueueTestOne(){
        arrayBasedQueue s = new arrayBasedQueue();
        s.enqueue(4);//4
        assertEquals(4,s.dequeue());//-
    }

    @org.junit.jupiter.api.Test
    void enqueueTestTwo(){
        arrayBasedQueue s = new arrayBasedQueue();
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
        arrayBasedQueue s = new arrayBasedQueue();
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
        arrayBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.enqueue(null));
    }

    @org.junit.jupiter.api.Test
    void isEmptyTestZero(){
        arrayBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyTestOne(){
        arrayBasedQueue s = new arrayBasedQueue();
        assertEquals(true,s.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestTwo(){
        arrayBasedQueue s = new arrayBasedQueue();
        s.enqueue(5);//5
        assertEquals(false,s.isEmpty());//5
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestThere(){
        arrayBasedQueue s = new arrayBasedQueue();
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
        arrayBasedQueue s = null;
        assertThrows(NullPointerException.class,()->s.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestOne(){
        arrayBasedQueue s = new arrayBasedQueue();
        assertEquals(0,s.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestTwo(){
        arrayBasedQueue s = new arrayBasedQueue();
        s.enqueue(5);//5
        assertEquals(1,s.size());//5
    }
    @org.junit.jupiter.api.Test
    void sizeTestThere() {
        arrayBasedQueue s = new arrayBasedQueue();
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
        arrayBasedQueue test1;
        test1=new arrayBasedQueue(5);
        assertEquals(true,test1.isEmpty());
        assertEquals(0,test1.size());
        test1.enqueue(3);
        test1.enqueue(2);
        assertEquals(false,test1.isEmpty());
        assertEquals(2,test1.size());
        test1.enqueue(1);
        test1.enqueue(5);
        test1.enqueue(6);
        Assertions.assertThrows(RuntimeException.class, ()->test1.enqueue(8));
        assertEquals(false,test1.isEmpty());
        assertEquals(3,test1.dequeue());
        assertEquals(2,test1.dequeue());
        assertEquals(3,test1.size());
        assertEquals(false,test1.isEmpty());
        assertEquals(1,test1.dequeue());
        assertEquals(2,test1.size());
        assertEquals(false,test1.isEmpty());
        assertEquals(5,test1.dequeue());
        assertEquals(1,test1.size());
        assertEquals(6,test1.dequeue());
        assertEquals(0,test1.size());
        assertEquals(true,test1.isEmpty());
    }
}
