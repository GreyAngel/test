package com.it.luo.controller;

import com.it.luo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

/**
 * 注解测试
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})  //将msg=测试  存入到session域中
public class AnnoController {

    /**
     * 测试 RequestParam注解的作用
     * 对不同名称的参数进行映射对应
     * 注意：RequestParam的值默认为必传
     * @param username
     * @return
     */
    @RequestMapping("RequestParams")
    public String testRequestParam(@RequestParam(name = "name" , required = false) String username){
        System.out.println( username );
        return "success";
    }

    /**
     * RequestBody注解
     * @param body
     * @return
     */
    @RequestMapping("RequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println( body );
        return "success";
    }

    /**
     * PathVariable注解
     * 用于获取url中 占位符的数据
     * @param id
     * @return
     */
    @RequestMapping("PathVariable/{userId}")
    public String testPathVariable(@PathVariable(name = "userId") String id){
        System.out.println( id );
        return "success";
    }


    /**
     * 获取请求头信息
     * @param header
     * @return
     */
    @RequestMapping("RequestHeader")
    public String testRequestHeader(@RequestHeader(name = "Accept") String header){
        System.out.println( header );
        return "success";
    }


    /**
     * 获取Cookie值
     * @param cookie
     * @return
     */
    @RequestMapping("CookieValue")
    public String testCookieValue(@CookieValue(name = "JSESSIONID") String cookie){
        System.out.println( cookie );
        return "success";
    }

    /**
     * 测试 ModelAttribute
     * 主要作用是将数据添加到模型对象中，用于视图层展示时使用
     * 作用:在controller方法被执行前执行
     * 适用场景：徐亚
     * 有两种方式，一种有返回值，一种没有返回值
     * 注意：被@ModelAttribute注释的方法会在此controller每个方法执行前被执行，因此对于一个controller映射多个url的情况下慎用
     *
     * @param user
     * @return
     */
    @RequestMapping("/ModelAttribute")
    public String testModelAttribute(User user){
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void testModelAttribute(){
        System.out.println("modelAttribute方法 执行了...");
    }

    /**
     * 方法一：有返回值的
     * @param name
     * @return
     */
    @ModelAttribute
    public User getUser( String name ){
        System.out.println("getUser 执行了...");
        // 补全User中的缺失的信息(根据name在数据库中查询)  (模拟数据库操作)
        User user = new User();
        user.setName(name);
        user.setAge(10);
        user.setBirthday(new Date());
        return user;
    }

    /*@RequestMapping("/ModelAttribute")
    public String testModelAttribute(@ModelAttribute("data") User user){
        System.out.println(user);
        return "success";
    }

    *//**
     * 方法二：没有返回值的，
     *  通过Map 设置User值，在请求方法中通过map获取到user值
     * @param name
     * @param map
     *//*
    @ModelAttribute
    public void getUser(String name , Map<String , User> map){
        System.out.println("getUser 执行了...");
        // 补全User中的缺失的信息(根据name在数据库中查询)  (模拟数据库操作)
        User user = new User();
        user.setName(name);
        user.setAge(10);
        user.setBirthday(new Date());
        map.put("data" , user);
    }*/


    /**
     * SessionAttributes
     * 将指定的Model中的键值对添加到session中，方便在下一次请求中使用
     * 注意：@SessionAttributes只能作用在类上
     * @return
     */
    @RequestMapping("/addSessionAttributes")
    public String addSessionAttributes(Model model){
        System.out.println("addSessionAttributes...");
        //底层会把值存储到request域对象中
        model.addAttribute("msg","测试");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes...");
        status.setComplete();
        return "success";
    }


}
