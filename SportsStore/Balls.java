/**
 * Balls is a class that has all the methods for the Balls Merchandise.
 * 
 * @author Rishik Sehgal
 * @version Dec 12, 2025
 *
 */ 
public class Balls implements Merchandise 
{
    
    private double price;
    private String[] itemNames;
    
    /**
     * Creates a Balls Object initializing its price to be 70.00 and giving it itemNames.
     */
    public Balls() 
    {
        price = 70.00;
        itemNames = new String[] {"Basketball", "Hockey Ball", "Volleyball", "Waterpolo Ball"};
    }
    
    /**
     * Returns the price of BALLS
     * @return the price of Balls
     */
    @Override
    public double getPrice() 
    { 
        return price; 
    }

    /**
     * Returns the item names.
     * @return the ItemNames
     */
    @Override
    public String[] getItemNames() 
    { 
        return itemNames; 
    }

    /**
     * Returns the name of the class in caps.
     * @return the name of the class
     */
    @Override
    public String returnName()
    {
        return "BALLS";
    }
}
