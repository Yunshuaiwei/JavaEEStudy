package ysw.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ysw.dao.UserDAO;
import ysw.domain.User;

import java.io.InputStream;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/24 10:04
 * @Version
 **/
public class MyBatisTest {
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        UserDAO userDao = session.getMapper(UserDAO.class);
        //5.使用代理对象执行方法
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        //6.关闭资源
        session.close();
        in.close();
    }
}
