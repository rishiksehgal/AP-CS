public class MyTreeSet<E>
{
	private TreeNode root;
	private int size;
	private TreeDisplay display;

	public MyTreeSet()
	{
		size = 0;
        root = new TreeNode(null);
		display = new TreeDisplay();
	}

	public int size()
	{
		return size;
	}

	public boolean contains(Object obj)
	{
		if(size == 0)
        {
            return false;
        }
        Comparable x = (Comparable)obj;
        TreeNode y = root;
        while(y != null)
        {
            int cmp = x.compareTo(y.getValue());
            if(cmp == 0)
                return true;
            else if(cmp > 0)
                y = y.getRight();
            else
                y = y.getLeft();
        }
        return false;
	}

	// if obj is not present in this set, adds obj and
	// returns true; otherwise returns false
	public boolean add(E obj)
	{
		
	}

	// if obj is present in this set, removes obj and
	// returns true; otherwise returns false}
	public boolean remove(Object obj)
	{
		
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
}