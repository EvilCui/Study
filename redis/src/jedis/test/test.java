package jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * jedis测试类
 */
public class test {

    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("127.0.0.1" ,6397);
        //2.操作
        jedis.set("username","214140308");
        //3.关闭连接
        jedis.close();
    }
}
