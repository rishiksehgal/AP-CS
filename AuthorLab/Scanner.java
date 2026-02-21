import java.io.IOException;
import java.io.Reader;

/**
 * A Scanner is responsible for reading an input stream, one character at a
 * time, and separating the input into tokens.  A token is defined as:
 *  1. A 'word' which is defined as a non-empty sequence of characters that 
 *     begins with an alpha character and then consists of alpha characters, 
 *     numbers, the single quote character "'", or the hyphen character "-". 
 *  2. An 'end-of-sentence' delimiter defined as any one of the characters 
 *     ".", "?", "!".
 *  3. An end-of-file token which is returned when the scanner is asked for a
 *     token and the input is at the end-of-file.
 *  4. A phrase separator which consists of one of the characters ",",":" or
 *     ";".
 *  5. A digit.
 *  6. Any other character not defined above.
 * @author Mr. Page
 *
 */

public class Scanner
{
    private Reader in;
    private String currentChar;
    private boolean endOfFile;
    // define symbolic constants for each type of token
    public static enum TOKEN_TYPE{WORD, END_OF_SENTENCE, END_OF_FILE, 
        END_OF_PHRASE, DIGIT, UNKNOWN};
    /**
     * Constructor for Scanner objects.  The Reader object should be one of
     *  1. A StringReader
     *  2. A BufferedReader wrapped around an InputStream
     *  3. A BufferedReader wrapped around a FileReader
     *  The instance field for the Reader is initialized to the input parameter,
     *  and the endOfFile indicator is set to false.  The currentChar field is
     *  initialized by the getNextChar method.
     * @param in is the reader object supplied by the program constructing
     *        this Scanner object.
     */
    public Scanner(Reader in)
    {
        this.in = in;
        endOfFile = false;
        getNextChar();
    }
    /**
     * The getNextChar method attempts to get the next character from the input
     * stream.  It sets the endOfFile flag true if the end of file is reached on
     * the input stream.  Otherwise, it reads the next character from the stream
     * and converts it to a Java String object.
     * postcondition: The input stream is advanced one character if it is not at
     * end of file and the currentChar instance field is set to the String 
     * representation of the character read from the input stream.  The flag
     * endOfFile is set true if the input stream is exhausted.
     */
    private void getNextChar()
    {
        try
        {
            int inp = in.read();
            if(inp == -1) 
                endOfFile = true;
            else 
                currentChar = "" + (char) inp;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void eat(String object)
    {
        if (currentChar.equals(object))
        {
                getNextChar();  
        }
        else
        {
            throw new IllegalArgumentException("Current character: " + currentChar + "; Your string: " + object);
        }
    }

    private boolean isLetter(String object)
    {
        return Character.isLetter(object.toCharArray()[0]);
    }

    private boolean isDigit(String object)
    {
        return Character.isDigit(object.toCharArray()[0]);
    }
    private boolean isSpecialCharacter(String object)
    {
        return object.equals("'") || object.equals("-");
    }

    private boolean isPhraseTerminator(String object)
    {
        return object.equals(",") || object.equals(":") || object.equals(";");
    }

    private boolean isSentenceTerminator(String object)
    {
        return object.equals(".") || object.equals("?") || object.equals("!");
    }

    private boolean isWhiteSpace(String object)
    {
        return Character.isWhitespace(object.toCharArray()[0]);
    }

    public boolean hasNextToken()
    {
        return !endOfFile;
    }

    public Token nextToken()
    {
        if (endOfFile)
        {
            return new Token(TOKEN_TYPE.END_OF_FILE, "");
        }

        String token = "";
        while (!endOfFile && currentChar != null && isWhiteSpace(currentChar))
        {
            getNextChar();
        }

        if (endOfFile)
        {
            return new Token(TOKEN_TYPE.END_OF_FILE, "");
        }

        if (isLetter(currentChar))
        {
            token += currentChar;
            getNextChar();

            while (!endOfFile && (isLetter(currentChar) || isDigit(currentChar) || isSpecialCharacter(currentChar)))
            {
                token += currentChar;
                getNextChar();
            }

            return new Token(TOKEN_TYPE.WORD, token.toLowerCase());
        }

        if (isSentenceTerminator(currentChar))
        {
            String value = currentChar;
            getNextChar();
            return new Token(TOKEN_TYPE.END_OF_SENTENCE, value);
        }

        if (isPhraseTerminator(currentChar))
        {
            String value = currentChar;
            getNextChar();
            return new Token(TOKEN_TYPE.END_OF_PHRASE, value);
        }

        if (isDigit(currentChar))
        {
            String value = currentChar;
            getNextChar();
            return new Token(TOKEN_TYPE.DIGIT, value);
        }
        String value = currentChar;
        getNextChar();
        return new Token(TOKEN_TYPE.UNKNOWN, value);
    }
}
