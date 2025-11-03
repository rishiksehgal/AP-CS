import java.util.NoSuchElementException;

/**
 * ArrayQueue is our implementation of a Queue.
 * @param <E> type stored in Queue
 * @author Rishik Sehgal
 * @version Oct 31, 2025
 */
public class ArrayQueue<E> implements MyQueue<E>
{
    private int size; 
    private Object[] thing;
    private int index;
    private int capacity;

    /**
     * Creates an ArrayQueue object
     * @param s is the size of the Queue
     */
    public ArrayQueue(int s)
    {
        size = 0;
        capacity = s;
        index = 0;
        thing = new Object[capacity];
    }
    @Override
    public boolean add(E element)
    {
        if(size == capacity)
        {
            throw new IllegalStateException("Full capacity ");
        }
        int tail = (index + size) % capacity;
        thing[tail] = element;
        size++;
        return true;
    }
    
    @Override
    public E element()
    {
        if(size == 0)
        {   
            throw new NoSuchElementException("Empty ");
        }
        return (E) thing[index];
    }

    @Override
    public E remove()
    {
        if(size == 0)
        {
            throw new NoSuchElementException("Empty Queue");
        }
            E x = (E) thing[index];
            thing[index] = null;
            index = (index + 1)% capacity;
            size --;
            return x;
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }
    @Override
    public int size()
    {
        return size;
    }





}
