package ji_chu;

public class WeightedQuickUnionUF {
    private int[] id;//以触点为索引分量id
    private int[] sz;//（由触点为索引）各根节点对应分量大小
    private int count;//分量数量

    public WeightedQuickUnionUF(int N){
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++)
            id[i]=i;
        sz = new int[N];
        for(int i=0;i<N;i++) sz[i]=1;
    }

    private int find(int p){
        //找到根节点
        while(p!= id[p]) p=id[p];
        return p;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(id[p]) == find(id[q]);
    }

    public void unio(int p,int q){

        //统一p,q根节点
        int i = find(p);
        int j = find(q);
        if(i == j) return;
        //将小叔的根节点连接到大树的根节点
        if(sz[i] < sz[j]){
            id[i]=j;
            sz[j]+=sz[i];
        }else
        {
            id[j]=i;
            sz[i]+=sz[j];
        }
        count--;
    }
}
