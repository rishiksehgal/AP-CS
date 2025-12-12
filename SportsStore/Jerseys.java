public class Jerseys implements Merchandise 
{
    
    private double price;
    private int limit;
    private String[] itemNames;
    
    public Jerseys() 
    {
        price = 89.99;
        limit = 50;
        itemNames = new String[] {"Curry", "Lebron", "Zaza", "YaoMing"};
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