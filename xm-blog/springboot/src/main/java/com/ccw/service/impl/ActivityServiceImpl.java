package com.ccw.service.impl;

import cn.hutool.core.date.DateUtil;
import com.ccw.common.Result;
import com.ccw.common.enums.LikesModuleEnum;
import com.ccw.common.enums.RoleEnum;
import com.ccw.entity.*;
import com.ccw.mapper.ActivityMapper;
import com.ccw.mapper.ActivitySignMapper;
import com.ccw.service.ActivityService;
import com.ccw.service.ActivitySignService;
import com.ccw.service.CollectService;
import com.ccw.service.LikesService;
import com.ccw.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 活动业务处理
 **/
@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    ActivitySignService activitySignService;

    @Resource
    LikesService likesService;

    @Resource
    CollectService collectService;

    /**
     * 新增
     */
    public void add(Activity activity) {
        activityMapper.insert(activity);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        activityMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activityMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Activity activity) {
        activityMapper.updateById(activity);
    }

    /**
     * 根据ID查询
     */
    public Activity selectById(Integer id) {
        Activity activity = activityMapper.selectById(id);
        this.setAct(activity,TokenUtils.getCurrentUser());

        //设置点赞和收藏数
        int likesCount = likesService.selectByFidAndModule(id, LikesModuleEnum.ACTIVITY.getValue());
        int collectCount = collectService.selectByFidAndModule(id, LikesModuleEnum.ACTIVITY.getValue());

        activity.setLikesCount(likesCount);
        activity.setCollectCount(collectCount);
        //用户是否点过赞
        Likes likes = likesService.selectUserLikes(id, LikesModuleEnum.ACTIVITY.getValue());
        activity.setIsLikes(likes != null);
        //用户是否收藏
        Collect collect = collectService.selectUserCollect(id, LikesModuleEnum.ACTIVITY.getValue());
        activity.setIsCollect(collect != null);

        return activity;
    }

    /**
     * 查询所有
     */
    public List<Activity> selectAll(Activity activity) {
        return  activityMapper.selectAll(activity);
    }

    /**
     * 分页查询
     */
    public PageInfo<Activity> selectPage(Activity activity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> list = activityMapper.selectAll(activity);
        PageInfo<Activity> pageInfo = PageInfo.of(list);
        List<Activity> activityList = pageInfo.getList();
        Account currentUser = TokenUtils.getCurrentUser();
        for (Activity act : activityList) {
            this.setAct(act,currentUser);
        }
        return pageInfo;
    }

    /**
     * 对活动额外的信息进行封装
     * @author xixiw
     * @time 2024/5/30 💕 20:38
     */
    private void setAct(Activity act ,Account currentUser){
        //判断日期是否截至
        act.setIsEnd(DateUtil.parseDate(act.getEnd()).isBefore(new Date()));
        //判断是否报名
        ActivitySign activitySign = activitySignService.selectByActivityIdAndUserId(act.getId(), currentUser.getId());
        act.setIsSign(activitySign != null );
    }

    /**
     * 热门活动
     * @author xixiw
     * @time 2024/5/26 💕 22:24
     */
    @Override
    public List<Activity> selectTop() {

            List<Activity> activityList = this.selectAll(null);
        activityList = activityList.stream().sorted((b1,b2) -> b2.getReadCount().compareTo(b1.getReadCount()))
                    .limit(2)
                    .collect(Collectors.toList());
            return activityList;
        }

    @Override
    public void updateReadCount(Integer activityId) {
        activityMapper.updateReadCount(activityId);
    }

    /**
     * 查询出用户报名的活动列表
     * @author xixiw
     * @time 2024/9/11 💕 21:13
     */
    public PageInfo<Activity> selectUser(Activity activity, Integer pageNum, Integer pageSize) {
        Account currentUser = TokenUtils.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getRole())) {
            activity.setUserId(currentUser.getId());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> list = activityMapper.selectUser(activity);
        PageInfo<Activity> pageInfo = PageInfo.of(list);
        List<Activity> activityList = pageInfo.getList();
        for (Activity act : activityList) {
            this.setAct(act, currentUser);
        }
        return pageInfo;
    }

}
