package com.ccw.entity;

import lombok.Data;

@Data
public class Activity {

    /** ID */
    private Integer id;
    /** 活动名称 */
    private String name;
    /** 活动简介 */
    private String descr;
    /** 开始时间 */
    private String start;
    /** 结束时间 */
    private String end;
    /** 活动形式 */
    private String form;
    /** 活动地址 */
    private String address;
    /** 主办方 */
    private String host;
    /** 浏览量 */
    private Integer readCount;
    private String content;
    private String cover;

    //活动是否结束
    private Boolean isEnd;

    //活动是否报名
    private Boolean isSign;

    private Integer likesCount;
    private Integer collectCount;

    private Boolean isLikes;
    private Boolean isCollect;

    private Integer userId;

    public Boolean getIsLikes() {
        return isLikes;
    }

    public void setIsLikes(Boolean isLikes) {
        this.isLikes = isLikes;
    }

    public Boolean getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Boolean isCollect) {
        this.isCollect = isCollect;
    }

    public void setIsEnd(Boolean isEnd) {
        this.isEnd = isEnd;
    }

    public Boolean getIsEnd() {
        return isEnd;
    }

    public void setIsSign(Boolean isSign) {
        this.isSign = isSign;
    }

    public Boolean getIsSign() {
        return isSign;
    }


}