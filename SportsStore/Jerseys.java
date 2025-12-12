public class Jerseys implements Merchandise 
{
    
    private double price;
    private String[] itemNames;
    
    public Jerseys() 
    {
        price = 89.99;
        itemNames = new String[] {"Curry","Lebron","Zaza","YaoMing"};
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
        return "JERSEYS";
    }
}