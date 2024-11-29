package com.ccw.entity;


import lombok.Data;

import java.util.Objects;

@Data
public class Blog {

    /** ID */
    private Integer id;
    /** 标题 */
    private String title;
    /** 内容 */
    private String content;
    /** 简介 */
    private String descr;
    /** 封面 */
    private String cover;
    /** 标签 */
    private String tags;
    /** 发布人ID */
    private Integer userId;
    /** 发布日期 */
    private String date;
    /** 浏览量 */
    private Integer readCount;
    private Integer categoryId;

    private String categoryName;
    private String userName;

    private Integer likesCount;

    //判断此博客是否被当前用户点过赞
    private Boolean userLike;


    private Integer collectCount;

    //判断此博客是否被当前用户收藏
    private Boolean userCollect;

    private User user;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(id, blog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

