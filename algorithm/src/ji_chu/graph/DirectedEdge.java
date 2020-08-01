package ji_chu.graph;

/**
 * 加权无向图
 */
public class DirectedEdge {
    private final int v;//起点
    private final int w;//终点
    private final double weigth;

    public DirectedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weigth = weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public double Weigth(){
        return weigth;
    }


    public String toString(){
        return String.format("%d-%d %.2f",v,w,weigth);
    }

}
