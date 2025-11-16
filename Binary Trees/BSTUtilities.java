//a collection of static methods for operating on binary search trees
public abstract class BSTUtilities
{
	//precondition:  t is a binary search tree in ascending order
	//postcondition: returns true if t contains the value x;
	//               otherwise, returns false
	public static boolean contains(TreeNode t, Comparable x, TreeDisplay display)
	{
		if(t == null)
		{
			return false;
		}
		if(x.compareTo(t.getValue()) == 0)
		{
			return true;
		}
		return contains(t.getLeft(), x , display) || contains(t.getRight(), x, display);
		
	}

	//precondition:  t is a binary search tree in ascending order
	//postcondition: if t is empty, returns a new tree containing x;
	//               otherwise, returns t, with x having been inserted
	//               at the appropriate position to maintain the binary
	//               search tree property; x is ignored if it is a
	//               duplicate of an element already in t; only one new
	//               TreeNode is created in the course of the traversal
	public static TreeNode insert(TreeNode t, Comparable x, TreeDisplay display)
	{
		if(t == null)
		{
			return new TreeNode(x);
		}
		else if(x.compareTo(t.getValue()) < 0)
		{
			t.setLeft(insert(t.getLeft(), x, display));
		}
		else if(x.compareTo(t.getValue()) > 0)
		{
			t.setRight(insert(t.getRight(), x, display));
		}
		return t;

	}

	//precondition:  t is a binary search tree in ascending order
	//postcondition: returns a pointer to a binary search tree,
	//               in which the value at node t has been deleted
	//               (and no new TreeNodes have been created)
	private static TreeNode deleteNode(TreeNode t, TreeDisplay display)
	{
		// Case 1: Node has no children (leaf node)
		if(t.getLeft() == null && t.getRight() == null)
		{
			return null;
		}
		
		// Case 2: Node has only a right child
		if(t.getLeft() == null)
		{
			return t.getRight();
		}
		
		// Case 3: Node has only a left child
		if(t.getRight() == null)
		{
			return t.getLeft();
		}
		
		// Case 4: Node has two children
		// Find the in-order successor (smallest value in right subtree)
		TreeNode successor = t.getRight();
		while(successor.getLeft() != null)
		{
			successor = successor.getLeft();
		}
		
		// Replace current node's value with successor's value
		t.setVal(successor.getValue());
		
		// Delete the successor from the right subtree
		t.setRight(delete(t.getRight(), (Comparable)successor.getValue(), display));
		
		return t;
	}

	//precondition:  t is a binary search tree in ascending order
	//postcondition: returns a pointer to a binary search tree,
	//               in which the value x has been deleted (if present)
	//               (and no new TreeNodes have been created)
	public static TreeNode delete(TreeNode t, Comparable x, TreeDisplay display)
	{
		if(t == null)
		{
			return null;
		}
		
		int compareResult = x.compareTo(t.getValue());
		
		if(compareResult < 0)
		{
			// Value is in left subtree
			t.setLeft(delete(t.getLeft(), x, display));
		}
		else if(compareResult > 0)
		{
			// Value is in right subtree
			t.setRight(delete(t.getRight(), x, display));
		}
		else
		{
			// Found the node to delete
			return deleteNode(t, display);
		}
		
		return t;
	}
}