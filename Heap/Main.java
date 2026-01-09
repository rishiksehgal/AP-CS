/**
 * Main method that creates a Heap and tests HeapUtils methods
 * 
 * @author Rishik Sehgal
 * @version Nov 31, 2025
 *
 */ 
public class Main 
{
    /**
     * Main method to test
     * @param args random thingy
     */
    public static void main(String[] args) 
    {
        Integer[] intObjects = new Integer[13];
        for(int i = 1; i < 12; i++)
        {
            intObjects[i] = (int) (101* Math.random());
        }
        HeapDisplay h = new HeapDisplay();
        h.displayHeap(intObjects, 11);
        //
        HeapUtils x = new HeapUtils(11);
        x.buildHeap(intObjects);
        HeapDisplay a = new HeapDisplay();
        a.displayHeap(intObjects, 11);
        //
        x.remove(intObjects);
        HeapDisplay b = new HeapDisplay();
        b.displayHeap(intObjects, 10);
        //
        
    }
}
