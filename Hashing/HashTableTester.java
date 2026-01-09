/**
 * HashTableTester for HashTable.
 * 
 * @author Rishik Sehgal
 * @version Jan 9, 2026
 *
 */ 
public class HashTableTester 
{
    /**
     * Main method
     * @param args thingy
     */
    public static void main(String[] args) 
    {
        HashTable table = new HashTable();
        table.insert(1);
        table.insert(11);
        table.insert(9);
        table.insert(19);
        System.out.println(table.search(9));
        table.display();
    }
}
