package AOP;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
    //前置通知
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        //method：被调用方法的名字
        //objects：给method传递的参数
        //o：目标对象
        System.out.println("记录日志。。。"+method.getName());
    }
}
