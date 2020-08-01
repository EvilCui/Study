package ji_chu.graph;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;//路径上的最后一条边
    private double[] distTo;//最小路径值
    private IndexMinPQ<Double> pq;//等待放松的点

    //s起点
    public DijkstraSP(EdgeWeightedDigraph G, int s){
        //初始化
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for(int v= 0; v < G.V(); v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s,0.0);
        //
        while(!pq.isEmpty()){
            relax(G,pq.delMin());
        }
    }

    //v->w
    private void relax(EdgeWeightedDigraph G,int v){
        for(DirectedEdge e:G.adj(v)){
            int w = e.to();
            if(distTo[w] > distTo[v] + e.Weigth()){//更新最小路径
                distTo[w] = distTo[v] + e.Weigth();
                edgeTo[w] = e;
                if(pq.contains(w)) pq.change(w,distTo[w]);
                else pq.insert(w,distTo[w]);
            }
        }
    }
}
