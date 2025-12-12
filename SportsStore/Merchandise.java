/**
 * Interface with methods for the merchandise.
 * 
 * @author Rishik Sehgal
 * @version Dec 12, 2025
 *
 */ 
interface Merchandise 
{
    /**
     * Returns the price of the Merchandise
     * @return the price of the merchandise
     */
    double getPrice();

    /**
     * Returns the itemNames for the respective merchandise
     * @return the itemNames for the respective merchandise
     */
    String[] getItemNames();

    /**
     * Returns the name of the merchandise
     * @return the name of the merchadise
     */
    String returnName();
}