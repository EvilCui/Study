import java.util.ArrayList;

/**
 * 角色继承层次结构
 * 偏序
 */
public class RoleHierarchy {
    private  int V; //顶点数目
    private int E;       //边的数目
    private ArrayList<Integer>[] adj; //邻接表
    //public Map<Integer,Role> Role;
    public RoleHierarchy(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V]; //创建邻接表
        for(int v = 0; v < V; v++) {        //将所有链表初始化为空
            adj[v] = new ArrayList<>();
        }

    }
    public RoleHierarchy(int[] input){
        this.V = input.length;
        this.E = 0;
        adj = new ArrayList[input[input.length-1]+1];
        for(int i:input){
            adj[i] = new ArrayList<>();
        }
    }

    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v,int w){
        adj[v].add(w); //把w添加到v链表中
        E++;
    }
    public Iterable<Integer> adj(int v)
    { return adj[v];}


}
