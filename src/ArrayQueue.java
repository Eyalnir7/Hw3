import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E extends Cloneable> implements Queue<E>{
    private final Cloneable[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue

    // Constructor to initialize a queue
    public ArrayQueue(int size)
    {
        if(size<0){
            throw new NegativeCapacityException();
        }
        arr = new Cloneable[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    @Override
    public void enqueue(E element){
        if (isFull())
        {
            throw new QueueOverflowException();
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
            throw new EmptyQueueException();
        }

        E x = (E)arr[front];
        front = (front + 1) % capacity;
        count--;
        return x;
    }

    @Override
    public E peek() {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return (E)arr[front];
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
    public ArrayQueue<E> clone() {

        ArrayQueue<E> cloned;
        E temp;
        try {
            cloned = (ArrayQueue<E>) super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }

        for(int i = 0; i < count; i++)
        {
            try{
                temp = cloned.dequeue();
                Method m = temp.getClass().getMethod("clone");
                cloned.enqueue((E) m.invoke(temp));
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return cloned;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator(this);
    }

    private class ArrayQueueIterator implements Iterator<E>{

        private final ArrayQueue<E> queue;

        public ArrayQueueIterator(ArrayQueue<E> queue){
            this.queue = queue.clone();
        }
        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if(!hasNext()) throw new NoSuchElementException();
            E element = (E)queue.dequeue();
            return element;
        }
    }
}
