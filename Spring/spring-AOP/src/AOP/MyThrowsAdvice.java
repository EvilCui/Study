package AOP;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class MyThrowsAdvice implements ThrowsAdvice {
    //异常通知
    //ThrowsAdvice这个接口是标识性接口，没有任何方法
    public void afterThrowing(Method m, Object[] os, Object target, Exception e){
        System.out.println("异常通知：出问题了："+e.getMessage());
    }
}
