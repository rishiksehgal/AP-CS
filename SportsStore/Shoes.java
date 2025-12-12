public class Shoes implements Merchandise 
{
    
    private double price;
    private String[] itemNames;
    
    public Shoes() 
    {
        price = 129.99;
        itemNames = new String[] {"Freshman","Gary","Mason","WhiteCrocs"};
    }
    
    @Override
    public double getPrice() 
    { 
        return price; 
    }

    @Override
    public String[] getItemNames() 
    { 
        return itemNames; 
    }

    @Override
    public String returnName()
    {
        return "SHOES";
    }
}