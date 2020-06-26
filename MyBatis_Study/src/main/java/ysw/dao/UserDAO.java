package ysw.dao;

import ysw.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 * @author 17790
 * @Param
 * @return
 **/
public interface UserDAO {
    /**
     * 查询所有
     * @Param []
     * @return java.util.List<ysw.domain.User>
     **/
    List<User> findAll();
}
