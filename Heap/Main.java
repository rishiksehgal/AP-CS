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
        Integer[] intObjects = new Integer[13];
        for(int i = 1; i < 12; i++)
        {
            intObjects[i] = (int) (101* Math.random());
        }
        HeapDisplay h = new HeapDisplay();
        h.displayHeap(intObjects,11);
        //
        HeapUtils x = new HeapUtils(11);
        x.buildHeap(intObjects);
        h.displayHeap(intObjects, 11);
        //
        //x.remove(intObjects);
        //h.displayHeap(intObjects, 10);
        //
        intObjects = (Integer []) x.insert(intObjects, 67);
        h.displayHeap(intObjects, 12);
    }
}
