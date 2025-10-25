import java.util.Stack;
/**
 * Adds some methods for a String
 * @author Rishik Sehgal
 * No assistance
 * 
 * @version Oct 17, 2025
 */
public class StringUtil
{

    /**
     * Reverses the String given to it using Stacks
     * @param str the string to be reversed
     * @return the reversed string
     */
    public static String reverseString(String str)
    {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) 
        {
            stack.push(str.substring(i, i + 1));
        }
        String x = "";
        while (!stack.isEmpty()) 
        {
            x += stack.pop();
        }
        return x;
    }

    /**
     * Determines if the String given is a palindrome
     * @param str is the String being analyzed
     * @return true if it is a palindrome
     */
    public static boolean isPalindrome(String str)
    {
        return str.equals(reverseString(str));
    }

    /**
     * A tester method for the StringUtil class
     * @param args random thingy
     */
    public static void main(String[] args)
    {
        String test =  "racecar";
        String test2 = "notapalindrome";

        if ( !("".equalsIgnoreCase(reverseString(""))) )
        {
            System.out.println("An empty string is palindrome");
        }

        if ( !("a".equalsIgnoreCase(reverseString("a"))) )
        {
            System.out.println("\"a\" is a palindrome");
        }

        if ( !("aa".equalsIgnoreCase(reverseString("aa"))) )
        {
            System.out.println("Error: \"aa\" is a palindrome");
        }

        if (!test.equalsIgnoreCase(reverseString(test)))
        {
            System.out.println("Error: " + test + " is a palindrome");
        }
        else
        {
            System.out.println("Success " + test + " matched " + reverseString(test));
        }

        if (test2.equalsIgnoreCase(reverseString(test2)))
        {
            System.out.println("Error: " + test2 + " is a palindrome");
        }
    }
}
