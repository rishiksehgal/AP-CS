/**
 * DoubleNode Class that is used to create a Linked List.
 * 
 * @author Rishik Sehgal
 * No assistance    
 * 
 * @version Sep 27, 2025
 */
public class DoubleNode
{
	private Object value;
	private DoubleNode previous;
	private DoubleNode next;

	/**
	 * Creates a DoubleNode Object
	 * 
	 * @param v is the Object that the node stores.
	 */
	public DoubleNode(Object v)
	{
		value = v;
		previous = null;
		next = null;
	}

	/**
	 * Returns the value of the Node 
	 * @return The value stored in the node
	 */
	public Object getValue()
	{
		return value;
	}

	/**
	 * Returns the previous node in the list
	 * @return the previous node in the lsit
	 */
	public DoubleNode getPrevious()
	{
		return previous;
	}

	/**
	 * Returns the next node in the list
	 * @return the next node in the list
	 */
	public DoubleNode getNext()
	{
		return next;
	}

	/**
	 * Sets the value of the node
	 * @param v is the value of the node
	 */
	public void setValue(Object v)
	{
		value = v;
	}

	/**
	 * Sets the previous node reference
	 * @param p is the DoubleNode
	 */
	public void setPrevious(DoubleNode p)
	{
		previous = p;
	}

	/**
	 * Sets the next node reference
	 * 
	 * @param n is the DoubleNode
	 */
	public void setNext(DoubleNode n)
	{
		next = n;
	}
}