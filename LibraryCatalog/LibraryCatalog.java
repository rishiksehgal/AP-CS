import java.util.*;
/**
 * LibraryCatalog represents a library.
 * 
 * @author Rishik Sehgal
 * @version Jan 9, 2026
 *
 */ 
public class LibraryCatalog 
{
    private LinkedList<Book>[] catalog = new LinkedList[10];

    /**
     * Creates a LibraryCatalog object
     */
    public LibraryCatalog()
    {
        for(int i = 0; i < catalog.length; i ++)
        {
            catalog[i] = new LinkedList<Book>();
        }
    }
    
    /**
     * Adds a book to the Catalog.
     * @param b is the book being added.
     */
    public void addBook(Book b)
    {
        catalog[hash(b)].add(b);
    }

    /**
     * Determines if the catalog has a certain book
     * @param b book being analyzed
     * @return true if in catalog
     */
    public boolean hasBook(Book b)
    {
        return (catalog[hash(b)].contains(b));
    }

    /**
     * Displays the catalog
     */
    public void display()
    {
        for(int i = 0; i < catalog.length; i++)
        {
            System.out.println();
            System.out.print("Shelf " + i);
            int j = 0;
            while(j < catalog[i].size())
            {
                System.out.print("  [ " + catalog[i].get(j) + " ]");
                j++;
            }
        }
    }

    /**
     * Returns the hashcode corresponding to the book
     * @param b book thing
     * @return the hashcode corresponding to it
     */
    public int hash(Book b)
    {
        return b.getId() % catalog.length;
    }
    
    
}
