package ji_chu.String;

/**
 * 低位优先字符串排序
 */
public class LSD {
    private int N;
    private int R = 256;
    private String[] aux;
    private int W;//字符串长度
    private String[] a;

    public LSD(String[] a,int w){
        N = a.length;
        aux = new String[N];
        this.W = w;
        this.a = a;
    }

    public void sort(){
        for(int d = W-1; d >= 0; d--){
            int[] count = new int[R+1];
            //统级频率
            for(int i = 0; i < N; i++){
                count[a[i].charAt(i)+1]++;
            }
            //转化为索引,记录起始位置
            for(int r = 0; r < R; r++){
                count[r+1] += count[r];
            }
            //分类
            for(int i = 0; i < N; i++){
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            //回写
            for(int i = 0; i < N; i++){
                a[i] = aux[i];
            }
        }
    }
}
