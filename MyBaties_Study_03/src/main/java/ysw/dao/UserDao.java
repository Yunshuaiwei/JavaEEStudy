package ysw.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ysw.domain.User;

import java.util.List;

public interface UserDao {

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    @Update("delete from user where id=#{id}")
    void deleteUserById(Integer id);

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    /**
     * 查询总用户数量
     *
     * @return java.lang.Integer
     * @Param []
     **/
    @Select("select count(id) from user")
    Integer selectUserNum();
}
