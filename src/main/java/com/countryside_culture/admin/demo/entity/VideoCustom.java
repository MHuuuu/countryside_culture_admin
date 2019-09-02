package com.countryside_culture.admin.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

public class VideoCustom implements Serializable {
    private Integer id;
    private String title;
    private String publishTime;
    private int status;

    public VideoCustom(){}

    public VideoCustom(Integer id,String title, String publishTime, int status) {
        this.id=id;
        this.title = title;
        this.publishTime = publishTime;
        this.status = status;
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
}
