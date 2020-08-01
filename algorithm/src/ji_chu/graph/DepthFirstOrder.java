package ji_chu.graph;

import ji_chu.Queue_lianbiao;

import java.util.Stack;

/**
 * 拓扑排序
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue_lianbiao<Integer> pre;
    private Queue_lianbiao<Integer> post;
    private Stack<Integer> reversePost;
    public DepthFirstOrder(Digraph G){
        marked = new boolean[G.V()];
        pre = new Queue_lianbiao<Integer>();
        post = new Queue_lianbiao<Integer>();
        reversePost = new Stack<Integer>();
        for(int v = 0; v < G.V(); v++){
            dfs(G,v);
        }
    }

    public DepthFirstOrder(EdgeWeightedDigraph G){
        marked = new boolean[G.V()];
        pre = new Queue_lianbiao<Integer>();
        post = new Queue_lianbiao<Integer>();
        reversePost = new Stack<Integer>();
        for(int v = 0; v < G.V(); v++){
            dfs(G,v);
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        pre.enqueue(v);
        for(int i:G.adj(v)){
            if(marked[i] != false) dfs(G,i);
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    private void dfs(EdgeWeightedDigraph G, int v){
        marked[v] = true;
        pre.enqueue(v);
        for(DirectedEdge i:G.adj(v)){
            int w = i.to();
            if(marked[w] != false) dfs(G,w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }
    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
