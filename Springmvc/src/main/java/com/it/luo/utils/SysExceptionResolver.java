package com.it.luo.utils;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器对象
 * 需要在springmvc.xml中配置才能起效
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //获取异常对象
        SysException ex;
        if( e instanceof SysException ){
            ex = (SysException) e;
        }else{
            ex = new SysException("系统该功能仍在开发...");
        }

        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg" , ex.getErrorMsg());
        mv.setViewName("error");
        return mv;
    }
}
