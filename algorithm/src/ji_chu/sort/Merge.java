package ji_chu.sort;

/**
 * 自顶向下排序
 */
public class Merge {
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
    //原地归并
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo,j = mid+1;
        for(int k = lo; k <= hi; k++)//复制数组
            aux[k] = a[k];
        for(int k=lo; k <= hi; k++)//归并到a[lo...hi]
            {
                if(i>mid) a[k] = aux[j++];
                else if(j>hi) a[k] = aux[i++];
                else if(less(aux[j],aux[i])) a[k] = a[j++];
                else a[k] = a[i++];
        }
    }

    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];//一次性分配空间
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo,int hi)
    {//将数组a[lo..hi]排序
        if(hi <= lo) return;
        int mid= (hi-lo)/2+lo;
        sort(a,lo,mid);//左半边排序
        sort(a,mid+1,hi);//右半边排序
        merge(a,lo,mid,hi);//归并
    }
}
