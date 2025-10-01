/**
 * A pig animal on OldMacDonaldsFarm
 * 
 * @author Rishik Sehgal
 * No assistance
 * 
 * @version 1
 * 
 */
public class Pig extends Animal
{
    public Pig()
    {
        this("pig");
    }

    public Pig(String pigType)
    {
        super("Sus Crofa Domesticus", pigType);
    }

    public String speak()
    {
         return "oink";
    }
}
