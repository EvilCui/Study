package ji_chu.graph;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;//以顶点为索引，关联顶点与连通分量标识符
    private int count;

    public KosarajuSCC(Digraph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for(int s:order.reversePost()){
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(Digraph G,int v){
        marked[v] = true;
        id[v] = count;
        for(int w: G.adj(v)){
            if(!marked[w])
                dfs(G,v);
        }
    }

    public boolean stronglyConnected(int v, int w){
        return id[v] == id[w];
    }
}
