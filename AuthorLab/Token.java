/**
 * Token class that identifies different token types like a word, end of sentence, a digit, etc. and stores their value
 * 
 * @author Zavier Chen
 * @version 2/20/2026
 */
public class Token {
    private final Scanner.TOKEN_TYPE type;
    private final String value;

    /**
     * Constructs a token with a specified token type as well as a String value
     * @param type the token type of the token
     * @param value the value the token will hold
     */
    public Token(Scanner.TOKEN_TYPE type, String value)
    {
        this.type = type;
        this.value = value;
    }

    /**
     * Returns the type of the token
     * @return the type of the token
     */
    public Scanner.TOKEN_TYPE getType()
    {
        return type;
    }

    /**
     * Returns the value of the token
     * @return the value of the token
     */
    public String getValue()
    {
        return value;
    }

    /**
     * toString method which will print both the type and value of the token
     */
    public String toString()
    {
        return "Token type: " + type + "; Value: " + value;
    }

    /**
     * Equals method that compares two tokens using their type and value
     */
    public boolean equals(Object obj)
    {
        Token other = (Token) obj;
        return type == other.getType() && value.equals(other.getValue());
    }
}
