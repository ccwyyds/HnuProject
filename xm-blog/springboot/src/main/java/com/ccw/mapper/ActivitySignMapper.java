package com.ccw.mapper;

import com.ccw.entity.ActivitySign;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActivitySignMapper {

    void insert(ActivitySign activitySign);

    ActivitySign selectByActivityIdAndUserId(@Param("activityId") Integer actId, @Param("userId") Integer userId);


    List<ActivitySign> selectAll(ActivitySign activitySign);

    void deleteById(Integer id);
}
