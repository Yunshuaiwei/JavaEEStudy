package ysw.jdbctemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ysw.Account;
import ysw.dao.IAccountDao;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/21 20:08
 * @Version
 **/
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        Account id = accountDao.findAccountById(1);

        id.setMoney((double) 500);
        accountDao.updateAccount(id);

    }
}

