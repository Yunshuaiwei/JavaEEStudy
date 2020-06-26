package ysw.dao;

import ysw.domain.User;

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
     * 根据id查询用户信息
     *
     * @return void
     * @Param [id]
     **/
    User selectUserById(Integer id);

}
