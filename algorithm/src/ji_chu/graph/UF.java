package ji_chu.graph;

/**
 * 连接两点  动态连接性
 * 法一quick_find
 * 法二quick_union 把点连接在一起，统一根节点
 */
public class UF {
    private int[] id;//以触点为索引分量id
    private int count;//分量数量

    public UF(int N){
       count = N;
        id = new int[N];
        for(int i=0;i<N;i++)
            id[i]=i;
    }



    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(id[p]) == find(id[q]);
    }

    //法一
    public int find(int p){
        return id[p];
    }

    public void unio(int p,int q){
        //把p和q归并到相同分量
        /*
        int pID = find(p);
        int qID = find(q);
        //值相同表示已连通
        if(qID == pID)  return;

        //不同的话合并值即两个都用任意一方的值此处都用p的值
        for(int i=0;i<id.length;i++){
            if(pID==id[i]) id[i] = id[pID];
            count--;
        }
        */
        //quick_unio
        //统一p,q根节点
        int pRoot = quick_unio_find(p);
        int qRoot = quick_unio_find(q);
         if(pRoot == qRoot) return;
         id[pRoot] = qRoot;
         count--;
    }

    private int quick_unio_find(int p){
        //quick_unio找出分量名称 找根触点
        while(p!= id[p]) p=id[p];
        return p;
    }
}
