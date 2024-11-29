package com.ccw.mapper;

import com.ccw.entity.User;

import java.util.List;

public interface UserMapper {
    void insertUser(User user);

    User selectByUsername(String username);

    void deleteUserById(Integer id);


    void updateUserById(User user);

    User selectById(Integer id);

    List<User> selectAll(User user);
}
