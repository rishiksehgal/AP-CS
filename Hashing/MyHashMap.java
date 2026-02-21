import java.util.*;
/**
 * MyHashMap acts like a map.
 * 
 * @author  
 * @version 
 * @param <K>   the type of key
 * @param <V>   the type of value
 */
public class MyHashMap<K, V> implements Map<K, V>
{
    private static final int NUM_BUCKETS = 5;
    private LinkedList<MapEntry<K, V>>[] buckets;
    private int size;

    /**
     * Creates a MyHashMap Object
     */
    public MyHashMap()
    {
        buckets = new LinkedList[NUM_BUCKETS];
        for(int i = 0; i < NUM_BUCKETS; i++)
        {
            buckets[i] = new LinkedList<MapEntry<K, V>>();
        }

    }
    
    /**
     * Gives the Bucket Index
     * @param obj the object to find the bucket index for
     * @return the correct bucket index for that object
     */
    private int toBucketIndex(Object obj)
    {
        if(obj == null)
        {
            return 0;
        }
        return obj.hashCode() % NUM_BUCKETS;
    }

    /**
     * Returns the size
     * @return the size
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns true if its empty
     * @return true if it is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns true if it contains the key
     * @param key being searched for
     * @return true if contains key
     */
    @Override
    public boolean containsKey(Object key)
    {
        for(MapEntry<K, V> i: buckets[toBucketIndex(key)])
        {
            if(key == null && i.getKey() == null || key != null && key.equals(i.getKey()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if HashMap contains a value
     * @param value being analyzed
     * @return true if has value
     */
    public boolean containsValue(Object value)
    {
        for(LinkedList<MapEntry<K, V>> j : buckets)
        {
            for(MapEntry<K, V> i: j)
            {
                if(value == null && i.getValue() == null || 
                    value != null && value.equals(i.getValue()))
                {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Gets the Value corresponding to a key
     * @param key that is searched for
     * @return the value
     */
    public V get(Object key)
    {
        for(MapEntry<K, V> i: buckets[toBucketIndex(key)])
        {
            if(key == null && i.getKey() == null || key != null && key.equals(i.getKey()))
            {
                return i.getValue();
            }
        }
        return null;



    }

    /**
     * Puts a key with a certain value
     * @param key to be added
     * @param value to be added
     * @return old value for key if there is one
     */
    public V put(K key, V value)
    {
        for(MapEntry< K, V> i: buckets[toBucketIndex(key)])
        {
            if(key == null && i.getKey() == null || key != null && key.equals(i.getKey()))
            {
                V temp = i.getValue();
                i.setValue(value);
                return temp;
            }
        }
        buckets[toBucketIndex(key)].add(new MapEntry(key,value));
        size++;
        return null;



    }

    /**
     * Removes the entry of a certain key
     * @param key to be removed
     * @return corresponding value
     */
    public V remove(Object key)
    {
        LinkedList<MapEntry<K, V>> bucket = buckets[toBucketIndex(key)];
        for(MapEntry<K, V> i: bucket)
        {
            if(key == null && i.getKey() == null || key != null && key.equals(i.getKey()))
            {
                V temp = i.getValue();
                bucket.remove(i);
                size--;
                return temp;
            }
        }
        return null;
    }

    
    public void putAll(Map<? extends K, ? extends V> m)
    {
        for (K key : m.keySet())
        {
            put(key, m.get(key));
        }
    }


    public void clear()
    {
        for (int i = 0; i < NUM_BUCKETS; i++)
        {
            buckets[i] = null;
        }
    }


    public Set<K> keySet()
    {
        HashSet<K> keys = new HashSet<K>();
        for(LinkedList<MapEntry<K, V>> x : buckets)
        {
            for(MapEntry<K, V> y : x)
            {
                keys.add(y.getKey());
            }
        }
        return keys;
    }


    public Collection<V> values()
    {
        ArrayList<V> values = new ArrayList<V>();
        for(LinkedList<MapEntry<K, V>> x : buckets)
        {
            for(MapEntry<K, V> y : x)
            {
                values.add(y.getValue());
            }
        }
        return values;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet()
    {
        HashSet<java.util.Map.Entry<K, V>> x = new HashSet<java.util.Map.Entry<K, V>>();
        for(LinkedList<MapEntry<K, V>> i : buckets)
        {
            for(MapEntry<K, V> y : i)
            {
                x.add(y);
            }
        }
        return x;
    }
}
