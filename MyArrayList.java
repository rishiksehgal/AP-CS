import java.util.Iterator;
import java.util.ListIterator;
import java.util.ConcurrentModificationException;
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

    public void add(int index, E obj)
    {
        if (index > size || index < 0)
            return;
        if (values.length == size)
            doubleCapacity();
        for (int i = size; i > index; i--)
            values[i] = values[i - 1];
        values[index] = obj;
        size++;
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

    public ListIterator<E> listIterator()
    {
        return new MyArrayListIterator();
    }

    /**
     * Iterator class for MyArrayList.
     */
    private class MyArrayListIterator implements ListIterator<E> 
    {
        private int nextIndex;
        private int last;
        private int rightSize;
        private Object[] rightStuff;

        /**
         * Creates an iterator at the start of list
        */
        public MyArrayListIterator() 
        {
            nextIndex = 0;
            last = -1;
            expectedArray();
        }

        @Override
        public boolean hasNext() 
        {
            checkMod();
            return nextIndex < size;
        }

        @Override
        public E next() 
        {
            checkMod();
            if (hasNext()) 
            {
                E elem = (E) values[nextIndex];
                last = nextIndex;
                nextIndex++;
                return elem;
            }
            return null;
        }

        public int nextIndex()
        {
            checkMod();
            return nextIndex;
        }

        public int previousIndex()
        {
            checkMod();
            return nextIndex - 1;
        }

        public E previous()
        {
            checkMod();
            if(hasPrevious())
            {
               nextIndex--;
               last = nextIndex;
               return (E) values[last];

            }
            return null;
        }

        public void set(E obj)
        {
            checkMod();
            if(last < 0)
                return;
            MyArrayList.this.set(last,obj);
            expectedArray();
        }

        public boolean hasPrevious()
        {
            checkMod();
            return nextIndex > 0;
        }
        @Override
        public void remove() 
        {
            checkMod();
            if (last < 0) 
            {
                return;
            }
            MyArrayList.this.remove(last);
            nextIndex = last;
            last = -1;
            expectedArray();
        }

        public void add(E obj)
        {
            checkMod();
            MyArrayList.this.add(nextIndex, obj);
            nextIndex++;
            last = -1;
            expectedArray();
        }
        public void expectedArray()
        {
            rightSize = MyArrayList.this.size;
            rightStuff = new Object[rightSize];

            for(int i = 0; i < rightSize ; i++)
                rightStuff[i] = MyArrayList.this.values[i];
        }

        public void checkMod()
        {
            if(MyArrayList.this.size != rightSize)
                throw new ConcurrentModificationException();
            for (int i = 0; i < rightSize; i++)
            {
                if (MyArrayList.this.values[i] != rightStuff[i])
                    throw new ConcurrentModificationException();
            }
        }

    }
}
