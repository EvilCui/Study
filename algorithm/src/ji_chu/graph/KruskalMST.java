package ji_chu.graph;

import ji_chu.Queue_lianbiao;
import ji_chu.sort.Bag;
import ji_chu.sort.MinPQ;

import java.util.Queue;

public class KruskalMST {
    private Queue_lianbiao<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G){
        mst = new Queue_lianbiao<>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for(Edge e:G.edges()){
            pq.insert(e);
        }
        UF uf = new UF(G.V());
        while( !pq.isEmpty() && mst.Size() < G.V()-1){
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if(uf.connected(v,w)) continue;;
            uf.unio(v,w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
