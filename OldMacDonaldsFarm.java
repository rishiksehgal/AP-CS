import java.util.ArrayList;
/**
 * OldMacDonaldsFarm used to store all the Animals and sing song for all of them.
 * 
 * @author Rishik Sehgal
 * No assistance
 * 
 * @version Oct 2, 2025    
 * 
 */
public class OldMacDonaldsFarm
{
    private String farmerName;
    private ArrayList<Animal> farmAnimals;

    /**
     * Creates a OldMacDonaldsFarm Object and creates the farmerName and farmAnimals ArrayList.
     *
     */
    public OldMacDonaldsFarm() 
    {
        farmerName = "Old MacDonald";
        farmAnimals = new ArrayList<Animal>( ); 
    }

    /**
     * Sings the verse of all animals
     */
    public void singVerse() 
    {
        String phrase1 = farmerName + " had a farm,";
        String ei = " E-I-E-I-O.";
        int x = farmAnimals.size() - 1;
        Animal y = farmAnimals.get(x);
        System.out.println(phrase1 + ei + " and on his farm, he had some " + 
            y.getCommonName() + "s," + ei);

        for (int i = x; i >= 0; i--) 
        {
            Animal z = farmAnimals.get(i);
            System.out.println("With a " + z.speak() + "-" + z.speak()
                + " here, and a " + z.speak() + "-" + z.speak() + " there,");
            System.out.println("Here a " + z.speak() + ", there a "
                + z.speak() + ", everywhere a " + z.speak()
                + "-" + z.speak() + ",");
        }
        System.out.println(phrase1 + ei);
        System.out.println();
        System.out.println();
    }


    /**
     * Runs the farm 
     * @param args some fancy thing
     */
    public static void main (String [ ] args) 
    {
        OldMacDonaldsFarm singer = new OldMacDonaldsFarm( ); 
        singer.farmAnimals.add(new Chicken( ));
        singer.singVerse( );
        singer.farmAnimals.add(new Chick());
        singer.singVerse( ); 
        singer.farmAnimals.add(new Rooster( )); 
        singer.singVerse( ); 
        singer.farmAnimals.add(new Pig( )); 
        singer.singVerse( );
    }

}