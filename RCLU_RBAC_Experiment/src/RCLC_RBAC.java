import java.util.*;

public class RCLC_RBAC {
    public static void main(String[] args){

        //两个逻辑单元
        //键是逻辑单元号，值是逻辑单元包含的角色集
        //默认角色已经在逻辑单元中，为了方便遍历
        Map<Integer, LogicUnit> map = new HashMap<>();//暂时没用，等逻辑单元多了方便查找
        //List<Integer> lu1 = new ArrayList<>();

        ArrayList<Integer> lu1 = new ArrayList<>();
        lu1.add(3);
        lu1.add(7);
        lu1.add(8);
        int[] l1 = {3,7,8};
        LogicUnit rulu1 = new LogicUnit(lu1,new RoleHierarchy(l1));
        map.put(1,rulu1);
        rulu1.role.addEdge(3,7);
        rulu1.role.addEdge(3,8);

        ArrayList<Integer> lu2 = new ArrayList<>();
        lu2.add(4);
        lu2.add(9);
        lu2.add(10);
        int[] l2 = {4,9,10};
        LogicUnit rulu2 = new LogicUnit(lu2,new RoleHierarchy(l2));
        map.put(2,rulu2);
        rulu2.role.addEdge(4,9);
        rulu2.role.addEdge(4,10);

        ArrayList<Integer> lu3 = new ArrayList<>();
        lu3.add(5);
        lu3.add(11);
        lu3.add(12);
        int[] l3 = {5,11,12};
        LogicUnit rulu3 = new LogicUnit(lu3,new RoleHierarchy(l3));
        map.put(3,rulu3);
        rulu3.role.addEdge(5,11);
        rulu3.role.addEdge(5,12);

        ArrayList<Integer> lu4 = new ArrayList<>();
        lu4.add(6);
        lu4.add(13);
        lu4.add(14);
        int[] l4 = {6,13,14};
        LogicUnit rulu4 = new LogicUnit(lu4,new RoleHierarchy(l4));
        map.put(4,rulu4);
        rulu4.role .addEdge(6,13);
        rulu4.role .addEdge(6,14);

        ArrayList<Integer> lu5 = new ArrayList<>();
        lu5.add(0);
        lu5.add(1);
        lu5.add(2);
        int[] l5 = {0,1,2};
        LogicUnit rulu5 = new LogicUnit(lu5,new RoleHierarchy(l5));
        map.put(5,rulu5);
        rulu5.role.addEdge(0,1);
        rulu5.role.addEdge(0,2);

        long lustart = System.currentTimeMillis();
        for(int count = 2000;count >= 0; count--){
            Random random = new Random();
            int i = random.nextInt(15);
            //先找逻辑单元
            //遍历逻辑单元内的树
            //for(Map.Entry entry:map.entrySet()){
                //LogicUnit lu = (LogicUnit)entry.getValue();
               // if(lu.list.contains(i)){
                //    DFS dfs = new DFS(lu.role,i,lu.list);
               //     break;
              //  }
            //}
            DFS dfs;
            if(rulu1.list.contains(i)){
                dfs = new DFS(rulu1.role,i,rulu1.list);
            }else if(rulu2.list.contains(i)){
                dfs = new DFS(rulu2.role,i,rulu2.list);
            }else if(rulu3.list.contains(i)){
                dfs = new DFS(rulu3.role,i,rulu3.list);
            }else if(rulu4.list.contains(i)){
                dfs = new DFS(rulu4.role,i,rulu4.list);
            }else{
                dfs = new DFS(rulu5.role,i,rulu5.list);
            }
            if(count % 200 == 0){
            long luend = System.currentTimeMillis() - lustart;
            System.out.println("逻辑单元角色分配时间" + luend);
            }
        }
    }
}
