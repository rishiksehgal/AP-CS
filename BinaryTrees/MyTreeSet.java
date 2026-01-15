import java.util.ArrayList;
import java.util.Iterator;

public class MyTreeSet<E>
{
	private TreeNode root;
	private int size;
	private TreeDisplay display;

	public MyTreeSet()
	{
		size = 0;
		display = new TreeDisplay();
	}

	public int size()
	{
		return size;
	}

	public boolean contains(Object obj)
	{
		Comparable  x = (Comparable) obj;
        return BSTUtilities.contains(root, x, display);
	}

	// if obj is not present in this set, adds obj and
	// returns true; otherwise returns false
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
            root = BSTUtilities.insert(root,(Comparable) obj, display);
            return true;
        }
	}

	// if obj is present in this set, removes obj and
	// returns true; otherwise returns false}
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

	public String toString()
	{
		return toString(root);
	}

	private String toString(TreeNode t)
	{
		if (t == null)
			return " ";
		return toString(t.getLeft()) + t.getValue() + toString(t.getRight());
	}

    public TreeSetIterator iterator()
    {
        return new TreeSetIterator();
    }

    private class TreeSetIterator implements Iterator
    {
        private ArrayList<Object> values = new ArrayList<Object>();
        private int nextIndex = 0;
        private int lastReturnedIndex = -1;

        public TreeSetIterator()
        {
            inOrderTraversal(root);
        }

        public void inOrderTraversal(TreeNode t)
        {
            if (t == null)
            {
                return;
            }
            inOrderTraversal(t.getLeft());
            values.add(t.getValue());
            inOrderTraversal(t.getRight());
        }
        

        public boolean hasNext()
        {
            return nextIndex < size;
        }




        public Object next()
        {
            lastReturnedIndex = nextIndex;
            int a = nextIndex;
            nextIndex++;
            return values.get(a);
        }



        public void remove()
        {
            MyTreeSet.this.remove(lastReturnedIndex);
            if (lastReturnedIndex < nextIndex)
            {
                nextIndex--;
            }
            lastReturnedIndex = -1;
        }
    }
}