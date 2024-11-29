package com.ccw.entity;

import lombok.Data;

import java.util.List;

@Data
public class Comment {

    /** ID */
    private Integer id;
    /** 内容 */
    private String content;
    /** 评论人 */
    private Integer userId;
    /** 父级ID */
    private Integer pid;
    /** 根节点ID */
    private Integer rootId;
    /** 评论时间 */
    private String time;


    /** 博客ID */
    private Integer fid;

    private String module;

    private String userName;

    //用户投票
    private String avatar;

    //子回复
    private List<Comment> children;

    //回复的用户名称
    private String replyUser;


}
