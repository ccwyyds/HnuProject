package com.ccw.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ccw.common.Constants;
import com.ccw.common.enums.ResultCodeEnum;
import com.ccw.common.enums.RoleEnum;
import com.ccw.entity.Account;
import com.ccw.entity.User;
import com.ccw.exception.CustomException;
import com.ccw.mapper.UserMapper;
import com.ccw.service.UserService;
import com.ccw.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     * @param user
     */
    public void insertUser(User user){

        //根据用户名查询用户
        User dbUser = userMapper.selectByUsername(user.getUsername());
        //1.判断用户账号是否重复
        if(dbUser != null){
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        //2.判断密码是否为空
        if(ObjectUtil.isEmpty(user.getPassword())){
            user.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        //3.判断用户名称是不是为空
        if(ObjectUtil.isEmpty(user.getName())){
            user.setName(user.getUsername());
        }
        //4.默认用户的角色
        user.setRole(RoleEnum.USER.name());

//        将此user添加到数据库
        userMapper.insertUser(user);

    }

   /**
    * 根据id删除用户
    * @author xixiw
    * @time 2024/5/20 💕 23:25
    */
    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);

    }


    /**
     * 批量删除用户
     * @author xixiw
     * @time 2024/5/20 💕 23:25
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            userMapper.deleteUserById(id);
        }
    }

    /**
     * 根据id修改
     * @author xixiw
     * @time 2024/5/21 💕 12:58
     */
    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);

    }

    /**
     * 根据id查询用户
     * @author xixiw
     * @time 2024/5/21 💕 16:39
     */
    @Override
    public User selectById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }

    /**
     * 查询所有用户
     * @author xixiw
     * @time 2024/5/21 💕 16:40
     */
    @Override
    public List<User> selectAll(User user) {
        List<User> userList = userMapper.selectAll(user);
        return userList;
    }

    /**
     * 分页查询
     * @author xixiw
     * @time 2024/5/21 💕 16:40
     */
    @Override
    public PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userMapper.selectAll(user);
        return PageInfo.of(list);
    }

    /**
     * 用户登录
     * @author xixiw
     * @time 2024/5/21 💕 22:33
     */
    @Override
    public Account login(Account account) {
        Account user = userMapper.selectByUsername(account.getUsername());
        if(ObjectUtil.isNull(user)){
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }else if (!account.getPassword().equals(user.getPassword())){
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }
        // 生成token
        String tokenData = user.getId() + "-" + RoleEnum.USER.name();
        String token = TokenUtils.createToken(tokenData, user.getPassword());
        user.setToken(token);
        return user;

    }

    /**
     * 用户注册
     * @author xixiw
     * @time 2024/5/21 💕 23:20
     */
    @Override
    public void register(Account account) {
        User user = new User();
        BeanUtils.copyProperties(account, user);
        this.insertUser(user);
    }


}
