public class SportsMain 
{
    public static void main(String[] args) 
    {
        SportsStore Nikidas = new SportsStore("Nikidas", 499.99);
        SportsInteraction interaction = new SportsInteraction(Nikidas);
        interaction.start();
    }
}