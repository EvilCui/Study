package ji_chu.find;

/**
 * 基于线性探测的符号表
 */

public class LinearProbingHash<Key, Value> {
    private int N;//键值对总数
    private int M = 16;//散列表大小
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHash(){
        keys = (Key[])new Object[M];
        vals = (Value[])new Object[M];
    }

    public LinearProbingHash(int capacity){
        keys = (Key[])new Object[capacity];
        vals = (Value[])new Object[capacity];
        M = capacity;
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap){
        LinearProbingHash<Key,Value> t;
        t = new LinearProbingHash(cap);
        for(int i = 0; i < M; i++)
            if(keys[i] != null)
                t.put(keys[i],vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key,Value val){
        if (N > M/2) resize(2*M);
        int i;
        for( i = hash(key); keys[i] != null; i = (i + 1) % M){
            if( keys[i].equals(key) ) {
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
        }

    }

    public Value get(Key key){
        for(int i = hash(key); keys[i] != null; i = (i+1)%M )
            if(keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key){
        if(get(key) == null) return;
        int i = hash(key);
        while(!key.equals(keys[i])){
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while(keys[i] != null){
            Key rekey = keys[i];
            Value reval = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(rekey,reval);
            i = (i + 1) % M;
        }
        N--;
        if(N > 0 && N == M/8) resize(M/2);
    }


}

