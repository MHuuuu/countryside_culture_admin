package com.countryside_culture.admin.demo.entity;

import java.util.List;

public class AdminUserCustom {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String addTime;
    private int status;
    private String avatar;
    //临时属性，为roles
    private String role;
    private List<String> roles;

    public AdminUserCustom(Integer id, String username, String nickname, String password, String addTime, int status, String avatar, String role) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.addTime = addTime;
        this.status = status;
        this.avatar = avatar;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AdminUserCustom{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname=" + nickname +
                ", password='" + password + '\'' +
                ", addTime='" + addTime + '\'' +
                ", status=" + status +
                ", avatar='" + avatar + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
