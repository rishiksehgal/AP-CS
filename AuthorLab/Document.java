import java.util.ArrayList;
/**
 * Document class parses an entire input stream into Sentence objects using a scanner
 */
public class Document 
{
    private ArrayList<Sentence> a;
    private Token currentVal;
    private Scanner scanner;

    /**
     * Constructs a document with a Scanner and initizliaes the sentence list and gets the first token
     * @param scanner The scanner that provides token for parsing
     */
    public Document(Scanner scanner)
    {
        a = new ArrayList<Sentence>();
        this.scanner = scanner;
        currentVal = getNextToken();
    }

    /**
     * Gets the next token 
     * @return
     */
    private Token getNextToken() 
    {
        return scanner.nextToken();
    }

    private void eat(Token expected) {
        if (currentVal.equals(expected)) 
        {
            currentVal = getNextToken();
        } 
        else 
        {
            throw new RuntimeException(
                "Runtime error: expected " + expected + " but found " + currentVal);
        }
    }

    public Phrase parsePhrase() {
        Phrase phrase = new Phrase();

        while (currentVal.getType() == Scanner.TOKEN_TYPE.WORD) 
        {
            phrase.addToken(currentVal);
            eat(currentVal);
        }

        if (currentVal.getType() == Scanner.TOKEN_TYPE.END_OF_PHRASE) 
        {
            eat(currentVal);
        }

        return phrase;
    }

    public Sentence parseSentence() 
    {
        Sentence sentence = new Sentence();

        while (currentVal.getType() != Scanner.TOKEN_TYPE.END_OF_SENTENCE &&
               currentVal.getType() != Scanner.TOKEN_TYPE.END_OF_FILE) 
        {
            if (currentVal.getType() == Scanner.TOKEN_TYPE.WORD) 
            {
                Phrase phrase = parsePhrase();
                sentence.addPhrase(phrase);
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

        return sentence;
    }

    public void parseDocument() 
    {
        while (currentVal.getType() != Scanner.TOKEN_TYPE.WORD && currentVal.getType() != Scanner.TOKEN_TYPE.END_OF_FILE) 
        {
            eat(currentVal);
        }

        while (currentVal.getType() != Scanner.TOKEN_TYPE.END_OF_FILE) 
        {
            Sentence sentence = parseSentence();
            a.add(sentence);
        }
    }

    public ArrayList<Sentence> getSentences() 
    {
        return a;
    }
}
