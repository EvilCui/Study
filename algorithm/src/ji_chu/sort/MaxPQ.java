package ji_chu.sort;

/**
 * 基于堆的优先队列
 * @param <Key>
 * 数组第一个元素不存储
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; //基于堆的完全二叉树
    private int N = 0;

    public MaxPQ(int maxN)
    { pq = (Key[]) new Comparable[maxN+1];}

    public boolean isEmpty()
    {return N == 0;}

    public int size()
    {return N;}

    public boolean less(int i,int j)
    {
        return pq[i].compareTo(pq[j])<0;
    }

    public  void exch(int i,int j ){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        while(k > 1 && less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j<N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = k;
        }
    }

    public void insert(Key v)
    {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(Key v)
    {
        Key max = pq[1];
        exch(1,N--);    //根节点和最后一个节点交换
        pq[N+1] = null;
        sink(1);            //防止越界
        return max;
    }

}
