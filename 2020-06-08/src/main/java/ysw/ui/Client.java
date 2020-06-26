package ysw.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ysw.service.IAccountService;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/17 17:15
 * @Version
 **/
public class Client {
    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
//        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
//        System.out.println(adao);
    }
}
