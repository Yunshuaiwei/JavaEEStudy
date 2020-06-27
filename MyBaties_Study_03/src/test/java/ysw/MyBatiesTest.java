package ysw;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ysw.dao.UserDao;
import ysw.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/27 11:34
 * @Version
 **/
public class MyBatiesTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao user = sqlSession.getMapper(UserDao.class);
        List<User> users = user.findAll();
        for (User u : users) {
            System.out.println(u);
        }
        sqlSession.close();
        in.close();
    }
}
