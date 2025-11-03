/**
 * MyQueue is a Queue interface
 * @param <E> type stored in Queue
 * @author Rishik Sehgal
 * @version Oct 31, 2025
 */
public interface MyQueue<E>
{
    /**
     * Adds an element to the Queue
     * @param element to be added 
     * @return element added
     */
    public boolean add(E element);
    
    /**
     * Retrieves the element at the head of the queue
     * @return the element at the head of the queue
     * @throws NoSuchElementException if empty
     */
    public E element();

    /**
     * Removes the element at the head of the queue
     * @return the elment removed
     * @throws NoSuchElementException if empty
     */
    public E remove();

    /**
     * Checks if the queue is empty
     * @return true if the queue is empty
     */
    public boolean isEmpty();

    /**
     * Returns the size of the queue
     * @return the size of the queue
     */
    public int size();
}  
