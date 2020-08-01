/**
 * 路径格式
 * ID最小的第一个输出；
 *  总体按照循环转账路径长度升序排序；
 *  同一级别的路径长度下循环转账账号ID序列，按照字典序（ID转为无符号整数后）升序排序
 */
public class Path {
    int length;//路径长度
    Bag[] path;//存储路径

    //初始化
    public Path(){ }

    public void addPath(int v,int w){
        path[v].add(w);
        length++;
    }
}
