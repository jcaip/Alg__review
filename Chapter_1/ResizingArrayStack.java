import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>
{
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() { return N == 0;}
    public int size() {return N; }

    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0;i < N; i++)
        {
            temp[i] = a[i];
        }
        temp = a;
    }

    public void push(Item item)
    {
        if (N == a.length)
        {
            resize(2*N);
        }
        a[N++] = item;
    }

    public Item pop()
    {
        Item temp = a[N--];
        a[N--] = null;
        if (N != 0 && a.length/4==N)
        {
            resize(N/2);
        }
        return temp;
    }

    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;
        public boolean hasNext() { return i > 0;}
        public Item next() { return a[--i]; }
        public void remove() {}
    }
}
