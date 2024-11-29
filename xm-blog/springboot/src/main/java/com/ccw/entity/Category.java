package com.ccw.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *@title 博客分类
 *@author xixiw
 *@version 1.0
 *@create 2024/5/22 💕 0:48
 */

public class Category {

        /** ID */
        private Integer id;
        /** 分类名称 */
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

}
