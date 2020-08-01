package ji_chu.graph;

import ji_chu.Queue_lianbiao;
import ji_chu.sort.MinPQ;

/**
 * prim延时实现
 */

public class LazyPrimMST {
    private boolean[] marked; //最小生成树顶点
    private Queue_lianbiao<Edge> mst; //最小生成树的边
    private MinPQ<Edge> pq;  //横切边

    public LazyPrimMST(EdgeWeightedGraph G){
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue_lianbiao<>();
        visted(G,0);
        while(!pq.isEmpty()){
            Edge min = pq.delMin();
            int m = min.either();
            int n = min.other(m);
            if( marked[m] && marked[n]) continue;;
            mst.enqueue(min);
            if( !marked[m] ) visted(G,m);
            if(!marked[n]) visted(G,m);
        }
    }

    private void visted(EdgeWeightedGraph G,int v){
        marked[v] = true;
        for(Edge w: G.adj(v)){
            if(!marked[w.other(v)]) pq.insert(w);
        }
    }

    public Iterable<Edge>edges(){
        return mst;
    }
}
