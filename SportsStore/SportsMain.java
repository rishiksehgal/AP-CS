/**
 * Runs the Sports Store program
 * 
 * @author Rishik Sehgal
 * @version Dec 12, 2025
 *
 */ 
public class SportsMain 
{
    /**
     * Main method for Sports Store.
     * @param args argument
     */
    public static void main(String[] args) 
    {
        SportsStore store = new SportsStore("Nikidas", 500.00);
        SportsInteraction interaction = new SportsInteraction(store);
        interaction.start();
    }
}