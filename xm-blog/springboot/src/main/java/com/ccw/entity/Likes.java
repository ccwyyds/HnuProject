package com.ccw.entity;

import lombok.Data;

/**
 * 点赞实体类
 * @author xixiw
 * @time 2024/5/27 💕 19:09
 */
@Data
public class Likes {
    private Integer id;
    private Integer fid;
    private Integer userId;
    private String module;


}
