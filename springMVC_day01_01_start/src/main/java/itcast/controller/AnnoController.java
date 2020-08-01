package itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})//把msg=美俄米存入session域中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name") String username){
        System.out.println("执行了。。。。");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求体的内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了。。。。");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name ="id" )String id){
        System.out.println("testPathVariable执行了。。。。");
        System.out.println(id);
        return "success";
    }

    /**
     *ModelAttribute注解
     * @param
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(){
        System.out.println("执行了。。。。");
        return "success";
    }

    @ModelAttribute
    public void showUser(){
        System.out.println("showUser执行");
    }

    /**
     * SessionAttributes
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("执行了。。。。");
        //底层会存储到request域
        model.addAttribute("msg","美俄米");
        return "success";
    }

    /**
     * 从session域中取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("执行了。。。。");
        String msg =(String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 从session域中删除
     * @param
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("执行了。。。。");
        status.setComplete();
        return "success";
    }
}
