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
import java.util.ArrayList;
import java.util.Date;
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


    //插入操作
    @Test
    public void saveUserTest() throws Exception {
        User user = new User();
        user.setUsername("Lily");
        user.setAddress("中国深圳");
        user.setBirthday(new Date());
        user.setSex("女");
        //测试配置插入操作后，获取插入数据的id
        System.out.println("插入之前：" + user);
        userDao.saveUser(user);
        System.out.println("插入之后：" + user);
    }

    //更新操作
    @Test
    public void updateUserTest() {
        User user = new User();
        user.setId(2);
        user.setUsername("Job");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("中国深圳");

        userDao.updateUser(user);
    }

    //删除用户
    @Test
    public void deleteUserTest() {
        userDao.deleteUser(1);
    }

    //根据Id查询用户信息
    @Test
    public void selectUserByIdTest() {
        User user = userDao.selectUserById(5);
        System.out.println(user);
    }

    //根据名称模糊查询
    @Test
    public void selectUserByUserNameTest() {
        List<User> users = userDao.selectUserByUserName("%o%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    //查询数据库中记录条数
    @Test
    public void findUserTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
    }

    //根据条件查询
    @Test
    public void findUserByConditionTest() {
        User user = new User();
//        user.setSex("女");
        user.setUsername("Lily");
        List<User> userList = userDao.findUserByCondition(user);
        for (User u : userList) {
            System.out.println(u);
        }
    }

    //foreach标签测试
    @Test
    public void findInIdsTest(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        List<User> userInList = userDao.findUserInList(list);
        for (User user : userInList) {
            System.out.println(user);
        }
    }
}
