package inherit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("inherit/spring-config.xml");
        Gradate gradate = (Gradate)ac.getBean("gradate");
        System.out.println(gradate.getName()+" "+gradate.getAge()+" "+gradate.getDegree());
    }
}
