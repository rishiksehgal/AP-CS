/**
 * TreeNode is one element of the Binary Tree
 * 
 * @author Rishik Sehgal
 * @version 1
 *
 */ 
public class TreeNode 
{
    private TreeNode left;
    private TreeNode right;
    private Object value;

    /**
     * Creates a TreeNode object
     * @param val value 
     * @param l TreeNode to the left
     * @param r TreeNode to the right
     */
    public TreeNode(Object val, TreeNode l, TreeNode r)
    {
        left = l;
        right = r;
        value = val;
    }

    /**
     * Creeates a TreeNode Object
     * @param val value 
     */
    public TreeNode(Object val)
    {
        value = val;
    }

    /**
     * Returns TreeNode to the left
     * @return TreeNode to the left
     */
    public TreeNode getLeft()
    {
        return left;
    }

    /**
     * Returns TreeNode to the right
     * @return TreeNode to the right
     */
    public TreeNode getRight()
    {
        return right;
    }
    
    /**
     * Returns value of TreeNode
     * @return value of TreeNode
     */
    public Object getValue()
    {
        return value;
    }
    /**
     * Sets the TreeNode to the right
     * @param r the TreeNode to the right
     */
    public void setRight(TreeNode r)
    {
        right = r;
    }

    /**
     * Sets the TreeNode to the left
     * @param l the TreeNode to the left
     */
    public void setLeft(TreeNode l)
    {
        left = l;
    }

    /**
     * Sets the value of the TreeNode
     * @param v val of the TreeNode
     */
    public void setVal(Object v)
    {
        value = v;
    }

}
