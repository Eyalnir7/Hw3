import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E extends Cloneable> implements Queue<E>{
    private E[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue

    // Constructor to initialize a queue
    ArrayQueue(int size)
    {
        arr =  (E[]) new Object[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    @Override
    public void enqueue(E element){
        if (isFull())
        {
            //do something later
        }

        rear = (rear + 1) % capacity;
        arr[rear] = element;
        count++;
    }

    public boolean isFull() {
        return count==capacity;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
        {
            //do something later
        }

        E x = arr[front];
        front = (front + 1) % capacity;
        count--;
        return x;
    }

    @Override
    public E peek() {
        if (isEmpty())
        {
            //do something later
        }
        return arr[front];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public Queue<E> clone() {
        E[] cloned = arr.clone();
        try {
            Method m = Object.class.getMethod("clone");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for(E element : arr){

        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator(this);
    }

    private class ArrayQueueIterator implements Iterator<E>{

        private final ArrayQueue<E> queue;
        private int front;

        public ArrayQueueIterator(ArrayQueue<E> queue){
            this.queue = queue;
            this.front = queue.front;
        }
        @Override
        public boolean hasNext() {
            return front != queue.rear;
        }

        @Override
        public E next() throws NoSuchElementException {
            if(!hasNext()) throw new NoSuchElementException();
            E element = queue.peek();
            front = (front+1)%capacity;
            return element;
        }
    }
}
