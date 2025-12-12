/**
 * SportsStore is the class for the Store as a whole.
 * 
 * @author Rishik Sehgal
 * @version Dec 12, 2025
 *
 */ 
public class SportsStore 
{
    
    private String name;
    private Merchandise[] items;
    private double wallet;
    
    /**
     * Creates a SportsStore object initiallizing a Merchandise array.
     * @param n name of the Store
     * @param w wallet balance
     */
    public SportsStore(String n, Double w) 
    {
        name = n;
        items = new Merchandise[3];
        items[0] = new Jerseys();
        items[1] = new Shoes();
        items[2] = new Balls();
        wallet = w;
    }
    
    /**
     * Returns the name of the Store
     * @return the name of the Store
     */
    public String getStoreName() 
    { 
        return name;
    }

    /**
     * Returns the wallet balance
     * @return the wallet balance
     */
    public Double getWalletBalance()
    {
        return wallet;
    }
    
    /**
     * Sets the wallet balance
     * @param w wallet balance
     */
    public void setWalletBalance(Double w)
    {
        wallet = w;
    }

    /**
     * Determines if the string given fits within any of the three categories. 
     * @param type string to be analyzed
     * @return An object of the respective class
     */
    public Merchandise determineType(String type) 
    {
        if (type.toLowerCase().equals("jerseys")) 
        {
            return items[0];
        }
        if (type.toLowerCase().equals("shoes")) 
        {
            return items[1];
        }
        if (type.toLowerCase().equals("balls")) 
        {
            return items[2];
        }
        return null;
    }

    /**
     * Returns the Different types of the merchandise given to it.
     * @param merchandise merchandise being utilized
     */
    public void goToItem(Merchandise merchandise) 
    {
        System.out.println();
        System.out.println(merchandise.returnName());
        System.out.println();
        for (int i = 0; i < merchandise.getItemNames().length; i++) 
        {
            System.out.println((i+ 1) + "  " + merchandise.getItemNames()[i] + "  $" +
                merchandise.getPrice());
        }
        System.out.println();
    }
}