package UserDao;

import POJO.Order;
import POJO.OrderUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class OrderMapperTest {
    public OrderMapper orderMapper;
    @Before
    public void setUp() throws Exception {
        //指定文件
        String resource = "mybaties-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取Sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //动态代理
        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的 返回类型 一致
        // 4. statement的parameterType必须和mapper接口方法的 参数类型一 致（不一定
        this.orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void queryOrderUserByOrderNumber() {
        OrderUser orderUser = orderMapper.queryOrderUserByOrderNumber("201807010001");
        System.out.println(orderUser);
    }

    @Test
    public void queryOrderWithUserByOrderNumber() throws Exception {
        Order order = orderMapper.queryOrderWithUserByOrderNumber("201807010001");
        System.out.println(order);
    }

    @Test
    public void queryOrderWithUserAndDetailByOrderNumber() throws Exception {
        Order order = orderMapper.queryOrderWithUserAndDetailByOrderNumber("201807010001");
        System.out.println(order.getUser());
        System.out.println(order.getDetailList());
    }

    @Test
    public void queryOrderWithUserAndDetailItemByOrderNumber() throws Exception {
        Order order = orderMapper.queryOrderWithUserAndDetailItemByOrderNumber("201807010001");
        System.out.println(order);
        System.out.println(order.getUser());
        System.out.println(order.getDetailList());
    }

    /**
    @Test
    public void testQueryOrderAndUserByOrderNumberLazy(){
        Order order = orderMapper.queryOrderAndUserByOrderNumberLazy("201807010001");
        System.out.println(order.getOrderNumber());
        System.out.println("==========================");
        System.out.println(order.getUser());
    }
    */

}