package com.it.luo.controller;

import com.it.luo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/response")
public class ResponseController {

    /**
     * 返回值类型为字符串
     * @param model
     * @return
     */
    @RequestMapping("StringResponse")
    public String StringResponse(Model model){
        System.out.println("执行了...");
        //模拟从数据库取User数据
        User user = new User();
        user.setName("luo");
        user.setAge(10);
        user.setBirthday(new Date());

        //将数据放入request域中 给前端进行获取
        model.addAttribute("user",user);
        return "response";
    }

    /**
     * void 无返回值的请求
     * 不写转发或者重定向或者响应的话 ，默认跳转 链接.jsp  例如下方会跳转 testVoid.jsp 从而导致方法请求到了，但是由于没有该jsp而报错
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request , HttpServletResponse response) throws Exception {
        System.out.println("test void response...");

        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/response.jsp").forward(request ,response);
//        return; //此处加不加 取决于 想不想要转发后面的代码执行

        //重定向
//        System.out.println(request.getContextPath());
//        response.sendRedirect(request.getContextPath() + "/index.jsp");


        //处理中文乱码问题
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接进行响应
        response.getWriter().print("响应");

    }

    /**
     * ModelAndView
     * 返回 Model值 以及View
     * @return
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("执行了...");
        ModelAndView mv = new ModelAndView();
        //模拟从数据库取User数据
        User user = new User();
        user.setName("劳");
        user.setAge(18);
        user.setBirthday(new Date());

        //将User存入到mv对象中，底层会把user对象存入到request对象
        mv.addObject("user" , user);
        //页面跳转
        mv.setViewName("response");  //此处会调用视图解析器  故只需要写名称就可以

        return mv;
    }


        @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("执行了...");

        //请求的转发  固定格式：  forward:+页面路径
        //return "forward:/WEB-INF/pages/response.jsp";

        //使用重定向  固定格式:  redirect:+页面路径
        //注意： 重定向无法访问 WEB-INF下的页面
        return "redirect:/index.jsp";

    }

//    @RequestMapping(path = "/testAjax")
//    public void testAjax(@RequestBody String body){
//        System.out.println("testAjax执行了...");
//        System.out.println(body);
//
//    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User user){
        System.out.println("testAjax执行了...");
        System.out.println(user.toString());
        //模拟数据库操作
        user.setName("啦啦啦");
        user.setAge(20);
        return user;
    }


}
