import java.util.ArrayList;

/**
 * Sentence holds a bunch of Phrases.
 * ArrayList used because unknown size at runtime and O(1) time complexity for .get().
 * @author Rishik Sehgal
 * @version February 20
 */
public class Sentence 
{
    private ArrayList<Phrase> phrases;

    /**
     * Initializes the arraylist that contains the phrases.
     */
    public Sentence() 
    {
        phrases = new ArrayList<Phrase>();
    }

    /**
     * Adds a phrase
     * @param x is the phrase that will be added
     */
    public void addPhrase(Phrase x) 
    {
        phrases.add(x);
    }

    /**
     * Returns a copy of the phrases arraylist
     * @return a copy of the phrases list
     */
    public ArrayList<Phrase> getList() 
    {
        ArrayList<Phrase> x = new ArrayList<Phrase>();
        for (int i = 0; i < phrases.size(); i++) 
        {
            x.add(phrases.get(i));
        }
        return x;
    }

    /**
     * provides a String representation of the Sentence
     * @return a String representation
     */
    public String toString() 
    {
        String rep = "";
        for (int i = 0; i < phrases.size(); i++) 
        {
            rep = rep + phrases.get(i).toString();
        }
        return rep;
    }
}
