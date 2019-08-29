package com.countryside_culture.admin.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class AdminUser {
    @Id // 表明这个属性是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长
    private Integer id;
    @Column(nullable = false, unique = true)    // 不允许为空，属性唯一
    private String username;
    @Column
    private String nickname;
    @Column(nullable = false)
    private String password;
    @Column(name = "add_time")
    private String addTime;
    @Column
    private int status;
    @Column
    private String avatar;

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
}
