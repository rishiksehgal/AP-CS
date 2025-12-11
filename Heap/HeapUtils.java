/**
 * HeapUtils is a class that has various methods that can be run on an array that acts as a heap
 * 
 * @author Rishik Sehgal
 * @version Nov 31, 2025
 *
 */ 
public class HeapUtils 
{
    private int heapSize = 0;
    /**
     * Creates a HeapUtils object
     * @param h is the size of heap
     */
    public HeapUtils(int h)
    {
        heapSize = h;
    }

    /**
     * Retrieves the heapSize
     * @return the heapSize
     */
    public int getHeapSize()
    {
        return heapSize;
    }

    /**
     * Time Complexity O(log n) because the amount of times it runs depends on the height
     * , and the height is the exponent by which you get the number of nodes in a binary tree.
     * Heapifys the subtree starting from the index given
     * @param heap is the array that we heapify from 
     * @param index is the root of the tree that we heapify
     */
    public void heapify(Comparable[] heap, int index)
    {
        int largest = index;
        int left = 2 * index;
        int right = 2 * index + 1;
        if(left <= heapSize && heap[left].compareTo(heap[largest]) > 0)
        {
            largest = left;
        }
        if( right <= heapSize && heap[right].compareTo(heap[largest]) > 0)
        {
            largest = right;
        }
        if(largest != index)
        {
            Comparable x = heap[index];
            heap[index] = heap[largest];
            heap[largest] = x;
            heapify(heap, largest);
        }
    }

    /**
     * Creates the Heap using the heapify method by starting from the last parent node and going up.
     * Time Complexity O(n) because number of operations is proportional to the size of the array.
     * Goes from every parent node up to the root node and does the heapify operation.
     * @param heap is the array being converted into a heap using the heapify method
     */
    public void buildHeap(Comparable [] heap)
    {
        int y = heapSize/2;
        for(int i = y; i >= 1; i--)
        {
            heapify(heap, i);
        }
    }

    /**
     * Removes and returns the root value, leaving a complete binary tree that is one element
     *  smaller and meets the heap condition. 
     * Time Complexity O(log n) every operation other than heapify has fixed time so time complexity
     * is the time complexity of remove.
     * @param heap is the heap in which the root value is removed
     * @return the root node which is removed
     */
    public Comparable remove(Comparable[] heap)
    {
        if(heapSize != 0)
        {
            Comparable x = heap[1];
            heap[1]= heap[heapSize];
            heapSize--;
            heapify(heap, 1);
            return x;
        }    
        return null;
        
    }

    /**
     * It inserts item into the heap, maintaining the heap property, and returns the resulting heap.
     * Time Complexity is O(log n) if array does not need to be resized O(n) if it does.
     * Since the node added is at the end, if heapify is used, it might not fit the heap property.
     * Instead of going down it goes up but the time complexity is the same as heapify( O(log n)).
     * If it needs to be resized it runs a for loop for each element of the heap which is O(n).
     * @param heap is the heap in which the item is inserted
     * @param item to be inserted
     * @return the resulting heap
     */
    public Comparable[] insert(Comparable[] heap, Comparable item)
    {
        if(heapSize >= heap.length - 1)
        {
            Comparable[] temp = new Comparable[heap.length + 1];
            for(int i = 0; i < heap.length; i++)
            {
                temp[i] = heap[i];
            }
            heap = temp;
        }
        heapSize++;
        heap[heapSize] = item;
        int last = heapSize;
        while(last/2 >= 1 && heap[last].compareTo(heap[last / 2]) > 0)
        {
            Comparable x = heap[last];
            heap[last] = heap[last / 2];
            heap[last / 2] = x;
            last = last / 2;
        }

        return heap;
        
    }

    /**
     * Creates a max-heap from the array and then swaps the root with the last element.
     * It then heapifys the array with a smaller heap size so it does not affect the already
     * sorted element.
     * Time Complexity is O(n log n) because the for loop is dependent upon the number of elements
     * in heap and heapify is run for each element which has a time complexity of O(log n).
     * By multiplying the two, you get the time complexity of O(n log n).
     * @param heap the array that is sorted using heapSort
     * @return the sorted array
     */
    public Comparable[] heapSort(Comparable[] heap)
    {
        buildHeap(heap);
        int x = heapSize;
        for(int i = heapSize; i > 1; i--)
        {
            Comparable temp = heap[1];
            heap[1] = heap[i];
            heap[i] = temp;
            heapSize--;
            heapify(heap, 1);
        }
        heapSize = x;
        return heap;
    }
}
