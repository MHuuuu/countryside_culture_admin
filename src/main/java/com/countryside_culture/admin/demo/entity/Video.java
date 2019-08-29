package com.countryside_culture.admin.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private String url;
    @Column
    private String actor;

    @Column(name = "author_id")
    private Integer authorId;
    @Column
    private String author;

    @Column(name = "auditor_id")
    private Integer auditorId;
    @Column
    private String auditor;
    @Column
    private String picture;
    @Column
    private String remark;
    @Column(name = "play_num")
    private int playNum;
    @Column(name = "collect_num")
    private int collectNum;
    @Column(name = "lastest_time")
    private String lastestTime;
    @Column(name = "publish_time")
    private String publishTime;
    @Column
    private int status;
    @Column
    private int kind;
    @Column(name = "like_num")
    private int likeNum;


    @Column(name = "status_reason")
    private String statusReason;

    public enum Signal {
        DRAFT, ToAudit, PASS ,FAIL , CLOSE
    }

    public Video() {
    }

    public Video(String title, String url, String actor, Integer authorId, String author, Integer auditorId, String auditor, String picture, String remark, int playNum, int collectNum, String lastestTime, String publishTime, int status, int kind, int likeNum, String statusReason) {
        this.title = title;
        this.url = url;
        this.actor = actor;
        this.authorId = authorId;
        this.author = author;
        this.auditorId = auditorId;
        this.auditor = auditor;
        this.picture = picture;
        this.remark = remark;
        this.playNum = playNum;
        this.collectNum = collectNum;
        this.lastestTime = lastestTime;
        this.publishTime = publishTime;
        this.status = status;
        this.kind = kind;
        this.likeNum = likeNum;
        this.statusReason = statusReason;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Integer auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getLastestTime() {
        return lastestTime;
    }

    public void setLastestTime(String lastestTime) {
        this.lastestTime = lastestTime;
    }
}
