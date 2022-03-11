package ysw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ysw.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/7/3 9:17
 * @Version
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString!!!");
        User user = new User();
        user.setName("Tom");
        user.setPassword("1234");
        user.setAge(18);
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid!!!");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.getWriter().print("你好！！");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setAge(19);
        user.setPassword("1234");
        user.setName("Job");
        modelAndView.addObject("user", user);
        //指定跳转到某个页面
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/forwardOrRedirect")
    public String forwardOrRedirect() {
        System.out.println("转发或重定向！！");

        //转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User user) {
        System.out.println("testAjax执行！！！");
        //客户端发送Ajax的请求，传json字符串，后端将json字符串封装到User对象中
        System.out.println(user.toString());
        user.setName("Lily");
        user.setAge(30);
        //返回json数据
        return user;
    }
}
