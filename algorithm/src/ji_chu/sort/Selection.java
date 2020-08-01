package ji_chu.sort;

/**
 * 选择排序 N^2/2次比较，N次交换
 */
public class Selection {

    public static void sort(Comparable[] a){
        //升序排列
        int N = a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i+1;j<N;j++) {
                if (less(a[j], a[min]))
                    min = j;
                exch(a,min, i);
            }
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
