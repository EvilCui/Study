package ji_chu.graph;

/**
 * 连通分量
 */
public class CC {
    private boolean[] marked;
    private int[] id;//以顶点为索引，关联顶点与连通分量标识符
    private int count;

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int s = 0; s < G.V(); s++){
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        id[v] = count;
        for(int w: G.adj(v)){
            if(!marked[w])
                dfs(G,v);
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }
}
