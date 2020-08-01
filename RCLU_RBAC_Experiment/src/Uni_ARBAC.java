import java.util.*;

public class Uni_ARBAC {
    public static void main(String[] args) {
        int[] source = new int[15];
        for(int i = 0; i < 15; i++){
            source[i] = i;
        }

        //建立角色树
        //15个角色
        RoleHierarchy r = new RoleHierarchy(15);
        for(int i = 0;i < 6; i++){
            r.addEdge(source[i],source[2*i+1]);
            r.addEdge(source[i],source[2*i+2]);
        }

        //建立用户池
        Map<Integer, List<Integer>> UserPool = new HashMap<>();
        //用户池0
        List<Integer> roles0 = new ArrayList<>();
        roles0.add(14);
        roles0.add(13);
        UserPool.put(6,roles0);
        //用户池1
        List<Integer> roles1 = new ArrayList<>();
        roles1.add(12);
        roles1.add(11);
        UserPool.put(5,roles1);
        //用户池2
        List<Integer> roles2 = new ArrayList<>();
        roles2.add(10);
        roles2.add(9);
        UserPool.put(4,roles2);
        //用户池3
        List<Integer> roles3 = new ArrayList<>();
        roles1.add(8);
        roles3.add(7);
        UserPool.put(3,roles3);
        //用户池树
        RoleHierarchy userpool = new RoleHierarchy(7);
        userpool.addEdge(0,1);
        userpool.addEdge(0,2);
        userpool.addEdge(2,5);
        userpool.addEdge(2,6);
        userpool.addEdge(1,4);
        userpool.addEdge(1,3);

        //用户角色分配时间
        long start = System.currentTimeMillis();
        for(int count = 2000;count >= 0; count--) {
            Random random = new Random();
            int i = random.nextInt(15);
            if(i<=6){
                DFS dfs1 = new DFS(userpool, i);
            }else{
                for(Map.Entry entry:UserPool.entrySet()){
                List<Integer> userpoolhasrole = (List<Integer>) entry.getValue();
                if(userpoolhasrole.contains(i)){
                    DFS dfs2 = new DFS(userpool,(int)entry.getKey());
                }
                }
            }

            if(count % 200 == 0){
                long end = System.currentTimeMillis() - start;
                System.out.println("UniARBAC用户角色分配时间"+ end);
            }
        }
    }
}
