package com.ccw.service;

import com.ccw.entity.ActivitySign;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ActivitySignService {
    void add(ActivitySign activitySign);
    ActivitySign selectByActivityIdAndUserId(Integer actId, Integer userId);
    PageInfo<ActivitySign> selectPage(ActivitySign activitySign, Integer pageNum, Integer pageSize);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);


}
