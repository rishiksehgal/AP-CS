public class SportsStore
{
    private String name;
    private Merchandise[] bag;
    private int[] count;
    private Merchandise[] jerseys;
    private Merchandise[] shoes;
    private Merchandise[] balls;

    /**
     * Constructor for objects of class SportsStore
     */
    public SportsStore(String n)
    {
        name = n;
        bag = new Merchandise[12];
        count = new int[12];
        jerseys = new Merchandise[4];
        shoes = new Merchandise[4];
        balls = new Merchandise[4];
        initializeInventory();
    }
    
    public SportsStore()
    {
        this("Nikidas");
    }
    
    /**
     * Initialize store inventory with items
     */
    private void initializeInventory()
    {
        // Initialize Jerseys (Price: 70, Stock: 1)
        // INSERT JERSEY 1 NAME
        jerseys[0] = new Jerseys("");
        // INSERT JERSEY 2 NAME
        jerseys[1] = new Jerseys("");
        // INSERT JERSEY 3 NAME
        jerseys[2] = new Jerseys("");
        // INSERT JERSEY 4 NAME
        jerseys[3] = new Jerseys("");
        
        // Initialize Shoes (Price: 100, Stock: 10)
        // INSERT SHOES 1 NAME
        shoes[0] = new Shoes("");
        // INSERT SHOES 2 NAME
        shoes[1] = new Shoes("");
        // INSERT SHOES 3 NAME
        shoes[2] = new Shoes("");
        // INSERT SHOES 4 NAME
        shoes[3] = new Shoes("");
        
        // Initialize Balls (Price: 67, Stock: 5)
        // INSERT BALL 1 NAME
        balls[0] = new Ball("");
        // INSERT BALL 2 NAME
        balls[1] = new Ball("");
        // INSERT BALL 3 NAME
        balls[2] = new Ball("");
        // INSERT BALL 4 NAME
        balls[3] = new Ball("");
    }
    
    /**
     * Returns the name of the store
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the array of jerseys
     */
    public Merchandise[] getJerseys()
    {
        return jerseys;
    }
    
    /**
     * Returns the array of shoes
     */
    public Merchandise[] getShoes()
    {
        return shoes;
    }
    
    /**
     * Returns the array of balls
     */
    public Merchandise[] getBalls()
    {
        return balls;
    }
    
    /**
     * Sets the jerseys array
     */
    public void setJerseys(Merchandise[] j)
    {
        jerseys = j;
    }
    
    /**
     * Sets the shoes array
     */
    public void setShoes(Merchandise[] s)
    {
        shoes = s;
    }
    
    /**
     * Sets the balls array
     */
    public void setBalls(Merchandise[] b)
    {
        balls = b;
    }
    
    /**
     * Adds an item to the shopping cart
     */
    public void addToCart(Merchandise item)
    {
        int i = 0;
        while (i < bag.length && bag[i] != null)
        {
            if (item == bag[i])
            {
                count[i]++;
                return;
            }
            i++;
        }
        bag[i] = item;
        count[i]++;
    }
    
    /**
     * Returns the shopping cart array
     */
    public Merchandise[] shoppingCart()
    {
        return bag;
    }
}