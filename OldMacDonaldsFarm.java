import java.util.ArrayList;

public class OldMacDonaldsFarm
{
    private String farmerName;
    private ArrayList<Animal> farmAnimals;

    public OldMacDonaldsFarm() 
    {
        farmerName = "Old MacDonald";
        farmAnimals = new ArrayList<Animal>( ); 
    }

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



    public static void main (String [ ] args) 
    {
        System.out.println("xxxxxx");
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