public class SportsStore 
{
    
    private String name;
    private Merchandise[] items;
    private double wallet;
    
    public SportsStore(String n, Double w) 
    {
        name = n;
        items = new Merchandise[3];
        items[0] = new Jerseys();
        items[1] = new Shoes();
        items[2] = new Balls();
        wallet = w;
    }
    
    public String getStoreName() 
    { 
        return name;
    }

    public Double getWalletBalance()
    {
        return wallet;
    }
    
    public void setWalletBalance(Double w)
    {
        wallet = w;
    }

    public Merchandise determineType(String type) 
    {
        if (type.toLowerCase().equals("jerseys")) 
            return items[0];
        if (type.toLowerCase().equals("shoes")) 
            return items[1];
        if (type.toLowerCase().equals("balls")) 
            return items[2];
        return null;
    }
    
    public void goToItem(Merchandise merchandise) 
    {
        System.out.println();
        System.out.println(merchandise.returnName());
        System.out.println();
        for (int i = 0; i < merchandise.getItemNames().length; i++) 
            System.out.println((i+ 1) + "  " + merchandise.getItemNames()[i] + "  $" + merchandise.getPrice());
        System.out.println();
    }
}