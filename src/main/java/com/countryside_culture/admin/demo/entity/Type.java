package com.countryside_culture.admin.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长
    private int id;
    @Column(nullable = false, unique = true)    // 不允许为空，属性唯一
    private int pid;
    @Column(nullable = false)
    private String name;
    @Column
    private String url;

    public Type(int pid, String name, String url) {
        this.pid = pid;
        this.name = name;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
