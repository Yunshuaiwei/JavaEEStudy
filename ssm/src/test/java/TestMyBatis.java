import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ysw.dao.AccountDao;
import ysw.domain.Account;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/4 20:51
 * @Version
 **/
public class TestMyBatis {

    @Test
    public void test1() throws IOException {

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = build.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();
        session.close();
        in.close();
        for (Account account : all) {
            System.out.println(account.toString());
        }

    }
    @Test
    public void test2() throws IOException {

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = build.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        Account account = new Account();
        account.setMoney(400d);
        account.setName("Marry");
        mapper.saveAccount(account);
        session.commit();
        in.close();
        session.close();

    }
}
