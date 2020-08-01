package ji_chu.graph;

import ji_chu.Queue_lianbiao;

import java.util.Queue;

/**
 * 基于队列实现
 */

public class BellmanFordSP {
    private double[] distTo;//从起点到某个顶点路径长度
    private DirectedEdge[] edgeto;//从起点到某个顶点路径上最后一条边
    private boolean[] onQ;//统级顶点是否被放松,是否在队列中
    private Queue_lianbiao<Integer> queue;//即将被放松的顶点
    private int cost;//relax调用次数
    private Iterable<DirectedEdge> cycle;//是否有负权重环

    public BellmanFordSP(EdgeWeightedDigraph G, int s){
        distTo = new double[G.V()];
        edgeto = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue_lianbiao<Integer>();
        for(int i = 0; i < G.V(); i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        onQ[s] = true;
        queue.enqueue(s);
        //while(!queue.isEmpty() && !this.hasNegativecycle())
        while(!queue.isEmpty() ){
            int i = queue.dequeue();
            onQ[i] = false;
            relax(G,i);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v){
        for(DirectedEdge e: G.adj(v)){
            int w = e.to();
            if(distTo[w]>distTo[v] + e.Weigth()){
                distTo[w] = distTo[v] + e.Weigth();
                edgeto[w] = e;
                if(!onQ[w]){
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if(cost++ % G.V() == 0)
                findNegativeCycle();
        }
    }

    private void findNegativeCycle(){
        int V = edgeto.length;
        EdgeWeightedDigraph spt;
        spt = new EdgeWeightedDigraph(V);
        for(int v= 0; v < V;v++)
            if(edgeto[v] != null)
                spt.addEdge(edgeto[v]);
            
    }
}
