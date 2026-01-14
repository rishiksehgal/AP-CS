/**
 * Book has information of a book.
 * 
 * @author Rishik Sehgal
 * @version Jan 9, 2026
 *
 */ 
public class Book 
{
    private String title;
    private int id;
    /**
     * Creates a Book object
     * @param t is the title parameter
     * @param i is the id parameter
     */
    public Book(String t, int i)
    {
        title = t;
        id = i;
    }

    /**
     * Determines if this Book is equal to another object
     * @param b is the object being compared to
     * @return true if the same
     */
    @Override
    public boolean equals (Object b)
    {
        if(b instanceof Book)
        {
            Book x = (Book) b;
            return this.id == x.id;
        }
        return false;
    }

    /**
     * Returns the String thing for the Book
     * @return the string thing for this book
     */
    @Override
    public String toString()
    {
        return ("Title: " + title + " Id: " + id);
    }

    /**
     * Returns the id
     * @return the id
     */
    public int getId()
    {
        return id;
    }
}
