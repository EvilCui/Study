package ji_chu.graph;

import ji_chu.sort.Bag;

public class EdgeWeightedDigraph {
    private  int V; //顶点数目
    private int E;       //边的数目
    private Bag<DirectedEdge>[] adj; //邻接表
    public EdgeWeightedDigraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[])new Bag[V]; //创建邻接表
        for(int v = 0; v < V; v++)         //将所有链表初始化为空
            adj[v] = new Bag<DirectedEdge>();
    }

    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(DirectedEdge e){
        adj[e.from()].add(e);
        E++;
    }
    public Iterable<DirectedEdge> adj(int v)
    { return adj[v];}

    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> b = new Bag<DirectedEdge>();
        for(int v = 0; v < V; v++){
            for(DirectedEdge e: adj[v]){
                 b.add(e);
            }
        }
        return b;
    }
}
