package queue;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * it is the test class of the implementation of the priorityQueue
 * using some types of situations of the priorityQueue
 *
 */
public class priorityQueueTest{

    @org.junit.jupiter.api.Test
    void removeMinTestZero(){
        PriorityQueue s = null;
        assertThrows(NullPointerException.class,()->s.removeMin());
    }
    @org.junit.jupiter.api.Test
    void removeMinTestOne(){
        PriorityQueue s = new PriorityQueue();
        assertThrows(RuntimeException.class,()->s.removeMin());
    }
    @org.junit.jupiter.api.Test
    void removeMinTestTwo(){
        PriorityQueue s = new PriorityQueue();
        s.insert(5,0);//5
        assertEquals(5,s.removeMin());//-
        assertThrows(RuntimeException.class,()->s.removeMin());
    }
    @org.junit.jupiter.api.Test
    void removeMinTestThere(){
        PriorityQueue s = new PriorityQueue();
        s.insert(5,0);//5
        assertEquals(5,s.removeMin());//-
        s.insert(3,2);//3
        s.insert(4,0);//4,3
        assertEquals(4,s.removeMin());//3
        assertEquals(3,s.removeMin());//-
        assertThrows(RuntimeException.class,()->s.removeMin());
    }
    @org.junit.jupiter.api.Test
    void minTestZero(){
        PriorityQueue s = null;
        assertThrows(NullPointerException.class,()->s.min());
    }
    @org.junit.jupiter.api.Test
    void minTestOne(){
        PriorityQueue s = new PriorityQueue();
        assertThrows(RuntimeException.class,()->s.min());
    }
    @org.junit.jupiter.api.Test
    void minTestTwo(){
        PriorityQueue s = new PriorityQueue();
        s.insert(5,0);//5
        assertEquals(5,s.min());//5
        s.removeMin();//-
        assertThrows(RuntimeException.class,()->s.min());
    }
    @org.junit.jupiter.api.Test
    void minTestThere(){
        PriorityQueue s = new PriorityQueue();
        s.insert(5,0);//5
        assertEquals(5,s.min());//5
        s.insert(3,1);//5,3
        s.insert(4,-1);//4,5,3
        assertEquals(4,s.min());//4,5,3
        s.removeMin();//5,3
        assertEquals(5,s.min());//5,3
        s.removeMin();//3
        assertEquals(3,s.min());//3
        s.removeMin();//-
        assertThrows(RuntimeException.class,()->s.min());
    }
    @org.junit.jupiter.api.Test
    void insertTestZero(){
        PriorityQueue s = null;
        assertThrows(NullPointerException.class,()->s.insert(5,0));
    }

    @org.junit.jupiter.api.Test
    void insertTestOne(){
        PriorityQueue s = new PriorityQueue();
        s.insert(4,0);//4
        assertEquals(4,s.min());//4
    }

    @org.junit.jupiter.api.Test
    void insertTestTwo(){
        PriorityQueue s = new PriorityQueue();
        s.insert(5,0);//5
        assertEquals(5,s.min());//5
        s.insert(4,-1);//4,5
        assertEquals(4,s.min());//4,5
        s.insert(3,2);//4,5,3
        assertEquals(4,s.min());//4,5,3
        s.insert(2,-2);//2,4,5,3
        assertEquals(2,s.min());//5,4,3,2
    }

    @org.junit.jupiter.api.Test
    void insertTestThere(){
        PriorityQueue s = new PriorityQueue();
        s.insert(5,2);//5
        assertEquals(5,s.min());//5
        s.insert(4,0);//4,5
        assertEquals(4,s.min());//4,5
        s.insert(3,1);//4,3,5
        assertEquals(4,s.min());//4,3,5
        s.insert(1,-1);//1,4,3,5
        assertEquals(1,s.min());//1,4,3,5
        s.insert(100000,-2);//100000,1,4,3,5
        assertEquals(100000,s.min());//5,4,3,2,1,100000
    }

    @org.junit.jupiter.api.Test
    void insertTestFour(){
        PriorityQueue s = null;
        assertThrows(NullPointerException.class,()->s.insert(null,0));
    }

    @org.junit.jupiter.api.Test
    void isEmptyTestZero(){
        PriorityQueue s = null;
        assertThrows(NullPointerException.class,()->s.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyTestOne(){
        PriorityQueue s = new PriorityQueue();
        assertEquals(true,s.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyTestTwo(){
        PriorityQueue s = new PriorityQueue();
        s.insert(5,0);//5
        assertEquals(false,s.isEmpty());//5
    }

    @org.junit.jupiter.api.Test
    void isEmptyTestThere(){
        PriorityQueue s = new PriorityQueue();
        assertEquals(true,s.isEmpty());
        s.insert(5,0);//5
        assertEquals(false,s.isEmpty());
        s.insert(3,1);//5,3
        assertEquals(false,s.isEmpty());
        s.insert(4,2);//5,3,4
        assertEquals(false,s.isEmpty());
        s.insert(2,3);//5,3,4,1
        assertEquals(false,s.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void sizeTestZero(){
        PriorityQueue s = null;
        assertThrows(NullPointerException.class,()->s.size());
    }

    @org.junit.jupiter.api.Test
    void sizeTestOne(){
        PriorityQueue s = new PriorityQueue();
        assertEquals(0,s.size());
    }

    @org.junit.jupiter.api.Test
    void sizeTestTwo(){
        PriorityQueue s = new PriorityQueue();
        s.insert(5,0);//5
        assertEquals(1,s.size());//5
    }

    @org.junit.jupiter.api.Test
    void sizeTestThere(){
        PriorityQueue s = new PriorityQueue();
        assertEquals(0,s.size());
        s.insert(5,0);//5
        assertEquals(1,s.size());
        s.insert(3,1);//5,3
        assertEquals(2,s.size());
        s.insert(4,2);//5,3,4
        assertEquals(3,s.size());
        s.insert(2,3);//5,3,4,1
        assertEquals(4,s.size());
    }

    @org.junit.jupiter.api.Test
    void generalTest() {
        PriorityQueue test1;
        test1=new PriorityQueue();
        Assertions.assertThrows(RuntimeException.class, ()->test1.min());
        Assertions.assertThrows(RuntimeException.class, ()->test1.removeMin());
        assertEquals(0,test1.size());
        assertEquals(true,test1.isEmpty());
        test1.insert(5,1);
        assertEquals(false,test1.isEmpty());
        assertEquals(5,test1.min());//5(1)
        test1.insert(2,0);//2(0),5(1)
        assertEquals(2,test1.min());
        assertEquals(2,test1.size());
        test1.insert(7,4);//2(0),5(1),7(4)
        test1.insert(6,3);//2(0),5(1),6(3),7(4)
        test1.insert(9,2);//2(0),5(1),9(2),6(3),7(4)
        test1.insert(9,4);//2(0),5(1),9(2),6(3),7(4),9(4)
        test1.insert(0,-1);//0(-1),2(0),5(1),9(2),6(3),7(4),9(4)
        assertEquals(7,test1.size());//0(-1),2(0),5(1),9(2),6(3),7(4),9(4)
        assertEquals(0,test1.removeMin());//2(0),5(1),9(2),6(3),7(4),9(4)
        assertEquals(6,test1.size());//2(0),5(1),9(2),6(3),7(4),9(4)
        assertEquals(2,test1.removeMin());//5(1),9(2),6(3),7(4),9(4)
        assertEquals(5,test1.size());//5(1),9(2),6(3),7(4),9(4)
        assertEquals(5,test1.min());//5(1),9(2),6(3),7(4),9(4)
        assertEquals(5,test1.removeMin());//9(2),6(3),7(4),9(4)
        assertEquals(4,test1.size());//9(2),6(3),7(4),9(4)
        assertEquals(9,test1.min());//9(2),6(3),7(4),9(4)
        assertEquals(9,test1.removeMin());//6(3),7(4),9(4)
        assertEquals(3,test1.size());//6(3),7(4),9(4)
        assertEquals(6,test1.removeMin());//7(4),9(4)
        assertEquals(2,test1.size());//7(4),9(4)
        assertEquals(7,test1.removeMin());//9(4)
        assertEquals(1,test1.size());//9(4)
        assertEquals(9,test1.removeMin());//-
        assertEquals(0,test1.size());//-
        assertEquals(true,test1.isEmpty());//-
        Assertions.assertThrows(RuntimeException.class, ()->test1.min());
        Assertions.assertThrows(RuntimeException.class, ()->test1.removeMin());
    }
}
