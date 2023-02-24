package com.example.mapper;

import com.example.pojo.User;

import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/24 11:07
 */
public interface UserMapper {

    List<User> findAll();
}
