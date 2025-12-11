/**
 * Ball class - standardized price of 67 and stock of 5
 */
public class Ball extends Merchandise
{
    /**
     * Constructor for objects of class Ball
     */
    public Ball(String n)
    {
        super(n);
    }

    /**
     * Returns standardized price of 67
     */
    @Override
    public int getCost()
    {
        return 67;
    }
    
    /**
     * Returns standardized stock of 5
     */
    @Override
    public int getStock()
    {
        return 5;
    }
}