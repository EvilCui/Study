package ji_chu.sort;

/**
 * 自底向上
 */
public class MergerBU {
    private static Comparable[] aux;//辅助数组

    public static boolean less(Comparable v,Comparable w)
    {
        return v.compareTo(w)<0;
    }

    public void show (Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }

    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++)//复制数组
            aux[k] = a[k];
        for(int k = 0; k <= hi; k++)//归并到a[lo...hi]
        {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[j],aux[i])) a[k] = a[j++];
            else a[k] = a[i++];
        }
    }

    public static void sort(Comparable[] a)
    {//进行lgN次的两两归并
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1; sz < N; sz = sz+sz)//sz子数组大小
            for(int lo = 0; lo < N-sz; lo += sz+sz)//lo:子数组的索引 每次合并两个子数组
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));

    }
}
