package ji_chu;
import java.util.Arrays;

/**
 * 二分查找 logN
 */
public class BinarySearch {
    public static int rank(int key, int[] a){
        //数组有序
        int lo = 0;
        int hi = a.length-1;
        while(lo <= hi)
        //查找范围必然在[lo.hi]否则不存在
        {
            int mid = lo + (hi-lo)/2;
            if(key <a[mid]) hi = mid-1;
            else if(key>a[mid]) lo= mid+1;
            else return mid;
        }
        return -1;
    }
}
