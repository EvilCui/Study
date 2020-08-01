package ji_chu.graph;

import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // 有向环中的所有顶点
    private boolean[] onStack; //用来保存递归调用栈上的顶点是否访问过

    public DirectedCycle(Digraph G){
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for(int v = 0; v <G.V(); v++ )
         if(marked[v])dfs(G,v);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int i : G.adj(v))
            if(this.hasCycle()) return;
            else if (marked[i] != false) {
                edgeTo[i] = v;
                dfs(G, i);
            } else if (onStack[i]) {
                cycle = new Stack<Integer>();
                for(int x = v; x != i; x = edgeTo[x] ){
                    cycle.push(x);
                }
                cycle.push(i);
                cycle.push(v);
            }
            onStack[v] = false;

    }
    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> pathTo(int v){
        return cycle;
    }
}
