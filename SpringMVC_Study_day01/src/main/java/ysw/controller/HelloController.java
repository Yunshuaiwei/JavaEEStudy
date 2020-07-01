package ysw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/29 10:39
 * @Version
 **/
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "success";
    }

}
