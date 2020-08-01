import java.io.File;
import java.io.IOException;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        //获得原始数据
        Input input = new Input();
        Scanner file  = new Scanner(new File(""));
        int[] oldData = input.readFile(file);

        //去重
        ArrayList<Integer> temp = new ArrayList<Integer>();//临时数组
        for(int i=0; i<oldData.length;i++){
            if(!temp.contains(oldData[i])) temp.add(oldData[i]);
        }
        Collections.sort(temp);//排序
        ArrayList<Integer> ids = temp; //保存排序去重后的结果
        int N = 0;//节点数
        //建立新的顺序的映射
        Map<Integer,Integer> idHash = new HashMap<>();
        for(Integer id:temp){
            idHash.put(id,++N);
        }

        //初始化图
        int E = temp.size();
        Graph graph = new Graph(E);
        int[] inDegrees = new int[E];
        for(int i : inDegrees){
            inDegrees[i] = 0;
        }
        for(int g=0;g<oldData.length;g=g+2){
            int u,v;//两个顶点
            u = idHash.get(oldData[g]);
            v = idHash.get(oldData[g+1]);
            graph.addEdge(u,v);
            ++inDegrees[v];
        }

        //dfs
        //初始化访问标记

        DepthFirstPaths dp = new DepthFirstPaths();
        boolean[] marked = dp.markedInilization(temp.size());
        for(int i=0; i<temp.size(); i++ ){
            if(!graph.adj[i].isEmpty()){
                dp.dfs();
            }
        }
    }
}
