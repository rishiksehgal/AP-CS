public class SportsStore 
{
    
    private String storeName;
    private Merchandise[] items;
    
    public SportsStore(String name) 
    {
        storeName = name;
        items = new Merchandise[3];
        items[0] = new Jerseys();
        items[1] = new Shoes();
        items[2] = new Balls();
    }
    
    public String getStoreName() 
    { 
        return storeName; 
    }
    
    public Merchandise getMerchandiseByType(String type) 
    {
        if (type.toLowerCase().equals("jerseys")) 
            return items[0];
        if (type.toLowerCase().equals("shoes")) 
            return items[1];
        if (type.toLowerCase().equals("balls")) 
            return items[2];
        return null;
    }
}