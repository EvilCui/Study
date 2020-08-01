package ji_chu.sort;

/**
 * 计时器
 */
public class stopWatch {
    private final long start;
    public stopWatch(){
        start = System.currentTimeMillis();
    }
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now-start)/1000.0;
    }
}
