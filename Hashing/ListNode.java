/**
 * ListNode represents a single node in a linked list.
 *
 * @param <E> the type of element stored in the node
 * @author Rishik Sehgal
 * @version 1
 */
public class ListNode<E>
{
    private E value;
    private ListNode<E> next;

    /**
     * Constructs a ListNode with the specified value.
     *
     * @param value the value to store in this node
     */
    public ListNode(E value)
    {
        this.value = value;
        this.next = null;
    }

    /**
     * Returns the value stored in this node.
     *
     * @return the value
     */
    public E getValue()
    {
        return value;
    }

    /**
     * Sets the value stored in this node.
     *
     * @param value the new value
     */
    public void setValue(E value)
    {
        this.value = value;
    }

    /**
     * Returns the next node in the linked list.
     *
     * @return the next node, or null if this is the last node
     */
    public ListNode<E> getNext()
    {
        return next;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next the next node
     */
    public void setNext(ListNode<E> next)
    {
        this.next = next;
    }
}
