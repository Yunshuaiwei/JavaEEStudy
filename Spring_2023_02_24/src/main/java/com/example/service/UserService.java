package com.example.service;

import com.example.pojo.User;

import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/24 10:57
 */
public interface UserService {

    List<User> findAll();
}
