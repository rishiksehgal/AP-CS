import java.util.ArrayList;
/**
 * Contains a group of Token Objects.
 * ArrayList used because unknown size at runtime and O(1) time complexity for .get().
 * @author RIshik Sehgal
 * @version Feb 20
 */
public class Phrase 
{
    private ArrayList<Token> tokens;
    /**
     * Creates the tokens ArrayList
     */
    public Phrase()
    {
        tokens = new ArrayList<Token>();
    }

    /**
     * Adds a Token
     * @param t token to be added
     */
    public void addToken(Token t)
    {
        tokens.add(t);
    }

    /**
     * Returns a copy of the phrases list
     * @return copy
     */
    public ArrayList<Token> getList()
    {
        ArrayList<Token> copy = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++)
        {
            copy.add(tokens.get(i));
        }
        return copy;
    }

    /**
     * Gives String rep of this phrase
     * @return string rep
     */
    public String toString()
    {
        String x = "";
        for (int i = 0; i<tokens.size(); i++)
        {
            x = x + tokens.get(i).getValue() + " ";
        }
        return x;
    }
}
