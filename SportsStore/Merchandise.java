public abstract class Merchandise
{
    private String name;

    /**
     * Constructor for objects of class Merchandise
     */
    public Merchandise(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }
    
    /**
     * Abstract method - must be implemented by subclasses
     */
    public abstract int getCost();
    
    /**
     * Abstract method - must be implemented by subclasses
     */
    public abstract int getStock();
    
    public void setName(String n)
    {
        name = n;
    }
    
    public String getInfo()
    {
        return "";
    }
}