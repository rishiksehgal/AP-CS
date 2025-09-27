import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<E>
{
	private DoubleNode first;
	private DoubleNode last;
	private int size;

	public MyLinkedList()
	{
		first = null;
		last = null;
		size = 0;
	}

	public String toString()
	{
		DoubleNode node = first;
		if (node == null)
			return "[]";
		String s = "[";
		while (node.getNext() != null)
		{
			s += node.getValue() + ", ";
			node = node.getNext();
		}
		return s + node.getValue() + "]";
	}

	/** 
	* @precondition  0 <= index <= size / 2
	* @postcondition starting from first, returns the node
	*               with given index (where index 0 returns first)
	*/               
	private DoubleNode getNodeFromFirst(int index)
	{
		DoubleNode x = first;
		int z = 0;
		while(z != index) {
			x = x.getNext();
			z++;
		}
			
		return x;
		
		
	}

	/** 
	* @precondition  size / 2 <= index < size
	* @postcondition starting from last, returns the node
	*               with given index (where index size-1 returns last)
	*/               
	private DoubleNode getNodeFromLast(int index)
	{
		DoubleNode x = last;
		int z = size - 1;
		while(z != index) {
			x = x.getPrevious();
			z--;
		}
			
		return x;
	}

	/** 
	* @precondition  0 <= index < size
	* @postcondition starting from first or last (whichever
	*               is closer), returns the node with given index
	*/               
	private DoubleNode getNode(int index)
	{
		if(index < size/2)
			return getNodeFromFirst(index);
		return getNodeFromLast(index);
	}

	public int size()
	{
		return size;
	}

	public E get(int index)
	{
		DoubleNode x = getNode(index);
		return (E) x.getValue();
	}

	/** 
	* @postcondition replaces the element at position index with obj
	               returns the element formerly at the specified position
	*/
	public E set(int index, E obj)
	{
		DoubleNode x = getNode(index);
		E y = (E) x.getValue();
		x.setValue(obj);
		return y;

		//(You will need to promise the return value is of type E.)
	}

	/**
	* @postcondition appends obj to end of list; returns true
	*/
	public boolean add(E obj)
	{
		addLast(obj);
		return true;
	}

	/** 
	* @postcondition removes element from position index, moving elements
	*               at position index + 1 and higher to the left
	*               (subtracts 1 from their indices) and adjusts size
	               returns the element formerly at the specified position
	*/
	public E remove(int index)
	{
		if(index >= size || index < 0)
			return null;
		E x = (E) getNode(index).getValue();
		if(index == size - 1)
			removeLast();
		else if (index == 0)
			removeFirst();
		else{
		DoubleNode y = getNode(index);
		y.getNext().setPrevious(y.getPrevious());
		y.getPrevious().setNext(y.getNext());
		size--;
		}
		return x;

		//(You will need to promise the return value is of type E.)
	}

	/** 
	* @precondition  0 <= index <= size
	* @postcondition inserts obj at position index,
	*                moving elements at position index and higher
	*                to the right (adds 1 to their indices) and adjusts size
	*/
	public void add(int index, E obj)
	{
		if(index == size)
			addLast(obj);
		else if (index == 0)
			addFirst(obj);
		else{
			DoubleNode x = new DoubleNode(obj);
			DoubleNode y = getNode(index);
			x.setPrevious(y.getPrevious());
			y.getPrevious().setNext(x);
			x.setNext(y);
			y.setPrevious(x);
			size++;
		}

		
		
	}

	public void addFirst(E obj)
	{
		DoubleNode x = new DoubleNode(obj);
		if(first == null){
			first = x;
			last = x;
		}
		else{
			x.setNext(first);
			first.setPrevious(x);
			first = x;
		}
		size++;
	}

	public void addLast(E obj)
	{
		DoubleNode x = new DoubleNode(obj);
		if(first == null){
			first = x;
			last = x;
		}
		else{
			x.setPrevious(last);
			last.setNext(x);
			last = x;
		}
		size++;
	}

	public E getFirst()
	{
		if(first == null)
			return null;
		return (E) first.getValue();
	}

	public E getLast()
	{
		if(last == null)
			return null;
		return (E) last.getValue();
	}

	public E removeFirst()
	{
		if(first == null)
			return null;
		E r = (E) first.getValue();
		first = first.getNext();
		if(first != null)
			first.setPrevious(null);
		else
			last = null;
		size--;
		return r;

		
	}

	public E removeLast()
	{
		if(last == null)
			return null;
		E r = (E) last.getValue();
		last = last.getPrevious();
		if(last != null)
			last.setNext(null);
		else
			first = null;
		size--;
		return r;
	}

	public Iterator<E> iterator()
	{
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements Iterator<E>
	{
		private DoubleNode nextNode;
		private DoubleNode returned;
		private boolean remove;

		public MyLinkedListIterator()
		{
			if(first != null)
				nextNode = first;
			returned = null;
			remove = false;
		}

		public boolean hasNext()
		{
			return nextNode != null;
		}

		public E next()
		{
			if(!hasNext())
				return null;
			E x = (E) nextNode.getValue();
			returned = nextNode;
			nextNode = nextNode.getNext();
			remove = true;
			return x;

			//(You will need to promise the return value is of type E.)
		}

		//@postcondition removes the last element that was returned by next
		public void remove()
		{
			if(remove && returned != null){
				if(returned.getPrevious() == null){
					first = nextNode;
				}
				else{
					returned.getPrevious().setNext(returned.getNext());
				}
				if(returned.getNext() == null)
					last = returned.getPrevious();
				else{
					returned.getNext().setPrevious(returned.getPrevious());
				}
				 size--;
				 returned = null;
				 remove = false;

			}
		}
	}
}