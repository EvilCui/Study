package ji_chu.sort;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private int N;
    private Item[] a= (Item[])new Object[1];

    public Bag() {
    }

    public void add(Item item){ a[N++] = item; }

    public boolean isEmpty(){ return N == 0; }

    public int size(){ return N; }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
