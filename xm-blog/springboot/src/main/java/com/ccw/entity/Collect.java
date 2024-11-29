package com.ccw.entity;

import lombok.Data;

/**
 * 收藏模块
 * @author xixiw
 * @time 2024/5/27 💕 22:15
 */
@Data
public class Collect {
    private Integer id;
    private Integer fid;
    private Integer userId;
    private String module;
}
