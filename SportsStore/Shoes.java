/**
 * Shoes is a class that has all the methods for the Shoes Merchandise.
 * 
 * @author Rishik Sehgal
 * @version Dec 12, 2025
 *
 */ 
public class Shoes implements Merchandise 
{
    
    private double price;
    private String[] itemNames;
    
    /**
     * Creates a Shoes Object initializing its price to be 129.99 and giving it itemNames.
     */
    public Shoes() 
    {
        price = 129.99;
        itemNames = new String[] {"Freshman", "Gary", "Mason", "WhiteCrocs"};
    }
    
    /**
     * Returns the price of SHOES
     * @return the price of Shoes
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
        return "SHOES";
    }
}