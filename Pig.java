/**
 * A pig animal on OldMacDonaldsFarm
 * 
 * @author Rishik Sehgal
 * No assistance
 * 
 * @version Oct 2, 2025
 * 
 */
public class Pig extends Animal
{
    /** 
     * Creates a Pig Object by calling the parameterized constructor
     */
    public Pig()
    {
        this("pig");
    }

    /**
     * Creates a Pig with the given common name
     * @param pigType is the common name
     */
    public Pig(String pigType)
    {
        super("Sus Crofa Domesticus", pigType);
    }

    /**
     * Makes the noise of a Pig
     * @return oink
     */
    public String speak()
    {
        return "oink";
    }
}
