package com.countryside_culture.admin.demo.entity;


import javax.persistence.*;

@Entity
@Table(name="activity")
public class Activity {
    @Id // 表明这个属性是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长
    private Integer id;
    @Column
    private String title;
    @Column
    private String endtime;
    @Column
    private String content;
    @Column
    private String eorganizer;
    @Column
    private String starttime;
    @Column
    private String status;
    @Column
    private String picture;
    @Column
    private String hits;

    public Activity() {
    }

    public Activity(String title, String endtime, String content, String eorganizer, String starttime, String status, String picture, String hits) {
        this.title = title;
        this.endtime = endtime;
        this.content = content;
        this.eorganizer = eorganizer;
        this.starttime = starttime;
        this.status = status;
        this.picture = picture;
        this.hits = hits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEorganizer() {
        return eorganizer;
    }

    public void setEorganizer(String eorganizer) {
        this.eorganizer = eorganizer;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }
}
