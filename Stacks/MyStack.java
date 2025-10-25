/**
 * MyStack mimics the actual Stack datastructure
 * 
 * @param <E> the type of objects that can be used in the Stack
 * @author Rishik Sehgal
 * No assistance    
 * 
 * @version Oct 7, 2025
 * 
 */
public class MyStack<E>
{
    private DoubleNode node;

    /**
     * Adds a node that becomes the head
     * @param item is the value for the head node
     * @return the value of the old head
     */
    public E push(E item)
    {
        DoubleNode n = new DoubleNode(item);
        if(isEmpty())
        {
            node = n;
        }
        else
        {
            node.setNext(n);
            n.setPrevious(node);
            node = n;
        }
        n.setNext(null);
        if(node != null)
        {
            E x = (E) node.getValue();
            node = n;
            return x;
        }
        return null;
    }

    /**
     * Gives the value of the head
     * @return the value of the head
     */
    public E peek()
    {
        if(isEmpty())
        {
            return null;
        }
        return (E) node.getValue();
    }

    /**
     * Deletes the first heead and makes the next node the head
     * @return the value of the deleted head
     */
    public E pop()
    {
        E thing = (E) node.getValue();
        node = node.getPrevious();
        if(node != null)
        {
            node.setNext(null);
        }
        return thing;
    }

    /**
     * Determines if the stack is empty
     * @return true if the stack is empty
     */
    public boolean isEmpty()
    {
        return (node == null);
    }

    /**
     * Searches for an element in the Stack
     * @param o the value being searched for 
     * @return the index of the thing being searched from the head
     */
    public int search(Object o)
    {
        int x = 0;
        DoubleNode n = node;
        while(n != null)
        {
            if(n.getValue().equals(o))
            {
                return x;
            }
            n = n.getPrevious();
            x++;
        }
        return -1;
        
    }

    /**
     * Returns the size of the Stack
     * @return the size of the Stack
     */
    public int size()
    {
        if(isEmpty())
        {
            return 0;
        }
        int x = 0;
        DoubleNode n = node;
        while(n != null)
        {
            n = n.getPrevious();
            x++;
        }
        return x;
    }
}
