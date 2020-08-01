package study;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestStudent {
    public static void main(String[] args) {
        //类路径加载
        //ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        //文件系统方式
        ApplicationContext ac = new FileSystemXmlApplicationContext("G:\\IntelliJ IDEA\\Spring\\spring-interface\\src\\spring-config.xml");
        Student student1 = (Student) ac.getBean("student");
        Student student2 = (Student) ac.getBean("student");
        System.out.println(student1+" "+student2);
        //BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        //bf.getBean("student");
    }
}
