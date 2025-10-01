/**
 * A chicken animal on OldMacDonaldsFarm
 * 
 * @author Rishik Sehgal
 * No assistance
 * 
 * @version 1
 * 
 */
public class Chicken extends Animal
{

    /**
     * Calls the parameterized constructor with the common name of chicken
     */
    public Chicken()
    {
        this("chicken");
    }

    /**
     * Creates a Chicken object with the given common name
     * @param chickenType is the common name 
     */
    public Chicken(String chickenType)
    {
        super("Gallus Gallus Domesticus", chickenType);
    }
    
    /**
     * Returns the sound of the chicken
     * @return "bawk"
     */
    @Override
    public String speak()
    {
        return "bawk";
    }

    
}
