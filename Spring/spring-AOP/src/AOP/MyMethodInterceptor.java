package AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //环绕通知
        System.out.println("环绕通知：进入函数体，调用方法前");
        Object obj = methodInvocation.proceed();
        System.out.println("环绕通知：完成调用");
        return obj;
    }
}
