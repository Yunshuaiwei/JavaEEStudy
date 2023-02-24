package com.example.dao;

import com.example.pojo.User;

import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/24 10:58
 */
public interface UserDao {
    List<User> findAll();
}
