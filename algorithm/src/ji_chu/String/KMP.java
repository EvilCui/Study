package ji_chu.String;

public class KMP {
    public int strStr(String txt,String pattern){
        char[] t = txt.toCharArray();
        char[] p = pattern.toCharArray();
        if(pattern.length() == 0) return 0;
        if(txt.length() == 0) return -1;
        //先构造pattern
        int j = -1, i = 0;//j在后面，i在前面
        int[] b = new int[pattern.length()];
        while(i<pattern.length()){
            while(j>=0 && p[i] != p[j]) j = b[j];
            i++;
            j++;
            b[i]= j+1;

        }
        j = 0;//txt初始位
        i = 0;//pattern初始位
        while( j< txt.length()){
            while( i >= 0 && t[j] != p[i]) i = b[i];
            i++;
            j++;
            if( i == p.length){
                return j-i;
            }
        }
        return -1;
    }
}
