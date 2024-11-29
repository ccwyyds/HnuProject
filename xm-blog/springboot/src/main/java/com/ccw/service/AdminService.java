package com.ccw.service;

import com.ccw.entity.Account;
import com.ccw.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
    void add(Admin admin);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Admin admin);
    Admin selectById(Integer id);
    List<Admin> selectAll(Admin admin);
    PageInfo<Admin> selectPage(Admin admin, Integer pageNum, Integer pageSize);
    Account login(Account account);

    void updatePassword(Account account);
}
