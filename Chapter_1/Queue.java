import java.util.Iterator;

public class Queue<Item>
{
    private Node first;
    private Node last;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void enqueue(Item item)
    {
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            old.next = last;
        N++;
    }

    public Item dequeue()
    {
        Item temp = first.item;
        first = first.next;
        N--;
        return temp;
    }
    
    //Testing code
    public static void main(String[] args)
    {
        Queue<String> q = new Queue<String>();
        q.enqueue("Foo");
        q.enqueue("Bar");

        System.out.println(q.size());
    }
}
