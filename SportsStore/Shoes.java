/**
 * Shoes class - standardized price of 100 and stock of 10
 */
public class Shoes extends Merchandise
{
    /**
     * Constructor for objects of class Shoes
     */
    public Shoes(String n)
    {
        super(n);
    }

    /**
     * Returns standardized price of 100
     */
    @Override
    public int getCost()
    {
        return 100;
    }
    
    /**
     * Returns standardized stock of 10
     */
    @Override
    public int getStock()
    {
        return 10;
    }
}