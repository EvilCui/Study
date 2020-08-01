import Bean.User;
import Bean.User2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Manager {
    public static void main(String[] args){
        //传统方法
        //User user = new User();
        //user.setName("ss");
        //user.sayHello();

        //Spring方式
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
                User user= (User)ac.getBean("user");
        System.out.println(user.getName());
        user.sayHello();

        User2 user2 = (User2)ac.getBean("user2");
        user2.sayBye();
    }
}
