package ji_chu.graph;

/**
 * 加权无向图
 */
public class Edge implements Comparable<Edge>{
    private final int v;
    private final int w;
    private final double weigth;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weigth = weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if( vertex == v ) return w;
        else if( vertex == w) return v;
        return -1;
    }

    public double Weigth(){
        return weigth;
    }

    @Override
    public int compareTo(Edge that){
        if( this.weigth < that.weigth ) return -1;
        else if( this.weigth > that.weigth ) return 1;
         else return 0;

    }

    public String toString(){
        return String.format("%d-%d %.2f",v,w,weigth);
    }

}
