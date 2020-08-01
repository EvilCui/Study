package ji_chu.sort;

/**
 * 希尔排序
 */
public class Shell {
    public static void sort(Comparable[] a){
        //升序排列
        int N=a.length;
        int h=1;
        //找最大序列h
        while(h<N/3)
            h= 3*h+1;//1，4，13，40.......
        while(h>1){
            for(int i=h;i<N;i++){
                //将a[i]插入到a[i-h],a[i-2h],a[i-3h]...之中
                for(int j=i; j>=h&&less(a[j],a[j-h]);j-=h)
                    exch(a,j,j-h);
            }
            h=h/3;
        }
    }

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

    public static boolean isSorted(Comparable[] a){
        //测试是否排序
        for(int i=1;i<a.length;i++)
            if(less(i,i-1))
                return false;
        return true;
    }
}
