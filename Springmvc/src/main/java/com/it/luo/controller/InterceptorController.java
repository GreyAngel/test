package com.it.luo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("interceptor")
public class InterceptorController {

    @RequestMapping("testInterceptor")
    public String testInterceptor(){

        System.out.println("测试拦截器的controller执行了...");
        return "interceptor";
    }

}
