package ysw.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ysw.dao.UserDao;
import ysw.domain.User;

import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/26 10:09
 * @Version
 **/
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    @Override
    public List<User> findAll() {
        //1.获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("ysw.dao.UserDao.findAll");
        //3.释放资源
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("ysw.dao.UserDao.saveUser",user);
        session.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("ysw.dao.UserDao.updateUser",user);
        session.commit();
        session.close();
    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public User selectUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> selectUserByUserName(String userName) {
        return null;
    }

    @Override
    public int findTotal() {
        return 0;
    }
}
