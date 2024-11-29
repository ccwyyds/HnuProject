package com.ccw.service;

import com.ccw.entity.Activity;
import com.ccw.entity.Blog;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ActivityService {
    void add(Activity activity);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Activity activity);
    Activity selectById(Integer id);
    List<Activity> selectAll(Activity activity);
    PageInfo<Activity> selectPage(Activity activity, Integer pageNum, Integer pageSize);

    List<Activity> selectTop();

    void updateReadCount(Integer activityId);

    PageInfo<Activity> selectUser(Activity activity, Integer pageNum, Integer pageSize);

}
