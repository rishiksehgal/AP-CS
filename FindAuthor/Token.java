/**
 * Token class that has different token types.
 * 
 * @author Rishik Sehgal
 * @version February 20
 */
public class Token 
{
    private final Scanner.TOKEN_TYPE type;
    private final String value;

    /**
     * Creates a token with specified type and value
     * @param t is token type
     * @param v is value
     */
    public Token(Scanner.TOKEN_TYPE t, String v)
    {
        type = t;
        value = v;
    }

    /**
     * Returns the type
     * @return type
     */
    public Scanner.TOKEN_TYPE getType()
    {
        return type;
    }

    /**
     * Returns the value
     * @return value
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Returns type and value
     * @return type and value
     */
    public String toString()
    {
        return "Type: " + type + ", Value: " + value;
    }

    /**
     * Compares two tokens
     * @return true if they are the same
     */
    public boolean equals(Object obj)
    {
        if(obj instanceof Token)
        {
            Token x = (Token) obj;
            return value.equals(x.getValue()) && type == x.getType(); 
        }
        return false;
    }
}
