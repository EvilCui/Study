package ji_chu.graph;

import ji_chu.Queue_lianbiao;

/**
 * 即使实现
 * 索引优先队列
 */
public class PrimMST {
    private Edge[] edgeTo; //距离树最近的边
    private double[] distTo; //权值最小的边
    private boolean[] marked; //最小生成树顶点
    private IndexMinPQ<Double> pq;  //横切边

    public PrimMST(EdgeWeightedGraph G){
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        distTo = new double[G.V()];
        for(int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;//正无穷
        distTo[0] = 0.0;
        pq.insert(0,0.0);
        while(!pq.isEmpty())
            visted(G,pq.delMin());
    }

    private void visted(EdgeWeightedGraph G,int v){
        //添加v到树中
        marked[v] = true;
        for(Edge w: G.adj(v)){
            int m = w.other(v);
            if(marked[m]) continue;
            if(w.Weigth() < distTo[m]){
                edgeTo[m] = w;
                distTo[m] = w.Weigth();
                if(pq.contains(m)) pq.change(m,distTo[m]);
                else pq.insert(m,distTo[m]);
            }
        }
    }

    public Iterable<Edge>edges(){
        return null;
    }
}
