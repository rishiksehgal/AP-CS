import java.util.Iterator;
import java.util.ConcurrentModificationException;
/**
 * MyLinkedList is our implementation of a doubly LinkedList.
 *
 * @param <E> the type of elements stored in the list
 * @author Rishik Sehgal
 * @version Oct 3, 2025
 */
public class MyLinkedList<E>
{
    private DoubleNode first;
    private DoubleNode last;
    private int size;

    /**
     * Creates an empty linked list.
     */
    public MyLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return string form of list
     */
    public String toString()
    {
        DoubleNode node = first;
        if (node == null)
        {
            return "[]";
        }

        String s = "[";
        while (node.getNext() != null)
        {
            s += node.getValue() + ", ";
            node = node.getNext();
        }
        return s + node.getValue() + "]";
    }

    /** 
     * Returns the node looking from the front.
     *
     * @param index index of node
     * @return the node at index
     * @precondition  0 <= index <= size / 2
     * @postcondition starting from first returns the node with the index
     */               
    private DoubleNode getNodeFromFirst(int index)
    {
        DoubleNode x = first;
        int z = 0;
        while (z != index)
        {
            x = x.getNext();
            z++;
        }
        return x;
    }

    /** 
     * Returns the node looking from the end.
     *
     * @param index index of node
     * @return the node at the index
     * @precondition  size / 2 <= index < size
     * @postcondition starting from last returns the node with the index given
     */               
    private DoubleNode getNodeFromLast(int index)
    {
        DoubleNode x = last;
        int z = size - 1;
        while (z != index)
        {
            x = x.getPrevious();
            z--;
        }
        return x;
    }

    /** 
     * Returns the node at the given index.
     *
     * @param index index of the node
     * @return the node at the index
     * @precondition  0 <= index < size
     * @postcondition returns the node
     */               
    private DoubleNode getNode(int index)
    {
        if (index < size / 2)
        {
            return getNodeFromFirst(index);
        }
        return getNodeFromLast(index);
    }

    /**
     * Returns the number of elements in the list
     *
     * @return size
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns the element at the index.
     *
     * @param index index of the element
     * @return element at the index
     */
    public E get(int index)
    {
        DoubleNode x = getNode(index);
        return (E) x.getValue();
    }

    /** 
     * Replaces the element at index with obj.
     *
     * @param index the index of the element to replace
     * @param obj the new element
     * @return the element formerly at the specified position
     * @postcondition element at the index is replaced
     */
    public E set(int index, E obj)
    {
        DoubleNode x = getNode(index);
        E y = (E) x.getValue();
        x.setValue(obj);
        return y;
    }

    /**
     * Adds obj to end of list.
     *
     * @param obj element to add
     * @return true
     * @postcondition obj is added to the end of the list
     */
    public boolean add(E obj)
    {
        addLast(obj);
        return true;
    }

    /** 
     * Inserts obj at the given index.
     *
     * @param index index where to insert
     * @param obj element to insert
     * @precondition  0 <= index <= size
     * @postcondition inserts obj at position index,
     *                moving elements at position index and higher
     *                to the right (adds 1 to their indices) and adjusts size
     */
    public void add(int index, E obj)
    {
        if (index == size)
        {
            addLast(obj);
        }
        else if (index == 0)
        {
            addFirst(obj);
        }
        else
        {
            DoubleNode x = new DoubleNode(obj);
            DoubleNode y = getNode(index);
            x.setPrevious(y.getPrevious());
            y.getPrevious().setNext(x);
            x.setNext(y);
            y.setPrevious(x);
            size++;
        }
    }

    /** 
     * Removes the element at the index
     *
     * @param index index of element to remove
     * @return removed element, or null if out of bounds
     * @postcondition elements at position index + 1 and higher are moved
     *                to the left (subtracts 1 from their indices)
     *                and size is adjusted
     */
    public E remove(int index)
    {
        if (index >= size || index < 0)
        {
            return null;
        }

        E x = (E) getNode(index).getValue();
        if (index == size - 1)
        {
            removeLast();
        }
        else if (index == 0)
        {
            removeFirst();
        }
        else
        {
            DoubleNode y = getNode(index);
            y.getNext().setPrevious(y.getPrevious());
            y.getPrevious().setNext(y.getNext());
            size--;
        }
        return x;
    }
    
    /**
     * Inserts obj at the beginning of the list.
     *
     * @param obj element to insert
     * @postcondition obj becomes the new first element
     */
    public void addFirst(E obj)
    {
        DoubleNode x = new DoubleNode(obj);
        if (first == null)
        {
            first = x;
            last = x;
        }
        else
        {
            x.setNext(first);
            first.setPrevious(x);
            first = x;
        }
        size++;
    }

    /**
     * Inserts obj at the end of the list.
     *
     * @param obj element to insert
     * @postcondition obj becomes the new last element
     */
    public void addLast(E obj)
    {
        DoubleNode x = new DoubleNode(obj);
        if (first == null)
        {
            first = x;
            last = x;
        }
        else
        {
            x.setPrevious(last);
            last.setNext(x);
            last = x;
        }
        size++;
    }

    /**
     * Returns the first element of the list.
     *
     * @return first element
     */
    public E getFirst()
    {
        if (first == null)
        {
            return null;
        }
        return (E) first.getValue();
    }

    /**
     * Returns the last element of the list
     *
     * @return last element
     */
    public E getLast()
    {
        if (last == null)
        {
            return null;
        }
        return (E) last.getValue();
    }

    /**
     * Removes the first element of the list and returns it
     *
     * @return removed element
     */
    public E removeFirst()
    {
        if (first == null)
        {
            return null;
        }

        E r = (E) first.getValue();
        first = first.getNext();
        if (first != null)
        {
            first.setPrevious(null);
        }
        else
        {
            last = null;
        }
        size--;
        return r;
    }

    /**
     * Removes and returns the last element
     *
     * @return removed element
     */
    public E removeLast()
    {
        if (last == null)
        {
            return null;
        }

        E r = (E) last.getValue();
        last = last.getPrevious();
        if (last != null)
        {
            last.setNext(null);
        }
        else
        {
            first = null;
        }
        size--;
        return r;
    }

    /**
     * Returns an iterator
     *
     * @return iterator
     */
    public Iterator<E> iterator()
    {
        return new MyLinkedListIterator();
    }

    /**
     * Iterator class for MyLinkedList.
     */
    private class MyLinkedListIterator implements Iterator<E>
    {
        private DoubleNode nextNode;
        private DoubleNode returned;
        private boolean remove;
        private int rightSize;
        private Object[] rightStuff;

        /**
         * Creates an iterator at the start of the list.
         */
        public MyLinkedListIterator()
        {
            if (first != null)
            {
                nextNode = first;
            }
            returned = null;
            remove = false;
            expectedList();
        }

        /**
         * Checks if there are more elements.
         *
         * @return true if there is another element
         */
        public boolean hasNext()
        {
            checkMod();
            return nextNode != null;
        }

        /**
         * Returns the next element
         *
         * @return next element
         */
        public E next()
        {
            checkMod();
            if (!hasNext())
            {
                return null;
            }
            E x = (E) nextNode.getValue();
            returned = nextNode;
            nextNode = nextNode.getNext();
            remove = true;
            return x;
            
        }

        /**
         * Removes the last element returned by next().
         *
         * @precondition next method has to be called
         * @postcondition last element is removed and size is decremented
         */
        public void remove()
        {
            checkMod();
            if (remove && returned != null)
            {
                if (returned.getPrevious() == null)
                {
                    first = nextNode;
                }
                else
                {
                    returned.getPrevious().setNext(returned.getNext());
                }

                if (returned.getNext() == null)
                {
                    last = returned.getPrevious();
                }
                else
                {
                    returned.getNext().setPrevious(returned.getPrevious());
                }

                size--;
                returned = null;
                remove = false;
                expectedList();
            }
        }
        public void expectedList()
        {
            int x = 0;
            rightSize = MyLinkedList.this.size;
            rightStuff = new Object[rightSize];
            for(DoubleNode y = first; y!= null; y = y.getNext())
            {
                rightStuff[x] = y.getValue();
                x++;
            }
        }
        public void checkMod()
        {
            if (size != rightSize)
            {
                throw new ConcurrentModificationException();
            }
            int x = 0;
            DoubleNode y = first;
            for (; y != null && x < rightSize; y = y.getNext())
            {
                if (y.getValue() != rightStuff[x])
                {
                    throw new ConcurrentModificationException();
                }
                x++;
            }
            if (y != null || x != rightSize)
            {
                throw new ConcurrentModificationException();
            }
        }
    }
}
