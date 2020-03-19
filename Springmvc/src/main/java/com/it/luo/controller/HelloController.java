package com.it.luo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello World");
        return "success";
    }

}
