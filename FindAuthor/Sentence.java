import java.util.ArrayList;

/**
 * Sentence class that bundles a sequence of Phrase objects.
 * ArrayList is used for strong traversal powers
 * 
 * @author Zavier Chen
 * @version 2/20/2026
 */
public class Sentence {
    private ArrayList<Phrase> phrases;

    /**
     * Creates an arraylist of phrase objects that will be used to create a sentence
     */
    public Sentence() {
        phrases = new ArrayList<Phrase>();
    }

    /**
     * Adds a phrase to the arraylist
     * @param p the phrase to be added
     */
    public void addPhrase(Phrase p) {
        phrases.add(p);
    }

    /**
     * Returns the entire arraylist but a shallow copy of it
     * @return a copy of the phrases list
     */
    public ArrayList<Phrase> getList() {
        ArrayList<Phrase> a = new ArrayList<Phrase>();
        for (int i = 0; i < phrases.size(); i++) {
            a.add(phrases.get(i));
        }
        return a;
    }

    /**
     * toString method that prints out all of the phrases in the list in a string
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < phrases.size(); i++) {
            s = s + phrases.get(i).toString();
        }
        return s;
    }
}
