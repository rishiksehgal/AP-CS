import java.util.Iterator;
import java.util.ListIterator;

public class MyArrayList<E>
{
	private int size;
	private Object[] values;  //(Java doesn't let us make an array of type E)

	public MyArrayList()
	{
		size = 0;
		values = new Object[1];
	}

	public String toString()
	{
		if (size == 0)
			return "[]";

		String s = "[";
		for (int i = 0; i < size - 1; i++)
			s += values[i] + ", ";
		return s + values[size - 1] + "]";
	}

	/**
	* @postcondition replaces the array with one that is
	*               twice as long, and copies all of the
	*               old elements into it
	*/
	private void doubleCapacity()
	{
		Object[] x = new Object[values.length * 2];
		for(int i = 0; i < values.length; i++){
			x[i] = values[i];
		}
		values = x;
		
		
	}

	/**
	* @postcondition returns the length of the array
	*/
	public int getCapacity()
	{
		return values.length;
	}

	public int size()
	{
		int x = 0;
		for(int i = 0; i < values.length; i++){
			if (values[i] != null)
				x++;
		}
		return x;
	}

	public E get(int index)
	{
		if (values.length > index && values[index] instanceof E )
			return values[index];
		//(You will need to promise the return value is of type E.)
	}

	/** 
	* @postcondition replaces the element at position index with obj
	*               returns the element formerly at the specified position
	*/
	public E set(int index, E obj)
	{
		

		//(You will need to promise the return value is of type E.)
	}

	/**
	* @postcondition appends obj to end of list; returns true
	*/
	public boolean add(E obj)
	{
		/* if values is already full, call doubleCapacity before adding */

		throw new RuntimeException("INSERT MISSING CODE HERE");
	}

	/**
	* @postcondition removes element from position index, moving elements
	*               at position index + 1 and higher to the left
	*               (subtracts 1 from their indices) and adjusts size
	*               returns the element formerly at the specified position
	*/
	public E remove(int index)
	{
		throw new RuntimeException("INSERT MISSING CODE HERE");

		//(You will need to promise the return value is of type E.)
	}

	public Iterator<E> iterator()
	{
		return new MyArrayListIterator();
	}

	/**
	* @precondition  0 <= index <= size
	* @postcondition inserts obj at position index,
	*               moving elements at position index and higher
	*               to the right (adds 1 to their indices) and adjusts size
	*/
	public void add(int index, E obj)
	{
		;
	}

	private class MyArrayListIterator implements Iterator<E>
	{
		//the index of the value that will be returned by next()
		private int nextIndex;

		public MyArrayListIterator()
		{
			throw new RuntimeException("INSERT MISSING CODE HERE");
		}

		public boolean hasNext()
		{
			throw new RuntimeException("INSERT MISSING CODE HERE");
		}

		public E next()
		{
			throw new RuntimeException("INSERT MISSING CODE HERE");

			//(You will need to promise the return value is of type E.)
		}

		//@postcondition removes the last element that was returned by next
		public void remove()
		{
			throw new RuntimeException("INSERT MISSING CODE HERE");
		}
	}
}