import java.util.ArrayList;

public class OldMacDonaldsFarm
{
    private String farmerName;
    private ArrayList farmAnimals;

    public OldMacDonaldsFarm() 
    {
        farmerName = "Old MacDonald";
        farmAnimals = new ArrayList<Animal>( ); 
    }

    public void singVerse()
    {
        String phrase1 = farmerName + " had a farm," ; 
        String ei = " E-I-E-I-O.";
    }



    public static void main (String [ ] args) 
    {
        OldMacDonaldsFarm singer = new OldMacDonaldsFarm( ); singer.farmAnimals.add(new Chicken( ));
        singer.singVerse( );
        singer.farmAnimals.add(new Chick());
        singer.singVerse( ); singer.farmAnimals.add(new Rooster( )); singer.singVerse( ); singer.farmAnimals.add(new Pig( )); singer.singVerse( );
    }

}