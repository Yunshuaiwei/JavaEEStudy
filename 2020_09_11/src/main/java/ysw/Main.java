package ysw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ysw.service.IAccountService;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/13 9:49
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.saveAccount();
    }
}
