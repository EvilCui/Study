package com.BeanLife;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        //BeanFactory ac = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        PersonService person1 = (PersonService) ac.getBean("personService");
        person1.sayHi();
    }
}
