package com.it.luo.controller;

import com.it.luo.utils.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

    /**
     * 测试自定义异常
     * @return
     */
    @RequestMapping("/sysException")
    public void sysException() throws SysException {

        System.out.println("异常测试执行了...");

        try {
            //错误
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
            //抛出自定义异常
            throw new SysException("分母不能为0");
        }

    }


}
