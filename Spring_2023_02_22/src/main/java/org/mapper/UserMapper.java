package org.mapper;

import org.pojo.User;

import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/22 14:54
 */
public interface UserMapper {
    List<User> findAll();
}
