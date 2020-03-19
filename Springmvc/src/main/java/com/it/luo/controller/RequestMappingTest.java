package com.it.luo.controller;

import com.it.luo.bean.Account;
import com.it.luo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/requestMapping")
public class RequestMappingTest {

    /**
     * 测试 RequestMapping的相关属性
     * path和value属性效果一样
     * params指定请求需要传的参数，若有"="，则值必须与设置的相同
     * method 指定请求的方法，可以指定多个
     * headers 指定请求头信息需要的参数
     * @return
     */
    @RequestMapping(path = "testPath" , params = {"testMsg","testMsg2=test"} , method = {RequestMethod.GET,RequestMethod.POST} , headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("test requestMapping");
        return "success";
    }

    @RequestMapping(path = "testParams")
    public String testRequestParams( String username ) {
        System.out.println("request params");
        System.out.println("request massage :  username=" + username);
        return "success";
    }

    @RequestMapping(path = "testReceiveBean")
    public String testReceiveBeanMsg( Account account ) {
        System.out.println("request params");
        System.out.println(account.toString());
        return "success";
    }

    /**
     * 测试自定义的类型转换器
     * 原本默认时间格式为 yyyy/MM/dd  改成 时间格式yyyy-MM-dd 与 yyyy/MM/dd兼容
     * 类型转换器见文件  StringToDateConverter
     * 自定类型转换器添加 见文件  springmvc.xml
     * @return
     */
    @RequestMapping("converter")
    public String testConverter(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 获取原生Servlet API
     * @return
     */
    @RequestMapping("getServlet")
    public String testServlet(HttpServletRequest request , HttpServletResponse response ){
        System.out.println("request:" + request );
        HttpSession session = request.getSession();
        System.out.println("session" + session);
        ServletContext context = session.getServletContext();
        System.out.println("context"+ context );
        System.out.println("response" + response);
        return "success";
    }




}
