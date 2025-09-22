/**
 * Node Class that is used to create a Linked List.
 * 
 * @author Rishik Sehgal
 * No assistance    
 * 
 * @version (Sep 21, 2025)
 */
public class Node{
    private Node before;
    private int val;
    private Node after;

    /**
     * Creates a Node object and sets the after and val values that are specified.
     * Also sets the current node as the before value for the next node in the list.
     * 
     * @param v is the val
     * @param a is the after Node
     */
    public Node(int v, Node a){
        this.val = v;
        this.after = a;
        if (a != null)
            a.setBefore(this);
    }

    /**
     * Returns the value of the Node
     */
    public int getVal(){
        return val;
    }

    /*
     * Returns the Node before the current one
     */
    public Node getBefore(){
        return before;
    }

    /*
     * Returns the Node after the current one
     */
    public Node getAfter(){
        return after;
    }

    /*
     * Sets the Value of the current Node.
     * @param v is the val of the current Node
     */
    public void setVal(int v){
        val = v;
    }

    /*
     * Sets the Before of the current Node.
     * @param b is the before of the current Node
     */
    public void setBefore(Node b){
        before = b;
    }

    /*
     * Sets the After of the current Node.
     * @param a is the after of the current Node
     */
    public void setAfter(Node a){
        after = a;
    }

    /**
     * Traverses the list from the current node.
     */
    public void traverseForward(){
        System.out.print(this.getVal() + "");
        if(this.getAfter() != null)
            this.getAfter().traverseForward();
    }

    /*
     * Traverses the list backward from the end.
     */
    public void traverseBackward(){
        if(this.getAfter() != null)
            this.getAfter().traverseBackward();
        else{
            Node x = this;
            while(x != null){
                System.out.print(x.getVal() + "");
                x = x.getBefore();
            }
                
        }
    }
    
    /*
     * Helper method that returns the last node in the list.
     */
    private Node goToEnd(){
        Node current = this;
        if(current != null){
            while(current.getAfter() != null){
                current = current.getAfter();
            }   
        }
        return current;
    }
    
    /*
     * Adds a new node with value at the start of the list
     * @param value is the value that is added at the start
     */
    public void addStart(int value){
        Node y = goToEnd();
        Node n = new Node(0, null);
        y.setAfter(n);
        n.setBefore(y);
        Node x = n; 
        while(x.getBefore() != null){
            x.setVal(x.getBefore().getVal());
            x = x.getBefore();
        }
        this.setVal(value);
    }
    
    /*
     * Adds a new node with value at the end of the list
     * @param value is the value that is added at the end
     */
    public void addEnd(int value){
        Node y = goToEnd();
        Node n = new Node(0, null);
        y.setAfter(n);
        n.setVal(value);
    }
    
    /*
     *  Adds a new node with a given value,  after the first occurence of a value.
     * If the value doesn't exits it should add this to end. 
     * @param search the value to search for
     * @param val the value of the new node to insert
     */
    public void addAfter(int search, int val){
        Node x = this;
        while (x != null){
                if(x.getVal() == search){
                    Node y = x.getAfter();
                    Node n = new Node(val, y);
                    x.setAfter(n);
                    n.setBefore(x);
                    if(y != null)
                        y.setBefore(n);
                    return;
                }
                x = x.getAfter();
        }
        addEnd(val);
    }
    
}