/**
 * Jerseys class - standardized price of 70 and stock of 1
 */
public class Jerseys extends Merchandise
{
    /**
     * Constructor for objects of class Jerseys
     */
    public Jerseys(String n)
    {
        super(n);
    }

    /**
     * Returns standardized price of 70
     */
    @Override
    public int getCost()
    {
        return 70;
    }
    
    /**
     * Returns standardized stock of 1
     */
    @Override
    public int getStock()
    {
        return 1;
    }
}