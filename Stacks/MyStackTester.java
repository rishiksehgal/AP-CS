/**
 * MyStackTester class tests the functionality of the MyStack class
 * 
 * @author Rishik Sehgal
 * No assistance    
 * 
 * @version Oct 7, 2025
 */
public class MyStackTester 
{
    /**
     * Tests all the MyStack methods
     * @param args fancy thing
     */
    public static void main(String[] args) 
    {
        MyStack <Integer> stack = new MyStack<>(); //Creates the Stack
        System.out.println(stack.isEmpty()); //Prints true
        stack.push(6);
        System.out.println(stack.peek());// Prints 6
        stack.push(7);
        System.out.println(stack.peek());// Prints 7 
        stack.push(8); 
        System.out.println(stack.search(7)); //Prints 1
        System.out.println(stack.peek()); //Prints 8
        stack.pop();
        System.out.println(stack.peek()); //Prints 7
        System.out.println(stack.size()); //Prints 2 

    }
}
