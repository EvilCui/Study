package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("AOP/beans.xml");
        TestServiceInter serviceInter= (TestServiceInter)ac.getBean("proxyFactoryBean");
        serviceInter.sayHi();
        //当一个类继承多个接口，那么他们之间可以互转
        ((TestServiceInter2)serviceInter).sayBye();
    }
}
