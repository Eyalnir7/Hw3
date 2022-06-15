public interface Queue<E extends Cloneable> extends Iterable<E>, Cloneable {
    /**
     * add an element to the end of the queue
     * @param element the element we want to add to the queue
     */
    void enqueue(E element);
    /**
     * remove the element in the start of the queue
     * @return the element in the start of the queue
     */
    E dequeue();

    /**
     * shows the element in the start of the queue
     * @return the element in the start of the queue
     */
    E peek();

    /**
     * @return the size of the queue
     */
    int size();

    /**
     * @return whether queue is empty or not
     */
    boolean isEmpty();
    Queue<E> clone();
}


