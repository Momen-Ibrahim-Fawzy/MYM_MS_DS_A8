package queue;

public class arrayBasedQueue implements IQueue, IArrayBased{
    private int f;//pointer to the front of the queue in the array.
    private int r;//pointer to the rear(element after the end of the end) of the queue in the array.
    private Object []qArr;//the array where the queue is stored in.
    private int N;//the maximum number of the element in the array which contain the queue

    /**
     * to initialize the queue
     * it will be at maximum with n element
     */
    public arrayBasedQueue(int n) {
        qArr=new Object[n+1];
        f=0;//pointer to the front element
        r=0;//pointer to the rear
        N=n+1;//number of total elements
    }

    /**
     * to initialize the queue
     * if there was no input of number of total elements of the queue it will be at maximum with 100 element
     */
    public arrayBasedQueue() {
        int n=100;
        qArr=new Object[n+1];
        f=0;//pointer to the front element
        r=0;//pointer to the rear
        N=n+1;//number of total elements
    }

    /**
     * Inserts an item to the queue.
     */
    @Override
    public void enqueue(Object item){
        if (item!=null&qArr!=null) {
            if (this.size() == N - 1) {
                RuntimeException runtime = new RuntimeException();
                throw runtime;
            }
            qArr[r] = item;
            r = (r + 1) % N;
        }
        else{
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * Removes the object at the queue rear and returns it.
     * and throw a RuntimeException if the queue was empty.
     */
    @Override
    public Object dequeue() {
        if (qArr!=null) {
            if (this.isEmpty()) {
                RuntimeException runtime = new RuntimeException();
                throw runtime;
            }
            Object temp = qArr[f];
            qArr[f] = (Integer) null;
            f = (f + 1) % N;
            return temp;
        }
        else{
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }

    /**
     * Tests if this queue is empty.
     */
    @Override
    public boolean isEmpty() {
        if (f==r) {
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
        if (qArr!=null) {
            int size = (N - f + r) % N;
            return size;
        }
        else{
            NullPointerException NullPointer = new NullPointerException();
            throw NullPointer;
        }
    }
}
