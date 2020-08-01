package ji_chu.sort;

/**
 * 插入排序  N^2/4次比较，N^2/4次交换
 */
public class Insertion {
    public static void sort(Comparable[] a){
        //升序排列
        int N=a.length;
        for(int i=0;i<N;i++){
            //讲a[i]插入到a[i-1],a[i-2],a[i-3]。。之中
            for(int j=i ; j>0 && less(a[j],a[j-1]);j--)
                exch(a,j,j-1);
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
