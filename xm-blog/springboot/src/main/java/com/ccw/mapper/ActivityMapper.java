package com.ccw.mapper;

import com.ccw.entity.Activity;

import java.util.List;

/**
 * 操作activity相关数据接口
 */
public interface ActivityMapper {

    /**
     * 新增
     * @author xixiw
     * @time 2024/5/23 💕 12:01
     */
    int insert(Activity activity);

    /**
     * 删除
     * @author xixiw
     * @time 2024/5/23 💕 12:01
     */
    int deleteById(Integer id);

    /**
     * 修改
     * @author xixiw
     * @time 2024/5/23 💕 12:01
     */
    int updateById(Activity activity);

    /**
     * 根据id查询
     * @author xixiw
     * @time 2024/5/23 💕 12:01
     */
    Activity selectById(Integer id);

    /**
     * 查询所有
     * @author xixiw
     * @time 2024/5/23 💕 12:01
     */
    List<Activity> selectAll(Activity activity);

    /**
     * 更新活动阅读量
     * @author xixiw
     * @time 2024/5/30 💕 22:30
     */
    void updateReadCount(Integer activityId);

    List<Activity> selectUser(Activity activity);
}