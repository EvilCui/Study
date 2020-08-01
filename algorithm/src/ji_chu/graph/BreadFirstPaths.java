package ji_chu.graph;

import ji_chu.Queue_lianbiao;
import java.util.Stack;

public class BreadFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;//起点

    public BreadFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    private void bfs(Graph G, int s){
        Queue_lianbiao<Integer> queue = new Queue_lianbiao<>();
        marked[s] = true;
        queue.enqueue(s);
        while(!queue.isEmpty()){
            int w = queue.dequeue();
        for(int i:G.adj(w))
            if(marked[i] != false){
                edgeTo[i] = w;
                marked[i] = true;
                queue.enqueue(i);

            }
        }
    }

    public boolean hashPathTo(int w){
        return marked[w];
    }

    public Iterable<Integer> pathTo(int v){
        if( !hashPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x!=s ; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
