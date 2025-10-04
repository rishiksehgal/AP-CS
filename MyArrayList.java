import java.util.Iterator;
/**
 * MyArrayList is our implementation of an ArrayList.
 *
 * @param <E> the type of objects that can be used in the list
 * @author Rishik Sehgal
 * @version Oct 3, 2025
 */
public class MyArrayList<E> 
{
    private int size;

    private Object[] values;

    /**
     * Makes an empty Array List with a size of 0.
     */
    public MyArrayList() 
    {
        size = 0;
        values = new Object[1];
    }

    /**
     * Returns a string representation of the list.
     *
     * @return string form of list
     */
    public String toString() 
    {
        if (size == 0) 
        {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) 
        {
            sb.append(values[i]).append(", ");
        }
        sb.append(values[size - 1]).append("]");
        return sb.toString();
    }

    /**
     * Doubles the capacity of the array and copies elements into it.
     */
    private void doubleCapacity() 
    {
        Object[] temp = new Object[values.length * 2];
        for (int i = 0; i < size; i++) 
        {
            temp[i] = values[i];
        }
        values = temp;
    }

    /**
     * Returns the capacity of the array.
     *
     * @return capacity
     */
    public int getCapacity() 
    {
        return values.length;
    }

    /**
     * Returns the size of the list
     *
     * @return size of the list
     */
    public int size() 
    {
        return size;
    }

    /**
     * Returns the element at the index.
     *
     * @param index of element
     * @return element of index
     */
    public E get(int index) 
    {
        if (index >= size || index < 0) 
        {
            return null;
        }
        return (E) values[index];
    }

    /**
     * Replaces the element at the index with obj
     *
     * @param index index of element that is being replaced
     * @param obj   stored element
     * @return former element at position
     */
    public E set(int index, E obj) 
    {
        if (index >= size || index < 0) 
        {
            return null;
        }
        E temp = (E) values[index];
        values[index] = obj;
        return temp;
    }

    /**
     * Appends obj to end of list.
     *
     * @param obj element to add
     * @return true if added
     */
    public boolean add(E obj) 
    {
        if (values.length == size) 
        {
            doubleCapacity();
        }
        values[size] = obj;
        size++;
        return true;
    }

    /**
     * Removes element from ndex.
     *
     * @param index of element t oremove
     * @return removed element
     */
    public E remove(int index) 
    {
        if (index >= size || index < 0) 
        {
            return null;
        }
        E removed = (E) values[index];
        for (int i = index; i < size - 1; i++) 
        {
            values[i] = values[i + 1];
        }
        values[size - 1] = null;
        size--;
        return removed;
    }

    /**
     * Returns an iterator 
     *
     * @return iterator
     */
    public Iterator<E> iterator() 
    {
        return new MyArrayListIterator();
    }


    /**
     * Iterator class for MyArrayList.
     */
    private class MyArrayListIterator implements Iterator<E> 
    {
        private int nextIndex;
        private int last;

        /**
         * Creates an iterator at the start of list
        */
        MyArrayListIterator() 
        {
            nextIndex = 0;
            last = -1;
        }

        @Override
        public boolean hasNext() 
        {
            return nextIndex < size;
        }

        @Override
        public E next() 
        {
            if (hasNext()) 
            {
                E elem = (E) values[nextIndex];
                last = nextIndex;
                nextIndex++;
                return elem;
            }
            return null;
        }

        @Override
        public void remove() 
        {
            if (last < 0) 
            {
                return;
            }
            MyArrayList.this.remove(last);
            nextIndex--;
            last = -1;
        }
    }
}
