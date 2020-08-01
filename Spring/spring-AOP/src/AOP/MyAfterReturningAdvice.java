package AOP;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

//后置通知
public class MyAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        //后置通知
        //o：前面函数的返回值
        //method：哪个方法被调用
        //objects：调用方法的参数
        //o1：目标对象
        System.out.println("后置通知：调用结束，关闭资源。");
    }
}
