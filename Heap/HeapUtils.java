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
}
