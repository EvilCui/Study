package ji_chu.find;

/**
 * 顺序查找（基于无序链表）
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearch <Key,Value>{
    private Node first;//链表首节点
    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key,Value val,Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public Value get(Key key){
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.val;
        return null;
    }

    public void put(Key key,Value val) {
        //查找给定的键，找到跟新找不到新建
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.val = val;
            }
        first = new Node(key, val, first);
    }
}
