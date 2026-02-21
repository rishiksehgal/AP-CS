import java.util.ArrayList;
/**
 * Phrase class that bundles up a group of tokens into a phrase. 
 * ArrayList is used because it is easy to access and traverse the data in the list
 */
public class Phrase {
    private ArrayList<Token> a;
    public Phrase()
    {
        a = new ArrayList<Token>();
    }

    public void addToken(Token tk)
    {
        a.add(tk);
    }

    public ArrayList<Token> getList()
    {
        ArrayList<Token> b = new ArrayList<>();
        for (int i=0; i<a.size(); i++)
        {
            b.add(a.get(i));
        }

        return b;
    }

    public String toString()
    {
        String s = "";
        for (int i=0; i<a.size(); i++)
        {
            s = s + a.get(i).getValue() + " ";
        }

        return s;
    }
}
