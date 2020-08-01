package ji_chu.String;

import ji_chu.Queue_lianbiao;

/**
 * 基于单词查找树的符号表
 */
public class TrieST<Value> {
    private static int R = 256;//基数
    private Node root;

    public static class Node{
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key){
        Node x = get(root,key,0);
        if( x == null) return null;
        return (Value)x.val;
    }

    private Node get(Node x, String key, int d){
        //返回以x作为根节点的子单词查找树中与key相关联的值
        if( x== null) return null;
        if(d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c],key,d+1);
    }

    public void put(String key, Value val) {
        root = put(root,key,val,0);
    }

    private Node put(Node x, String key, Value val, int d){
        //如果key存在于以x为根节点的子单词查找树中，则更新与它相关联的值
        if(x == null) x= new Node();
        if(d == key.length()){x.val = val;return x;}
        char c = key.charAt(d);//找到第d个字符所对应的子单词查找树
        x.next[c] = put(x.next[c],key,val,d+1);
        return x;
    }

    public Iterable<String> keys(){
        return keyswithPrefix("");
    }

    //前缀匹配
    public Iterable<String> keyswithPrefix(String pre){
        Queue_lianbiao<String> q = new Queue_lianbiao<String>();
        //先找到前缀的最后一个结点
        collect(get(root,pre,0),pre,q);
        return q;
     }

     private void collect(Node x, String pre, Queue_lianbiao<String> q){
        if(x == null) return;
        if(x.val != null) q.enqueue(pre);
        for(char c = 0; c < R; c++){
            collect(x.next[c],pre+c,q);
        }
     }

     //通配符匹配
     public Iterable<String> keysThatMatch(String pat){
        Queue_lianbiao q = new Queue_lianbiao();
        collect(root,"",pat,q);
        return q;
     }

    private void collect(Node x, String pre, String pat, Queue_lianbiao<String> q){
        int d = pre.length();
        if(x == null) return;
        if(d == pat.length() && x.val != null) q.enqueue(pre);
        if(d == pat.length()) return;
        char next= pat.charAt(d);
        for(char c = 0; c < R; c++){
            if(next == '.' || next == c)
            collect(x.next[c],pre+c,pat,q);
        }
    }

    //最长前缀
    public String longstPrefixOf(String s){
        int length = search(root,s,0,0);
        return s.substring(0,length);
    }

    private int search(Node x, String s, int d, int length){
        if(x == null) return length;
        if(x.val != null) length =d;
        if(d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c],s,d+1,length);
    }

    public void delete(String key){
        root = delete(root,key,0);
    }

    private Node delete(Node x,String key, int d){
        if(x == null) return null;
        if(d == key.length())
            x.val = null;
        else{
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c],key,d+1);
        }
        if(x.val != null) return x;
        for(char c =0; c<R;c++)
            if(x.next[c] != null) return x;
        return null;
    }
}
