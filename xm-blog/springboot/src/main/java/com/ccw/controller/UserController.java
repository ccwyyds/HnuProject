package com.ccw.controller;

import com.ccw.common.Result;
import com.ccw.entity.User;
import com.ccw.service.UserService;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @author xixiw
     * @time 2024/5/21 💕 16:24
     */
    @PostMapping("/add")
    public Result insertUser(@RequestBody User user){
        userService.insertUser(user);
        return Result.success();
    }

    /**
     * 删除用户
     * @author xixiw
     * @time 2024/5/21 💕 16:24
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return Result.success();
    }

    /**
     * 批量删除用户
     * @author xixiw
     * @time 2024/5/20 💕 23:21
     */
    @DeleteMapping("/delete/batch")
    //这里用@RequestBody而不是@PathVariable，因为批量传入的是数组为json格式
    public Result deleteBatch(@RequestBody List<Integer> ids){
        userService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改用户数据
     * @author xixiw
     * @time 2024/5/21 💕 12:55
     */
    @PutMapping("/update")
    public Result updateUserById(@RequestBody User user){
        userService.updateUserById(user);
        return Result.success();
    }

    /**
     * 根据id查询用户数据
     * @author xixiw
     * @time 2024/5/21 💕 13:24
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        User user = userService.selectById(id);
        return Result.success(user);
    }

    /**
     * 查询所有用户数据
     * @author xixiw
     * @time 2024/5/21 💕 13:30
     */
    @GetMapping("/selectAll")
    public Result selectAll(User user){
        List<User> userList = userService.selectAll(user);
        return Result.success(userList);
    }


    /**
     * 分页查询所有用户
     * @author xixiw
     * @time 2024/5/21 💕 16:05
     */
    @GetMapping("/selectPage")
    public Result selectPage(User user,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<User> page = userService.selectPage(user, pageNum, pageSize);
        return Result.success(page);
    }



}
