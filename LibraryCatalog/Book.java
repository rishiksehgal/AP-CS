public class Book 
{
    private String title;
    private int id;
    public Book(String t, int i)
    {
        title = t;
        id = i;
    }

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

    @Override
    public String toString()
    {
        return ("Title: " + title + " Id: " + id);
    }

    public int getId()
    {
        return id;
    }
}
