package ysw.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ysw.dao.AccountDao;
import ysw.domain.Account;
import ysw.domain.AccountUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/26 16:31
 * @Version
 **/
public class AccountTest {

    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao account;

    @Before
    public void init() throws IOException{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession=factory.openSession();
        account = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> list = account.findAll();
        for (Account acc : list) {
            System.out.println(acc);
        }
    }

    //查询所有账户，同时包含用户名和地址信息
    @Test
    public void testFindAllAccount(){
        List<AccountUser> allAccount = account.findAllAccount();
        for (AccountUser user : allAccount) {
            System.out.println(user);
        }
    }
}
