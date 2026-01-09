import java.util.Stack;

/**
 * Expressions gives more methods for Stack.
 * 
 * @author Rishik Sehgal
 * No assistance
 * 
 * @version Oct 17, 2025
 */
public class Expressions
{

    /**
     * parenthesis matching : An expression is said to be balanced if
     * every opener has a corresponding closer, in the right order.
     * {, [ or ( are the only types of brackets allowed.
     * 
     * @param expression containing operands, operators, 
     *         and any of the 3 supported brackets
     * @return true if the parenthesis are balanced, false otherwise
     */
    public static boolean matchParenthesis(String expression)
    {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < expression.length(); i++)
        {
            String current = expression.substring(i, i + 1);
            if (current.equals("(") || current.equals("[") || current.equals("{"))
            {
                stack.push(current);
            }
            else if (current.equals(")") || current.equals("]") || current.equals("}"))
            {
                if (stack.isEmpty())
                {
                    return false;
                } 
                String head = stack.pop();
                if ((current.equals(")") && !head.equals("("))
                        || (current.equals("]") && !head.equals("["))
                        || (current.equals("}") && !head.equals("{")))
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Returns a string in postfix form if given an expression in infix form as a parameter.
     * Does this conversion using a Stack.
     * 
     * @param expr valid expression in infix form
     * @return equivalent expression in postfix form
     */
    public static String infixToPostfix(String expr)
    {
        Stack<String> stack = new Stack<String>();
        String output = "";
        int i = 0;

        while (i < expr.length())
        {
            String x = expr.substring(i, i + 1);
            if (x.equals(" "))
            {
                i++;
            }
            else if (x.compareTo("0") >= 0 && x.compareTo("9") <= 0)
            {
                String y = "";
                while (i < expr.length() && (expr.substring(i, i+1).compareTo("0") >= 0 
                        && expr.substring(i, i+1).compareTo("9") <= 0))
                {
                    y += expr.substring(i, i+1);
                    i++;
                }
                output += y + " ";
            }
            else if (x.equals("("))
            {
                stack.push(x + "");
                i++;
            }
            else if (x.equals(")"))
            {
                while (!stack.isEmpty() && !stack.peek().equals("("))
                {
                    output += stack.pop() + " ";
                }
                if (!stack.isEmpty())
                {
                    stack.pop();
                }
                i++;
            }
            else
            {
                int p = 0;
                if (x .equals("+") || x.equals("-"))
                {
                    p = 1;
                }
                if (x.equals("*")|| x .equals("/") || x.equals("%"))
                {
                    p = 2;
                }
                boolean done = false;
                while (!stack.isEmpty() && !done)
                {
                    String top = stack.peek();
                    int tp = 0;
                    String t = top.substring(0,1);
                    if (t.equals("+") || t.equals("-"))
                    {
                        tp = 1;
                    }   
                    if (t.equals("*") || t.equals("/") || t.equals("%"))
                    {
                        tp = 2;
                    }
                    if (tp >= p)
                    {
                        output += stack.pop() + " ";
                    }
                    else
                    {
                        done = true;
                    }
                }
                stack.push(x + "");
                i++;
            }
        }

        while (!stack.isEmpty())
        {
            output += stack.pop() + " ";
        }

        return output;
    }

    /**
     * Returns the value of an expression in postfix form.
     * Does this computation using a Stack.
     * 
     * @param expr valid expression in postfix form
     * @return value of the expression
     * @precondition postfix expression contains numbers and operators + - * / and %,
     * and that operands and operators are separated by spaces
     */
    public static double evalPostfix(String expr)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;

        while (i < expr.length())
        {
            while (i < expr.length() && expr.substring(i, i + 1).equals(" "))
            {
                i++;
            }
            if (i >= expr.length())
            {
                return stack.pop();
            }

            int start = i;
            while (i < expr.length() && !expr.substring(i, i + 1).equals(" "))
            {
                i++;
            }

            String temp = expr.substring(start, i);

            if (temp.equals("+") || temp.equals("-") || temp.equals("*")
                    || temp.equals("/") || temp.equals("%"))
            {
                int second = stack.pop();
                int first = stack.pop();
                int result = 0;

                if (temp.equals("+"))
                {
                    result = first + second;
                }
                else if (temp.equals("-"))
                {
                    result = first - second;
                }
                else if (temp.equals("*"))
                {
                    result = first * second;
                }
                else if (temp.equals("/"))
                {
                    result = first / second;
                }
                else if (temp.equals("%"))
                {
                    result = first % second;
                }
                stack.push(result);
            }
            else
            {
                stack.push(Integer.parseInt(temp));
            }
        }
        return stack.pop();
    }

    /**
     * Tester for the methods.
     * 
     * @param args random thingy
     */
    public static void main(String[] args)
    {
        String exp = "2 + 3 * 4";
        test(exp, 14);

        exp = "8 * 12 / 2";
        test(exp, 48);

        exp = "5 % 2 + 3 * 2 - 4 / 2";
        test(exp, 5);

        // test balanced expressions
        testBalanced("{ 2 + 3 } * ( 4 + 3 )", true);
        testBalanced("} 4 + 4 { * ( 4 + 3 )", false);
        testBalanced("[ [ [ ] ]", false);
        testBalanced("{ ( } )", false);
        testBalanced("( ( ( ) ) )", true);
    }

    /**
     * Tests infixToPostfix and evalPostfix methods.
     * 
     * @param expr   expression to be tested
     * @param expect expected value
     */
    public static void test(String expr, double expect)
    {
        String post = infixToPostfix(expr);
        double val = evalPostfix(post);

        System.out.println("Infix: " + expr);
        System.out.println("Postfix: " + post);
        System.out.println("Value: " + val);
        if (val == expect)
        {
            System.out.println("** Success! Great Job **");
        }
        else
        {
            System.out.println("** Oops! Something went wrong. Check your postfix and eval methods **");
        }
    }

    /**
     * Tests the matchParenthesis method.
     * 
     * @param ex       expression to check
     * @param expected expected boolean result
     */
    public static void testBalanced(String ex, boolean expected)
    {
        boolean act = matchParenthesis(ex);
        if (act == expected)
        {
            System.out.println("** Success!: matchParenthesis(" + ex + ") returned " + 
                act);
        }
        else
        {
            System.out.println("** Oops! Something went wrong check : matchParen(" + ex + ") returned "
                    + act + " but should have returned " + expected);
        }
    }
}
