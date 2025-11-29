public class HeapUtils 
{
    private int heapSize = 0;
    public HeapUtils(int h)
    {
        heapSize = h;
    }
    /**
     * Time Complexity O(n)
     * @param heap
     * @param index
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

    public void buildHeap(Comparable [] heap)
    {
        int y = heapSize/2;
        for(int i = y; i >= 1; i--)
        {
            heapify(heap, i);
        }
    }

    public  Comparable remove(Comparable[] heap)
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

    public  Comparable[] insert(Comparable[] heap, Comparable item)
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
}
