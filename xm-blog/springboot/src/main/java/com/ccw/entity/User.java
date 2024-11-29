package com.ccw.entity;

import lombok.Data;

@Data
public class User extends Account {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String avatar;
    private String role;
    private String sex;
    private String phone;
    private String email;
    private String info;
    private String birth;
    private Integer blogCount;
    private Integer likeCount;
    private Integer collectCount;

}

