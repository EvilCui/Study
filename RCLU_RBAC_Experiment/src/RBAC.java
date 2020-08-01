import java.util.*;

public class RBAC {
    public static void main(String[] args){
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

        //建立管理员角色,管理普通用户分配角色
        Map<Integer, List<Integer>> admin = new HashMap<>();
        //管理员0
        List<Integer> roles0 = new ArrayList<>();
        roles0.add(0);
        roles0.add(1);
        roles0.add(2);
        admin.put(0,roles0);
        //管理员1
        List<Integer> roles1 = new ArrayList<>();
        roles1.add(3);
        roles1.add(7);
        roles1.add(8);
        admin.put(1,roles1);
        //管理员2
        List<Integer> roles2 = new ArrayList<>();
        roles2.add(4);
        roles2.add(9);
        roles2.add(10);
        admin.put(2,roles2);
        //管理员3
        List<Integer> roles3 = new ArrayList<>();
        roles1.add(2);
        roles3.add(5);
        roles3.add(11);
        roles3.add(12);
        admin.put(3,roles3);
        //管理员4
        List<Integer> roles4 = new ArrayList<>();
        roles4.add(6);
        roles4.add(13);
        roles4.add(14);
        admin.put(4,roles4);

        //管理员继承树
        RoleHierarchy ad = new RoleHierarchy(5);
        ad.addEdge(0,1);
        ad.addEdge(0,2);
        ad.addEdge(0,3);
        ad.addEdge(0,4);

        //用户角色分配时间
        long start = System.currentTimeMillis();
        for(int count = 2000;count >= 0; count--) {
            Random random = new Random();
            int i = random.nextInt(15);
            DFS dfs = new DFS(r, i);
            for(Map.Entry entry:admin.entrySet()){
                 List<Integer> hasrole = (List<Integer>) entry.getValue();
                 if(hasrole.contains(i)) break;
            }
            if(count % 200 == 0){
            long end = System.currentTimeMillis() - start;
            System.out.println("RBAC角色分配时间"+ end);
            }
        }


    }
}
