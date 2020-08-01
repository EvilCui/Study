package ji_chu;

import java.util.Iterator;
import java.util.Queue;

public class Queue_lianbiao <Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public Queue_lianbiao(){}

    public boolean isEmpty(){ return first == null; }
    public int Size(){return N; }

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last=null;
        N--;
        return item;
    }

    private class Queueiterator implements Iterator<Item>{
        Queue_lianbiao.Node current = last;
        @Override
        public boolean hasNext() {
            return current.next == null;
        }

        @Override
        public Item next() {
            Item item = last.item;
            current = last.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new Queueiterator();
    }
}

