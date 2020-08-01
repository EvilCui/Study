package ji_chu.String;

public class Quick3string {
    private static int R = 256;//基数
    private static final int M = 15;//小数组的切换阈值
    private static String[] aux;//数据分类的辅助数组
    private static int charAt(String s, int d){
        if(d < s.length()) return s.charAt(d);else return -1;
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(String[] a){
        int N = a.length;
        aux = new String[N];
        sort(a,0,N-1,0);
    }

    private static void sort(String[] a,int lo, int hi, int d){
        if(hi <= lo+ M) return;
        int lt = lo, gt = hi;
        int v = charAt(a[lo],d);
        int i = lo + 1;
        while(i <= gt){
            int t = charAt(a[i],d);
            if(t < v) exch(a,lt++,i);
            else if(t > v) exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1,d);
        if(v >= 0) sort(a,lo,gt,d+1);
        sort(a,gt+1,hi,d);
    }
}
