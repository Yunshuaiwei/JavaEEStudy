package ysw.dao;

import ysw.domain.QueryVo;
import ysw.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ysw
 */
public interface UserDao {

    /**
     * 查询所有
     *
     * @return java.util.List<ysw.domain.User>
     * @Param []
     **/
    List<User> findAll();

    /**
     * 插入用户
     *
     * @return void
     * @Param [user]
     **/
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @return void
     * @Param [user]
     **/
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @return void
     * @Param [id]
     **/
    void deleteUser(Integer id);

    /**
     * 根据id查询用户信息
     *
     * @return void
     * @Param [id]
     **/
    User selectUserById(Integer id);

    /**
     * 根据姓名模糊查询用户信息
     *
     * @return java.util.List<ysw.domain.User>
     * @Param [userName]
     **/
    List<User> selectUserByUserName(String userName);

    /**
     * 查询总用户数
     *
     * @return int
     * @Param []
     **/
    int findTotal();

    /**
     * 根据不同条件进行查询
     * @Param [user]
     * @return java.util.List<ysw.domain.User>
     **/
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的id集合
     * @Param [vo]
     * @return java.util.List<ysw.domain.User>
     *
     * @param vo*/
    List<User> findUserInList(ArrayList<Integer> vo);
}
