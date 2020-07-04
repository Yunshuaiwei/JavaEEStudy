package ysw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ysw.domain.Account;
import ysw.services.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/4 12:39
 * @Version
 **/
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层:查询所有账户信息！！！");
        //调用service的方法
        List<Account> all = accountService.findAll();
        model.addAttribute("list", all);
        return "list";
    }

    /**
     * @Param [account]
     * @return java.lang.String
     * @Date 21:53 2020/7/4
     * @Description: 保存
     **/
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
