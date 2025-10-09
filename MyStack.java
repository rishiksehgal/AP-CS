public class MyStack<E>
{
    private DoubleNode node;


    public E push(E item)
    {
        DoubleNode n = new DoubleNode(item);
        if(isEmpty())
        {
            node = n;
        }
        else
        {
            node.setNext(n);
            n.setPrevious(node);
            node = n;
        }
        n.setNext(null);
        E x = (E) node.getValue();
        node = n;
        return x;
    }

    public E peek()
    {
        if(isEmpty())
        {
            return null;
        }
        return (E) node.getValue();
    }

    public E pop()
    {
        E thing = (E) node.getValue();
        node = node.getPrevious();
        if(node != null)
        {
            node.setNext(null);
        }
        return thing;
    }

    public boolean isEmpty()
    {
        return (node == null);
    }

    public int search(Object o)
    {
        int x = 1;
        DoubleNode n = node;
        while(n != null)
        {
            if(n.getValue().equals(o))
            {
                return x;
            }
            n = n.getPrevious();
            x++;
        }
        return -1;
        
    }

    public int size()
    {
        if(isEmpty())
        {
            return 0;
        }
        int x = 0;
        DoubleNode n = node;
        while(n != null)
        {
            n = n.getPrevious();
            x++;
        }
        return x;
    }
}
