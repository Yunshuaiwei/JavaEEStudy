package ysw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ysw.domain.Account;
import ysw.domain.User;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/7/1 9:45
 * @Version
 **/
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     * @Param [account]
     * @return java.lang.String
     **/
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("saveAccount方法执行！！！");
        System.out.println(account.toString());
        return "success";
    }

    /**
     * 自定义类型转换器测试
     * @Param [user]
     * @return java.lang.String
     **/
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("saveUser执行！！");
        System.out.println(user);
        return "success";
    }

}
