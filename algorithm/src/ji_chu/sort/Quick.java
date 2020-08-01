package ji_chu.sort;

public class Quick {
    public static boolean less(Comparable v,Comparable w)
    {
        return v.compareTo(w)<0;
    }
    public static void exch(Comparable[] a,int m,int n ){
        Comparable t = a[m];
        a[m] = a[n];
        a[n] = t;

    }
    public void show (Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }

    public static void sort(Comparable[] a)
    {
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi < lo) return;
        int j = paration(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int paration(Comparable[] a, int lo, int hi){
        //数组分为a[lo,..,i-1],a[i],a[i+1,..,hi]
        int i = lo, j = hi+1;//左右指针
        Comparable v = a[lo];//用于切分的元素
        while(true){
            while (less(a[++i],v)) if( i == hi)break;//从左到右找到第一个比v大的元素
            while(less(v,a[--j]))if(j == lo)break;//从右到左找到第一个比v小的数
            if(i>=j)break;
            exch(a,i,j);
        }
        exch(a,lo,j);//将v=a[j]放入正确位置
        return j;   //a[lo..j-1] <= a[j] <= a[j+1..hi]
    }

}
