package ji_chu.graph;

import ji_chu.sort.Bag;

public class Graph {

    private  int V; //顶点数目
    private int E;       //边的数目
    private Bag<Integer>[] adj; //邻接表
    public Graph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[])new Bag[V]; //创建邻接表
        for(int v = 0; v < V; v++)         //将所有链表初始化为空
            adj[v] = new Bag<Integer>();
    }
    public Graph(){}
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v,int w){
        adj[v].add(w); //把w添加到v链表中
        adj[w].add(v); //把v添加到w链表中
        E++;
    }
    public Iterable<Integer> adj(int v)
    { return adj[v];}
}
