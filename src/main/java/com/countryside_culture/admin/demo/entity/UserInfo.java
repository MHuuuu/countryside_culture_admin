package com.countryside_culture.admin.demo.entity;

import javax.persistence.*;


@Entity
@Table(name="userinfo")
public class UserInfo {
    @Id // 表明这个属性是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长
    @Column(name = "user_id")
    private Integer id;
    @Column
    private String password;
    @Column(unique = true)    // 不允许为空，属性唯一
    private String username;
    @Column
    private String phone;
    @Column(name = "user_real_name")
    private String userRealName;
    @Column
    private String nickname;
    @Column(name = "last_login_time")
    private String lastLoginTime;
    @Column(name = "last_login_ip")
    private String lastLoginIp;
    @Column
    private String email;
    @Column
    private String picture;
    @Column
    private Integer status;

    public enum Signal {
        LOCK,UNLOCK
    }

    public UserInfo() {
    }

    public UserInfo(String password, String username, String phone, String userRealName, String nickname, String lastLoginTime, String lastLoginIp, String email, String picture, Integer status) {
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.userRealName = userRealName;
        this.nickname = nickname;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.email = email;
        this.picture = picture;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
