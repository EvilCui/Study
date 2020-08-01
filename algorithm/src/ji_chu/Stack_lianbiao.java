package ji_chu;

import java.util.Iterator;

/**
 * 链表实现栈
 * @param <Item>
 */
public class Stack_lianbiao <Item> implements Iterable<Item> {

    private Node first;//栈顶元素
    private int N;
    //定义结点嵌套类
    private class Node{
        Item item;
        Node next;
    }
    public void push(Item item) {
        //向栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;

    }

    public Item pop(){
        //从栈顶删除
        Item item = first.item;
             first = first.next;
             N--;
             return item;
    }

    private class Stackiterator implements Iterator<Item>{
        Node current = first;
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
        return new Stackiterator();
    }
}
