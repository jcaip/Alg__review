import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>
{
    private Node first;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void push(Item item)
    {
        Node old = first;
        first = new Node();
        first.next = old;
        first.item = item;
        N++;
    }

    public Item pop()
    {
        Node temp = first;
        first = first.next;
        N--;
        return temp.item;
    }

    public Iterator<Item> iterator()
    {
        return new LinkedListIterator();
    }

    private class LinkedListIterator<Item> implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public Item next()
        { 
            Item temp = current.item;
            current = current.next;
            return temp;
        }
        public void remove()
        {
        }
    }
}
