public class Balls implements Merchandise 
{
    
    private double price;
    private int limit;
    private String[] itemNames;
    
    public Balls() 
    {
        price = 70.00;
        limit = 5;
        itemNames = new String[] {"Basketball", "Hockey Ball", "Volleyball", "Waterpolo Ball"};
    }
    
    @Override
    public double getPrice() 
    { 
        return price; 
    }
    
    @Override
    public int getLimit() 
    { 
        return limit; 
    }
    
    @Override
    public String[] getItemNames() 
    { 
        return itemNames; 
    }
    
    @Override
    public void reduceLimit(int amount) 
    { 
        limit = limit - amount; 
    }
}