package com.it.luo.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器的编写
 * 步骤 1.编写拦截器类，实现HandlerInterceptor接口  如本类
 *      2.在springmvc.xml中配置拦截器
 *
 */
public class MyInterceptor1 implements HandlerInterceptor {

    /**
     * 预处理，在controller方法之前执行
     * 可以使用request或者response跳转到指定的页面
     * return true 表示放行  执行下一个拦截器， 如果没有了 则执行controller
     * return false 表示 不放行
     * 一般用于校验用户登录状态等情况
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1 执行了...前");
        //跳转页面
//        request.getRequestDispatcher("/WEB-INF/pages/interceptorRedirect.jsp").forward(request, response);
        return true;
    }


    /**
     * 后处理方法，在controller方法后执行，在JSP视图跳转之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1 执行了...后");
//        request.getRequestDispatcher("/WEB-INF/pages/interceptorRedirect.jsp").forward(request, response);
    }

    /**
     * 在JSP视图跳转后执行，不能再跳转页面了
     * 一般用于释放资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1 执行了..最后");
    }


}
