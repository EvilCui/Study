package ji_chu.find;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class RedBlackNode{
        Key key;
        Value val;
        RedBlackNode left,right;
        boolean color;
        int N;//结点数

        RedBlackNode(Key key, Value val, int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(RedBlackNode x){
        return x.color == RED;
    }

    private RedBlackNode root;

    //返回结点数
    public int size(){
        return size(root);
    }

    private int size(RedBlackNode x){
        if(x == null) return 0;
        else return x.N;
    }

    //转换一个结点的两个红色子节点和结点自身颜色
    private void filpColors(RedBlackNode h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    //左旋转
    private RedBlackNode rotateLeft(RedBlackNode h){
        RedBlackNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.right) + size(h.left);
        return x;
    }

    //右旋转
    private RedBlackNode rotateRight(RedBlackNode h){
        RedBlackNode x = h.left;
        h.left= x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.right) + size(h.left);
        return x;
    }

    //插入值
    public void put(Key key,Value val){
        root = put(root,key,val);
        root.color = BLACK;
    }

    private RedBlackNode put(RedBlackNode h, Key key, Value val){
        //标准插入操作
        if( h == null ) {
            return new RedBlackNode(key,val,1,RED);
        }

        int cmp = key.compareTo(h.key);
        if(cmp < 0) h.left = put(h.left, key, val);
        else if(cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if(!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) filpColors(h);

        h.N = 1 + size(h.right) + size(h.left);
        return h;
    }


}
