/**
 * BSTUtilities has a collection of static methods for operating on binary search trees.
 * 
 * @author Rishik Sehgal
 * @version Nov 16, 2025
 * Name of File does not follow CheckStyle
 * 
 */
public abstract class BSTUtilities
{
    /**
     * Determines where a TreeNode contains a Comparable
     * @param t TreeNode to search
     * @param x Comparable to compare
     * @param display to use 
     * @return true if contains x
     */
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
    /**
     * Inserts a node in a tree
     * @param t Tree which is inserted in
     * @param x value of node to insert
     * @param display display used 
     * @return returns a TreeNode with the value added 
     */
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
    /**
     * Helper method for delete
     * @param t Tree in which t will be deleted
     * @param display used
     * @return new binary search tree
     */
    //precondition:  t is a binary search tree in ascending order
    //postcondition: returns a pointer to a binary search tree,
    //               in which the value at node t has been deleted
    //               (and no new TreeNodes have been created)
    private static TreeNode deleteNode(TreeNode t, TreeDisplay display)
    {
        if(t.getLeft() == null && t.getRight() == null)
        {
            return null;
        }
        else if(t.getLeft() == null && t.getRight() != null)
        {
            return t.getRight();
        }
        else if(t.getRight() == null)
        {
            return t.getLeft();
        }
        t.setVal(TreeUtil.leftmost(t.getRight()));
        t.setRight(delete(t.getRight(), (Comparable) TreeUtil.leftmost(t.getRight()), display));
        return t;
    }

    /**
     * Deletes a given value if there from a Binary search tree
     * @param t binary search tree 
     * @param x comparable to be deleted 
     * @param display display utilized
     * @return new Tree
     */
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
        if(x.equals(t.getValue()))
        {
            display.visit(t);
            return deleteNode(t, display);
        }
        else if(x.compareTo(t.getValue()) < 0)
        {
            display.visit(t);
            t.setLeft(delete(t.getLeft(), x, display));
        }
        else if(x.compareTo(t.getValue()) > 0)
        {
            display.visit(t);
            t.setRight(delete(t.getRight(), x, display));
        }
        return t;
    }
}