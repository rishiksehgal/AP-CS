public class Balls implements Merchandise 
{
    
    private double price;
    private String[] itemNames;
    
    public Balls() 
    {
        price = 70.00;
        itemNames = new String[] {"Basketball","Hockey Ball","Volleyball","Waterpolo Ball"};
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
        return "BALLS";
    }
}