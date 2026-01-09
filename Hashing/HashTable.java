/**
 * HashTable Class for Hashing.
 * 
 * @author Rishik Sehgal
 * @version Jan 9, 2026
 *
 */ 
public class HashTable 
{
    private Integer[] arr = new Integer[10];

    /**
     * Creates a HashTable Object and initializes each element to -1.
     */
    public HashTable()
    {
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = -1;
        }
    }


    /**
     * Inserts an element into the HashTable.
     * @param key element to be inserted
     */
    public void insert(int key)
    {
        int x = hash(key);
        int temp = x;
        while(arr[x] != -1)
        {
            x = (x+1) % arr.length;
            if(x == temp)
            {
                throw new RuntimeException("no space");
            }
        }

        arr[x] = key;
    }

    /**
     * Returns the hash code associated with the integer
     * @param key integer
     * @return hashcode
     */
    public int hash(int key)
    {
        return (key % arr.length);
    }

    /**
     * Searches for the key in the table
     * @param key being searched for
     * @return true if in the table
     */
    public boolean search(int key)
    {
        int x = hash(key);
        int temp = x;
        if(arr[x] == key)
        {
            return true;
        }
        x = ((x+1) % arr.length);
        while(x!= temp)
        {
            if(arr[x] == key)
            {
                return true;
            }
        }
        return false;   
    }

    /**
     * Prints the array 
     */
    public void display()
    {
        for(int i = 0; i < arr.length;i++)
        {
            System.out.println("Index: " + i + " " + arr[i]);
        }
    }


}
