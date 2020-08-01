package study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        //接口编程
        //ChangeLetter changeLetter = (ChangeLetter) ac.getBean("changeLetter");
        //System.out.println(changeLetter.change());
        //不使用接口
        UpperLetter upperLetter = (UpperLetter) ac.getBean("changeLetter");
        System.out.println(upperLetter.change());

    }
}
