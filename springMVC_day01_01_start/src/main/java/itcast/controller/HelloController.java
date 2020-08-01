package itcast.controller;

import itcast.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类，接受请求
@Controller
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path = "/hello")//请求路径
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(path="/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("测试RequetsMapping注解。。。");
        return "success";
    }


}
