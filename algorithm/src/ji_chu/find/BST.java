package ji_chu.find;

import ji_chu.Queue_lianbiao;

/**
 * 基于二叉查找树的符号表
 */

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;//根节点

    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int N;
        public Node(Key key,Value val,int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp>0) return get(x.left,key);
        else if(cmp<0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value value){
        root = put(root,key,value);
    }

    private Node put(Node x,Key key, Value value){
        if( x == null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left,key,value);
        else if(cmp > 0) x.right = put(x.right,key,value);
        else x.val = value;
        x.N = size(x.right)+size(x.left)+1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right == null) {
            return x;
        }
        return min(x.right);
    }

    public Key floor(Key key){
        Node x = floor(root,key);
        if( x == null) return null;
        return x.key;
    }

    private Node floor(Node x,Key key){
        if( x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if(cmp < 0) return floor(x.left,key);
        Node t = floor(x.right,key);
        if(t != null) return t;
        else return x;
    }

    public Key select(int n){
        return select(root, n).key;
    }
    private Node select(Node x, int k){
        if( x == null) return null;
        int t = size(x.left);
        if(t > k) return select(x.left,k);
        else if(t < k) return select(x.right, k-t-1);
        else return x;
    }

    public  int rank(Key key){
        return rank(root,key);
    }

    private int rank(Node x,Key key){
        if( x == null ) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return rank(x.left,key);
        else if(cmp > 0) return 1 + size(x.left) + rank(x.right,key);
        else return size(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if( x.left == null ) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.right)+size(x.left)+1;
        return x;
    }

    public void delete(Key key){
        root = delete(root,key);
    }


    private Node delete(Node x,Key key){
        if( x==null ) return null;
        int cmp = key.compareTo(x.key);
        if( cmp < 0) return delete(x.left,key);
        else if( cmp > 0) return delete(x.right,key);
        else {
            if(x.left == null) return x.left;
            if(x.right == null) return  x.right;
            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.right)+size(x.left)+1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi) {
        Queue_lianbiao<Key> queue = new Queue_lianbiao<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    //中序遍历
    private void keys(Node x, Queue_lianbiao queue, Key lo, Key hi){
        if( x == null ) return ;
        int cmplo = lo.compareTo(x.key);
        int cmphi = lo.compareTo(x.key);
        if( cmplo < 0 ) keys(x.left,queue,lo,hi);
        if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right,queue,hi,lo);
    }
}
