import java.util.*;
import java.util.Iterator;

/**
 * MyHashSet is a hashtable.
 *
 * @param <E> thingy
 * @author Rishik Sehgal
 * @version 1
 */
public class MyHashSet<E>
{
    private static final int NUM_BUCKETS = 5;
    private LinkedList<E>[] buckets;
    private int size;

    /**
     * Creates a MyHashSet object.
     */
    public MyHashSet()
    {
        buckets = new LinkedList[NUM_BUCKETS];
        for (int i = 0; i < NUM_BUCKETS; i++)
        {
            buckets[i] = new LinkedList<E>();
        }
    }

    /**
     * Returns the index of the bucket.
     *
     * @param obj that is hashed
     * @return index
     */
    private int toBucketIndex(Object obj)
    {
        return Math.abs(obj.hashCode() % NUM_BUCKETS);
    }

    /**
     * Returns the size
     *
     * @return the size
     */
    public int size()
    {
        return size;
    }

    /**
     * Determines if the set has the object.
     *
     * @param obj being searched for
     * @return true if set has object
     */
    public boolean contains(Object obj)
    {
        for (Object i : buckets[toBucketIndex(obj)])
        {
            if (i.equals(obj))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds obj to set if not there.
     *
     * @param obj the object to add
     * @return true if added.
     */
    public boolean add(E obj)
    {
        if (!contains(obj))
        {
            buckets[toBucketIndex(obj)].add(obj);
            size++;
            return true;
        }
        return false;
    }
    

    /**
     * Removes an object from the HashSet
     * @param obj to be removed
     * @return if removed
     */
    public boolean remove(Object obj)
    {
        if (contains(obj))
        {
            buckets[toBucketIndex(obj)].remove(obj);
            size--;
            return true;
        }  
        return false;
    }


    /**
     * Returns the String coresponding to the set.
     * @return string corresponding to the set.
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < buckets.length; i++)
        {
            if (buckets[i].size() > 0)
            {
                s += i + ":" + buckets[i] + " ";
            }
        }
        return s;
    }

    /**
     * Returns an iterator for the Hash Set
     *
     * @return an iterator for the set
     */
    public Iterator iterator()
    {
        return new HashSetIterator();
    }

    /**
    * MyHashSetIterator is an iterator for the MyHashSet Class
    * @author Rishik Sehgal
    * @version 1
    */
    private class HashSetIterator implements Iterator
    {
        private int current;
        private Iterator<E> xIterator;

        /**
         * Creates a MyHashSetIterator object.
         */
        public HashSetIterator()
        {
            xIterator = buckets[0].iterator();
            goToNext();
        }

        /**
         * Makes the Iterator go to the next bucket that is not empty.
         * It stops at the 5th bucket indicating that nothing is non - empty.
         */
        private void goToNext()
        {
            while (current < NUM_BUCKETS && !xIterator.hasNext())
            {
                current++;
                if (current < NUM_BUCKETS)
                {
                    xIterator = buckets[current].iterator();
                }
            }
        }

        /**
         * Returns true if the iterator can iterate again
         *
         * @return true if there are more elements in the HashSet.
         */
        public boolean hasNext()
        {
            return ((current < NUM_BUCKETS) && (xIterator.hasNext()));
        }

        /**
         * Returns the next element
         * Goes to the next one if there are not any elements left in the current bucket.
         * @return the next element
         * 
         */
        public E next()
        {
            E x = xIterator.next();
            if (!xIterator.hasNext())
            {
                goToNext();
            }
            return x;
        }

        /**
         * Removes the last element that next() returs.
         */
        public void remove()
        {
            xIterator.remove();
            size--;
        }
    }
}