/**
 * Main method that creates a Heap
 * 
 * @author Rishik Sehgal
 * @version 1
 *
 */ 
public class Main 
{
    public static void main(String[] args) 
    {
        Integer[] intObjects = new Integer[12];
        for(int i = 1; i < intObjects.length; i++)
        {
            intObjects[i] = (int) (101* Math.random());
        }
        HeapDisplay h = new HeapDisplay();
        h.displayHeap(intObjects,11);
        HeapUtils x = new HeapUtils(11);
        x.buildHeap(intObjects);
        h.displayHeap(intObjects, 11);
    }
}
