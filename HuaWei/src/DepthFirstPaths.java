import java.util.ArrayList;

/**
 * 深度优先搜索遍历
 */
public class DepthFirstPaths {
    private boolean[] marked; //标记是否访问过
    private int[] path;
    private int s; // 起点

    public  boolean[] markedInilization(int N){
        for(int i = 1; i<N; i++)
        marked[i] = false;
        return marked;
    }

    public int[] pathInilization(){

    }

    public void dfs(Graph g,int head, int cur ,int depth, int[] path){
        marked[cur] = true;
        path[] = cur;
        for(int v :g.adj(cur)){
            if(v==head && depth>=3 && depth<=7)
            {
                ArrayList<Integer> temp ;
                for(int i:path){
                    temp.add()
                }
            }
            if(depth<7 && !marked[cur] && cur>head){
                dfs(head,v,depth+1,path);
            }
        }
        marked[cur] = false;
        path.pop();
    }
}
