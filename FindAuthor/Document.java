import java.util.ArrayList;
/**
 * Scans and parses a document.
 * ArrayList used because unknown size at runtime and O(1) time complexity for .get().
 * @author Rishik Sehgal
 * @version 1
 */
public class Document 
{
    private ArrayList<Sentence> sentences;
    private Scanner scanner;
    private Token currentVal;

    /**
     * Creates a Document object and takes in a scanner, initializing the sentence list 
     * and current value to the next token.
     * @param s scanner used
     */
    public Document(Scanner s)
    {
        sentences = new ArrayList<Sentence>();
        scanner = s;
        currentVal = getNextToken();
    }

    /**
     * Returns the next token
     * @return the next token
     */
    private Token getNextToken() 
    {
        return scanner.nextToken();
    }

    /**
     * Eats a token, if incorrect throws exception.
     * @param x is token to be ate
     */
    private void eat(Token x) 
    {
        if (currentVal.equals(x)) 
        {
            currentVal = getNextToken();
        } 
        else 
        {
            throw new RuntimeException("Expected: " + x + "Found: " + currentVal);
        }
    }
    /**
     * Accepts Token objects of type WORD and adds them to the current Phrase
     * @return phrase update
     */
    public Phrase parsePhrase() 
    {
        Phrase x = new Phrase();
        while (currentVal.getType() == Scanner.TOKEN_TYPE.WORD) 
        {
            x.addToken(currentVal);
            eat(currentVal);
        }
        if (currentVal.getType() == Scanner.TOKEN_TYPE.END_OF_PHRASE) 
        {
            eat(currentVal);
        }
        return x;
    }
    /**
     * Parses individual phrases from the input stream until the end of a 
     * sentence is reached or the end of file is reached.
     * @return sentence object
     */
    public Sentence parseSentence() 
    {
        Sentence s = new Sentence();
        while (currentVal.getType() != Scanner.TOKEN_TYPE.END_OF_SENTENCE &&
               currentVal.getType() != Scanner.TOKEN_TYPE.END_OF_FILE) 
        {
            if (currentVal.getType() == Scanner.TOKEN_TYPE.WORD) 
            {
                Phrase phrase = parsePhrase();
                s.addPhrase(phrase);
            } 
            else 
            {
                eat(currentVal);
            }
        }
        if (currentVal.getType() == Scanner.TOKEN_TYPE.END_OF_SENTENCE) 
        {
            eat(currentVal);
        }
        return s;
    }

    /**
     * Parse sentences from the input stream until end of file is reached.
     */
    public void parseDocument() 
    {
        while (currentVal.getType() != Scanner.TOKEN_TYPE.WORD && 
        currentVal.getType() != Scanner.TOKEN_TYPE.END_OF_FILE) 
        {
            eat(currentVal);
        }
        while (currentVal.getType() != Scanner.TOKEN_TYPE.END_OF_FILE) 
        {
            Sentence s = parseSentence();
            sentences.add(s);
        }
    }
    /**
     * Getter for sentences
     * @return sentences
     */
    public ArrayList<Sentence> getSentences() 
    {
        return sentences;
    }
}
