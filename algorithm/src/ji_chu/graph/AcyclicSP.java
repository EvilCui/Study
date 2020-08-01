package ji_chu.graph;

/**
 * 无环加权有向图
 * 根据拓扑排序访问
 */

public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G,int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for(int i = 0; i < G.V(); i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        Topological top = new Topological(G);
        for(int i:top.order()){
            relax(G,i);
        }
    }

    private void relax(EdgeWeightedDigraph G,int v){
        for(DirectedEdge e:G.adj(v)){
            int w = e.to();
            if(distTo[w] > distTo[v] + e.Weigth()){//更新最小路径
                distTo[w] = distTo[v] + e.Weigth();
                edgeTo[w] = e;
            }
        }
    }
}

