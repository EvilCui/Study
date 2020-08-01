package UserDao;

import POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
    public UserMapper userMapper;
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
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void login() {
        System.out.println(this.userMapper.login("hj", "123456"));
    }

    @Test
    public void queryUserByTableName() {
        List<User> userList = this.userMapper.queryUserByTableName("tb_user");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserById() {
        System.out.println(this.userMapper.queryUserById(1L));
    }

    @Test
    public void queryUserAll() {
        List<User> userList = this.userMapper.queryUserAll();
        for(User u : userList){
            System.out.println(u);
        }
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("大神");
        user.setPassword("123456");
        user.setSex(2);
        user.setUserName("bigGod222");
        this.userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静静");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("Jinjin");
        user.setId("1");
        this.userMapper.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        this.userMapper.deleteUserById(1L);
    }

    @Test
    public void queryUserList(){
        List<User> users = this.userMapper.queryUserList(null);
        for(User u: users){
            System.out.println(u);
        }
    }

    @Test
    public void queryUserListByNameOrAge() throws Exception {
        List<User> users = this.userMapper.queryUserListByNameOrAge(null, 16);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserListByNameAndAge() throws Exception {
        List<User> users = this.userMapper.queryUserListByNameAndAge("鹏程", 20);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateUser2() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静静");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("Jinjin");
        user.setId("2");
        this.userMapper.updateUser(user);
    }

    @Test
    public void queryUserListByIds() throws Exception {
        List<User> users = this.userMapper.queryUserListByIds(new String[]{"2","3"});
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryUserById() {
        System.out.println(this.userMapper.queryUserById(2L));
        System.out.println(this.userMapper.queryUserById(2L));
    }

}