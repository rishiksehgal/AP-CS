/**
 * Abstract parent class for all animals.
 * 
 * @author Rishik Sehgal
 * No assistance
 * 
 * @version Oct 2, 2025
 * 
 */
public abstract class Animal implements Comparable<Animal>
{


    private String latinName;
    private String commonName;

    /**
     * Constructs an animal with the latinName and commonName provided
    * @param l is the latin name 
     * @param c is the common name
     */
    public Animal(String l, String c)
    {
        latinName = l;
        commonName = c;
    }

    /**
    * Returns the Latin name
    * @return the Latin name
    */
    public String getLatinName()
    {
        return latinName;
    }

    /**
    * Returns the common name
    * @return the common name
    */
    public String getCommonName()
    {
        return commonName;
    }

    /**
     * Sets the Latin name
    * @param s is the Latin name
    */
    public void setLatinName(String s)
    {
        latinName = s;
    }

    /**
     * Sets the Common Name
     * @param s is the common name
     */
    public void setCommonName(String s)
    {
        commonName = s;
    }

    /**
    * Abstract method for each animal to define its sound
    * @return the sound of the animal
     */
    public abstract String speak();

    /**
    * Compares the common name of animals
    * @param a is the animal being compared with 
    * @return negative value if before, positive value if after and 0 if the same
    */
    @Override
    public int compareTo(Animal a )
    {
        return a.getCommonName().compareTo(this.getCommonName());
    }

}