package ji_chu.String;

/**
 * 启发地处理不匹配的字符
 */

public class BoyerMoore {
    private int[] right;//记录每个字符在模式串中出现的最右的地方
    private String pat;

    public BoyerMoore(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for(int i=0; i<R; i++){
            right[i] = -1;//初始化
        }
        for(int i = 0; i<M; i++ ){
            right[pat.charAt(i)] = i;
        }
    }
    public int search(String txt){
        int N = txt.length();
        int M = pat.length();
        int skip;
        for(int i = 0; i<N-M; i+= skip){
            skip = 0;
            for(int j = M-1; j>= 0; j--){
                if(pat.charAt(j) != txt.charAt(i+j)){
                    skip = j-right[txt.charAt(i+j)];
                    if(skip < 1) skip = 1;
                    break;
                }
            }
            if(skip == 0) return i;
        }
        return N;
    }
}
