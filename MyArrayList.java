import java.util.Iterator;
import java.util.ListIterator;

/**
 * MyArrayList Class that is used to create an ArrayList.
 * 
 * @author Rishik Sehgal
 * No assistance    
 * 
 * @version (Sep 27, 2025)
 */
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
		for(int i = 0; i < size; i++){
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
		return size;
	}

	public E get(int index)
	{
		if(index >= size || index < 0)
			return null;
		E x = (E) values[index];
		return x;
	}

	/** 
	* @postcondition replaces the element at position index with obj
	*               returns the element formerly at the specified position
	*/
	public E set(int index, E obj)
	{
		if(index >= size || index < 0)
			return null;
		E temp = (E) values[index];
		values[index] = obj;
		return temp;

		//(You will need to promise the return value is of type E.)
	}

	/**
	* @postcondition appends obj to end of list; returns true
	*/
	public boolean add(E obj)
	{
		if(values.length == size)
			doubleCapacity();
		values[size] = obj;
		size++;
		return true;
		/* if values is already full, call doubleCapacity before adding */

		
	}

	/**
	* @postcondition removes element from position index, moving elements
	*               at position index + 1 and higher to the left
	*               (subtracts 1 from their indices) and adjusts size
	*               returns the element formerly at the specified position
	*/
	public E remove(int index)
	{
		if(index >= size || index < 0)
			return null;
		E x = (E) values[index];
		for (int i = index; i < size - 1;i++)
			values[i] = values[i+1];
		values[size - 1] = null;
		size--;
		return x;

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
		if (index > size || index < 0)
			return;
		if (size == values.length)
			doubleCapacity();
		for (int i = size; i > index; i--)
			values[i] = values[i - 1];
		values[index] = obj;
		size++;
		
		
	}

	private class MyArrayListIterator implements Iterator<E>
	{
		//the index of the value that will be returned by next()
		private int nextIndex;
		private int last;

		public MyArrayListIterator()
		{
			nextIndex = 0;
			last = -1;
		}

		public boolean hasNext()
		{
				return nextIndex < size;
		}

		public E next()
		{
			if(hasNext()){
				E x = (E) values[nextIndex];
				last = nextIndex;
				nextIndex++;
				return x;
			}
			return null;
		}

		//@postcondition removes the last element that was returned by next
		public void remove()
		{
			if(last < 0)
				return;
			MyArrayList.this.remove(last);
			nextIndex--;
			last = -1;
		}
	}
}