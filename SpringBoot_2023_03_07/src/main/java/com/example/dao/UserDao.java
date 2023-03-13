package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/8 11:53
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
