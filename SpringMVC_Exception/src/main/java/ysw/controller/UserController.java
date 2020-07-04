package ysw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/4 9:38
 * @Version
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){

        return "success";
    }
}
