/**
 * ListNode is a Node in a Linked List.
 *
 * @param <E> thingy
 * @author Rishik Sehgal
 * @version 1
 */
public class ListNode<E>
{
    private Object value;
    private ListNode<E> next;

    /**
     * Creates a ListNode Object
     *
     * @param v value in node
     */
    public ListNode(Object v)
    {
        value = v;
    }

    /**
     * Returns value of the node
     *
     * @return the value
     */
    public Object getValue()
    {
        return value;
    }

    /**
     * Sets the value for the ListNode.
     *
     * @param v is the value
     */
    public void setValue(Object v)
    {
        value = v;
    }

    /**
     * Returns the next node.
     *
     * @return next node
     */
    public ListNode<E> getNext()
    {
        return next;
    }

    /**
     * Sets the next node.
     *
     * @param n is the next node
     */
    public void setNext(ListNode<E> n)
    {
        next = n;
    }
}
