package org.service.impl;

import org.dao.UserDao;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/22 10:50
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void show(){
        System.out.println(userDao);
    }
}
