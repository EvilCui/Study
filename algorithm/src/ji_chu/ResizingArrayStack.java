package ji_chu;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 下压栈 LIFO 能够实现动态调整数组大小的实现
 */

public class ResizingArrayStack <Item> implements Iterable<Item> {

    private int N;//数组元素
    private Item[] a= (Item[])new Object[1];//栈元素
    public ResizingArrayStack(){
        //构造方法
    }

    public int Size(){
        return N;
    }

    public boolean isEmpty(){
        return N== 0 ;
    }

    //动态调节栈的大小。
    public void resize(int max){
        Item[] temp = (Item[])new Object[max];
        for(int i=0;i<N;i++)
            temp[i]=a[i];
        a = temp;
    }

    public void push(Item item){
        //动态调整栈的大小
        if( N == a.length){
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;//避免对象游离
        //动态调整栈的大小
        if(N >0 && N == a.length/4)
            resize(a.length/2);
        return item;
    }

    //迭代器支持先进后出
    private class ResizingArrayStackIterator implements Iterator<Item>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() { }

    }

    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayStackIterator();
    }
}
