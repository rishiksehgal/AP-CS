import java.util.*;
public class LibraryCatalog 
{
    private LinkedList<Book>[] catalog = new LinkedList[10];

    public LibraryCatalog()
    {
        for(int i = 0; i < catalog.length; i ++)
        {
            catalog[i] = new LinkedList<Book>();
        }
    }
    public void addBook(Book b)
    {
        catalog[hash(b)].add(b);
    }

    public boolean hasBook(Book b)
    {
        return (catalog[hash(b)].contains(b));
    }

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

    public int hash(Book b)
    {
        return b.getId() % catalog.length;
    }
    
    
}
