import java.util.ArrayList;
import java.util.List;

/**
 * 遍历角色树
 * 深度优先搜索遍历
 */
public class DFS {
    private boolean[] marked;
    public DFS(RoleHierarchy G , int s){
        marked = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++){
            dfs(G,v);
            if(marked[s] == true) {return;}
        }
    }

    public DFS(RoleHierarchy G , int s, List<Integer> data){
        marked = new boolean[15];
        for(int i:data){
            dfs(G,i);
            if(marked[s] == true) {return;}
        }
    }

    private void dfs(RoleHierarchy G, int v){
        marked[v] = true;
        for(int i:G.adj(v)){
            if(marked[i] != false) dfs(G,i);
        }
    }

}
