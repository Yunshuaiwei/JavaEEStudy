import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ysw.domain.Account;
import ysw.services.AccountService;

import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/4 12:53
 * @Version
 **/
public class TestSpring {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = (AccountService)context.getBean("accountService");
        List<Account> all = as.findAll();
    }
}
