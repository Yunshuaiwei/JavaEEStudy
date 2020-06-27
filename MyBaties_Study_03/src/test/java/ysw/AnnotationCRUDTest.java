package ysw;

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
import java.util.Date;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/27 12:00
 * @Version
 **/
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        sqlSession=factory.openSession();
        userDao=sqlSession.getMapper(UserDao.class);
    }

    @After
    public void closeResources() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("Lily");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("中国 广州");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(5);
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("中国 杭州");
        user.setUsername("Tom");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUserById(6);
    }

    @Test
    public void testFindUserById(){
        User user = userDao.findById(2);
        System.out.println(user);
    }

    //查询总用户数量
    @Test
    public void testSelectUserNum(){
        Integer num = userDao.selectUserNum();
        System.out.println(num);
    }
}
