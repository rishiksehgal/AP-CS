public class SportsMain 
{
    public static void main(String[] args) 
    {
        SportsStore Nikidas = new SportsStore("Nikidas");
        SportsInteraction interaction = new SportsInteraction(Nikidas);
        interaction.start();
    }
}