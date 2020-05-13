package stacks;

import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * it is the test class of the implementation of the stack
 * using some types of situations of the stack
 *
 */
public class StackTest {
    @org.junit.jupiter.api.Test
    void popTestZero(){
        Stack s = null;
        assertThrows(NullPointerException.class,()->s.pop());
    }
    @org.junit.jupiter.api.Test
    void popTestOne(){
        Stack s = new Stack();
        assertThrows(EmptyStackException.class,()->s.pop());
    }
    @org.junit.jupiter.api.Test
    void popTestTwo(){
        Stack s = new Stack();
        s.push(5);//5
        assertEquals(5,s.pop());//-
        assertThrows(EmptyStackException.class,()->s.pop());
    }
    @org.junit.jupiter.api.Test
    void popTestThere(){
        Stack s = new Stack();
        s.push(5);//5
        assertEquals(5,s.pop());//-
        s.push(3);//3
        s.push(4);//3,4
        assertEquals(4,s.pop());//3
        assertEquals(3,s.pop());//-
        assertThrows(EmptyStackException.class,()->s.pop());
    }
    @org.junit.jupiter.api.Test
    void peekTestZero(){
        Stack s = null;
        assertThrows(NullPointerException.class,()->s.pop());
    }
    @org.junit.jupiter.api.Test
    void peekTestOne(){
        Stack s = new Stack();
        assertThrows(EmptyStackException.class,()->s.peek());
    }
    @org.junit.jupiter.api.Test
    void peekTestTwo(){
        Stack s = new Stack();
        s.push(5);//5
        assertEquals(5,s.peek());//5
        s.pop();//-
        assertThrows(EmptyStackException.class,()->s.peek());
    }
    @org.junit.jupiter.api.Test
    void peekTestThere(){
        Stack s = new Stack();
        s.push(5);//5
        assertEquals(5,s.peek());//5
        s.push(3);//5,3
        s.push(4);//5,3,4
        assertEquals(4,s.peek());//5,3,4
        s.pop();//5,3
        assertEquals(3,s.peek());//5,3
        s.pop();//5
        assertEquals(5,s.peek());//5
        s.pop();//-
        assertThrows(EmptyStackException.class,()->s.peek());
    }
    @org.junit.jupiter.api.Test
    void pushTestZero(){
        Stack s = null;
        assertThrows(NullPointerException.class,()->s.push(5));
    }
    @org.junit.jupiter.api.Test
    void pushTestOne(){
        Stack s = new Stack();
        s.push(4);//4
        assertEquals(4,s.peek());//4
    }
    @org.junit.jupiter.api.Test
    void pushTestTwo(){
        Stack s = new Stack();
        s.push(5);//5
        assertEquals(5,s.peek());//5
        s.push(4);//5,4
        assertEquals(4,s.peek());//5,4
        s.push(3);//5,4,3
        assertEquals(3,s.peek());//5,4,3
        s.push(2);//5,4,3.2
        assertEquals(2,s.peek());//5,4,3,2
    }
    @org.junit.jupiter.api.Test
    void pushTestThere(){
        Stack s = new Stack();
        s.push(5);//5
        assertEquals(5,s.peek());//5
        s.push(4);//5,4
        assertEquals(4,s.peek());//5,4
        s.push(3);//5,4,3
        assertEquals(3,s.peek());//5,4,3
        s.push(1);//5,4,3,2,1
        assertEquals(1,s.peek());//5,4,3,2,1
        s.push(100000);//5,4,3,2,1,100000
        assertEquals(100000,s.peek());//5,4,3,2,1,100000
    }
    @org.junit.jupiter.api.Test
    void pushTestFour(){
        Stack s = null;
        assertThrows(NullPointerException.class,()->s.push(null));
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestZero(){
        Stack s = null;
        assertThrows(NullPointerException.class,()->s.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestOne(){
        Stack s = new Stack();
        assertEquals(true,s.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestTwo(){
        Stack s = new Stack();
        s.push(5);//5
        assertEquals(false,s.isEmpty());//5
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestThere(){
        Stack s = new Stack();
        assertEquals(true,s.isEmpty());
        s.push(5);//5
        assertEquals(false,s.isEmpty());
        s.push(3);//5,3
        assertEquals(false,s.isEmpty());
        s.push(4);//5,3,4
        assertEquals(false,s.isEmpty());
        s.push(2);//5,3,4,1
        assertEquals(false,s.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void sizeTestZero(){
        Stack s = null;
        assertThrows(NullPointerException.class,()->s.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestOne(){
        Stack s = new Stack();
        assertEquals(0,s.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestTwo(){
        Stack s = new Stack();
        s.push(5);//5
        assertEquals(1,s.size());//5
    }
    @org.junit.jupiter.api.Test
    void sizeTestThere(){
        Stack s = new Stack();
        assertEquals(0,s.size());
        s.push(5);//5
        assertEquals(1,s.size());
        s.push(3);//5,3
        assertEquals(2,s.size());
        s.push(4);//5,3,4
        assertEquals(3,s.size());
        s.push(2);//5,3,4,1
        assertEquals(4,s.size());
    }
}
