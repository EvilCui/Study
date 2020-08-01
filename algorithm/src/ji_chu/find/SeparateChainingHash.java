package ji_chu.find;

/**
 * 基于拉链法
 */

public class SeparateChainingHash<Key,Value> {
    private int N;//键值对总数
    private int M;//散列表大小
    private SequentialSearch<Key,Value>[] st;//存放链表对象的数组

    public SeparateChainingHash()
    {
        this(997);
    }

    public SeparateChainingHash(int M){
        this.M = M;
        st = (SequentialSearch<Key,Value>[])new SequentialSearch[M];//java不允许泛型数组
        for(int i = 0; i < M; i++){
            st[i] = new SequentialSearch<>();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        return st[hash(key)].get(key);
    }

    public void put(Key key,Value value){
        st[hash(key)].put(key,value);
    }

}
