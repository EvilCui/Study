package collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Department department = (Department)ac.getBean("department");
        System.out.println(department.getName());

        System.out.println("取String数组");
        for(String e:department.getEmpName()){
            System.out.println(e);
        }

        System.out.println("取list");
        for (Employee e:department.getEmpList()){
            System.out.println("name="+e.getName());
        }

        System.out.println("取set...");
        for (Employee employee:department.getEmpSet()){
            System.out.println("name="+employee.getName());
        }

        System.out.println("迭代器获取map...");
        Map<String,Employee> empMap = department.getEmpMap();
        Iterator iterator = empMap.keySet().iterator();
        while(iterator.hasNext()){
            String  key = (String) iterator.next();
            Employee employee = empMap.get(key);
            System.out.println("key="+key+" "+ employee.getName());
        }

        System.out.println("entry获取map...");
        for(Map.Entry<String,Employee> entry:empMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue().getName());
        }

        System.out.println("通过properties取数据");
        Properties properties = department.getPp();
        for (Map.Entry<Object,Object> entry:properties.entrySet()){
            System.out.println(entry.getKey().toString()+" "+entry.getValue());
        }
    }
}
