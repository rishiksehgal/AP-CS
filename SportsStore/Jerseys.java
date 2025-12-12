/**
 * Jerseys is a class that has all the methods for the Jerseys Merchandise.
 * 
 * @author Rishik Sehgal
 * @version Dec 12, 2025
 *
 */ 
public class Jerseys implements Merchandise 
{
    
    private double price;
    private String[] itemNames;
    
    /**
     * Creates a Jerseys Object initializing its price to be 89.99 and giving it itemNames.
     */
    public Jerseys() 
    {
        price = 89.99;
        itemNames = new String[] {"Curry", "Lebron", "Zaza", "YaoMing"};
    }

    /**
     * Returns the price of JERSEYS
     * @return the price of Jerseys
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
        return "JERSEYS";
    }
}
