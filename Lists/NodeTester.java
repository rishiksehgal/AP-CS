/**
 * Tests if the Node Class Works as intended. 
 * 
 * @author  (Rishik Sehgal) 
 *   With assistance from N/A
 *
 * @version (Sep 21, 2025) 
 */
public class NodeTester 
{
    /* NodeTester methods: */

    /**
     * Write a description of method here.
     *
     * @param args arguments from the command line
     */
    public static void main(String [ ] args)
    {
        Node l = new Node(1,new Node(2, new Node(3, new Node(4,null))));
        System.out.println();
        l.traverseForward(); //1234
        System.out.println();
        l.traverseBackward();//4321
        l.addStart(0);//adds 0
        System.out.println();
        l.traverseForward();//01234
        System.out.println();
        l.addEnd(5);//adds 5 at the end
        l.traverseForward();//012345
        System.out.println();
        l.addAfter(1,5);
        l.traverseForward();//0152345
        System.out.println();
        l.addAfter(13,9);
        l.traverseForward();//01523459
    }

}