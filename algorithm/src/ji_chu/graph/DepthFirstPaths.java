package ji_chu.graph;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;//起点

    public DepthFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;

        for(int i:G.adj(v))
            if(marked[i] != false){
                edgeTo[i] = v;
                dfs(G,i);
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
