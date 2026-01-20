import java.util.ArrayList;
import java.util.Iterator;

/**
 * MyTreeSet mirrors a Tree Set.
 * 
 * @param <E> thing
 * @author Rishik Sehgal
 * @version 1
 *
 */ 
public class MyTreeSet<E>
{
    private TreeNode root;
    private int size;
    private TreeDisplay display;

    /**
     * Creates a MyTreeSet Object
     */
    public MyTreeSet()
    {
        size = 0;
        display = new TreeDisplay();
    }

    /**
     * Returns the size of the TreeSet
     * @return the size
     */
    public int size()
    {
        return size;
    }

    /**
     * Determines if the TreeSet contains an object
     * @param obj object being analyzed
     * @return true if it has the object
     */
    public boolean contains(Object obj)
    {
        Comparable  x = (Comparable) obj;
        return BSTUtilities.contains(root, x, display);
    }


    /**
     * if obj is not present in this set, adds obj and
     * returns true; otherwise returns false
     * @param obj being added
     * @return true if added
     */
    public boolean add(E obj)
    {
        if(root == null)
        {
            root = new TreeNode(obj);
            size++;
            return true;
        }
        if(contains(obj))
        {
            return false;
        }
        else
        {
            size++;
            root = BSTUtilities.insert(root, (Comparable) obj, display);
            return true;
        }
    }

    // if obj is present in this set, removes obj and
    // returns true; otherwise returns false}
    /**
     * if obj is present in this set, removes obj and
     * returns true; otherwise returns false}
     * @param obj being removed
     * @return true if removed
     */
    public boolean remove(Object obj)
    {
        if(!contains(obj))
        {
            return false;
        }
        root = BSTUtilities.delete(root, (Comparable) obj, display);
        size--;
        return true;
    }

    /**
     * Returns the toString
     * @return toString
     */
    public String toString()
    {
        return toString(root);
    }

    /**
     * Returns the toString
     * @param t of a TreeSet
     * @return the toString
     */
    private String toString(TreeNode t)
    {
        if (t == null)
        {
            return " ";
        }
        return toString(t.getLeft()) + t.getValue() + toString(t.getRight());
    }

    /**
     * Returns an interator
     * @return an iterator
     */
    public TreeSetIterator iterator()
    {
        return new TreeSetIterator();
    }

    /**
    * TreeSetIterator for MyTreeSet class
    * 
    * @author Rishik Sehgal
    * @version 1
    *
     */ 
    private class TreeSetIterator implements Iterator
    {
        private ArrayList<Object> vals = new ArrayList<Object>();
        private int next = 0;
        private int last = -1;

        /**
         * Creates a TreeSetIterator Object
         */
        public TreeSetIterator()
        {
            inOrder(root);
        }

        /**
         * Returns true if it has a next
         * @return true if has next
         */
        public boolean hasNext()
        {
            return next < vals.size();
        }

        /**
         * Adds the inOrder values in the vals arraylist.
         * @param t tree being traversed
         */
        public void inOrder(TreeNode t)
        {
            if (t == null)
            {
                return;
            }
            inOrder(t.getLeft());
            vals.add(t.getValue());
            inOrder(t.getRight());
        }
        
        /**
         * Returns the Object from next and traverses
         * @return the next Object
         */
        public Object next()
        {
            last= next;
            int temp = next;
            next++;
            return vals.get(temp);
        }

        /**
         * Removes the Object just returned by next
         */
        public void remove()
        {
            MyTreeSet.this.remove(vals.get(last));
            vals.remove(last);
            if (last < next)
            {
                next--;
            }
            last = -1;
        }
    }
}