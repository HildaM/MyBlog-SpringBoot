package com.quan.myblog.pojo;

import org.springframework.stereotype.Component;

/**
 * @ClassName: User
 * @Description: 用户实体类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/18 17:53
 */

@Component
public class User {
    // 主键
    private int uid;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 邮箱
    private String email;
    // 用户主页地址
    private String homeUrl;


    public User() {
    }

    public User(Integer uid, String username, String password, String email, String homeUrl) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.homeUrl = homeUrl;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", homeUrl='" + homeUrl + '\'' +
                '}';
    }
}
