import dao.IUserDao;
import domain.QueryVo;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的crud操作
 */
public class test {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @Before//在测试方法执行之前执行
    public void init()throws Exception {
        //1.读取配置文件，生产字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After//测试方法执行之后执行
    public void destory()throws Exception{
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() throws Exception{
        //1.读取配置文件，生产字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis saveuser");
        user.setAddress("南京市秦淮区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存之前"+user);
       //执行保存方法
        userDao.saveUser(user);
        System.out.println("保存之后"+user);
     }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(50);
        user.setUsername("mybatis Updateuser");
        user.setAddress("南京市秦淮区");
        user.setSex("女");
        user.setBirthday(new Date());
        //执行更新方法
        userDao.updateUser(user);

    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){
        //执行删除方法
        userDao.deleteUser(51);
    }

    /**
     * 测试查询一个操作
     */
    @Test
    public void testFindOne(){
        //执行查询一个方法
        User user = userDao.findById(41);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName(){
        //执行查询一个方法
     //   List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
        for(User user:users){
        System.out.println(user);
    }
    }

    /**
     * 测试总记录数作
     */
    @Test
    public void testFindTotal(){
        //执行查询一个方法
        int num = userDao.findTotal();
        System.out.println(num);
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        //执行查询一个方法
        //   List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findUserByVo(vo);
        for(User u:users){
            System.out.println(u);
        }
    }
}
