package ysw.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ysw.dao.UserDao;
import ysw.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/25 10:51
 * @Version
 **/
public class MyBatisTest {

    private InputStream stream;
    private SqlSession sqlSession;
    private UserDao userDao;

    //在测试方法执行前执行
    @Before
    public void init() throws IOException {
        stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(stream);
        sqlSession = build.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    //在测试方法执行后执行
    @After
    public void close() throws IOException {
        //提交事务
        sqlSession.commit();
        //关闭资源
        stream.close();
        sqlSession.close();
    }

    //查找所有
    @Test
    public void testFindAll() throws IOException {
        userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
    //根据Id查询用户信息
    @Test
    public void selectUserByIdTest() {
        User user = userDao.selectUserById(5);
        System.out.println(user);
    }
}
