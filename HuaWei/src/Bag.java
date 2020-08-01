import java.util.Iterator;

/**
 * 顺序表
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {

    private Node first;//链表首节点
    private int N;
    //定义结点嵌套类
    private class Node{
        Item item;
        Node next;
    }

    public Bag(){}

    public int Size(){
        return N;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop(){
        //从栈顶删除
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }


    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current.next == null;
        }

        @Override
        public Item next() {
            Item item = first.item;
            current = first.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
}
