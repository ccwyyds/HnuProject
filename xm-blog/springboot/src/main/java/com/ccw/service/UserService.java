package com.ccw.service;

import com.ccw.entity.Account;
import com.ccw.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    void insertUser(User user);

    void deleteUserById(Integer id);

    void deleteBatch(List<Integer> ids);

    void updateUserById(User user);


    User selectById(Integer id);

    List<User> selectAll(User user);

    PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize);

    Account login(Account account);

    void register(Account account);
}
