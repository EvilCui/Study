import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisTest {
    public static void main(String[] args) throws Exception{
        //指定全局配置文件
        String resource = "mybaties-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            User user = sqlSession.selectOne("MyMapper.selectUser", 1);
            System.out.println(user);
        }finally {
            sqlSession.close();
        }
    }
}
