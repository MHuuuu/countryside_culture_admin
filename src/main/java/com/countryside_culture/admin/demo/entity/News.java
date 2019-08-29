package com.countryside_culture.admin.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="news")
public class News{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private String source;
    @Column(name = "is_original")
    private int isOriginal;
    @Column
    private String author;
    @Column(name = "editor_id")
    private int editorId;
    @Column
    private String editor;
    @Column(name = "auditor_id")
    private Integer auditorId;
    @Column
    private String auditor;
    @Column(name = "publish_time")
    private String publishTime;
    @Column(name = "lastest_time")
    private String lastestTime;
    @Column
    private String content;
    @Column
    private String picture;
    @Column(name = "is_hot")
    private int isHot;
    @Column(name = "is_publish")
    private int isPublish;
    @Column(name = "click_num")
    private int clickNum;
    @Column(name = "exam_status")
    private int examStatus;
    @Column(name = "status_reason")
    private String statusReason;
    @Column
    private int kind;
    @Column
    private String remark;

    public enum Signal {
        DRAFT, ToAudit, PASS ,FAIL , CLOSE
    }


    public News(){}

    public News(String title, String source, int isOriginal, String author, int editorId, String editor, Integer auditorId, String auditor, String publishTime, String lastestTime, String content, String statusReason, String picture, int isHot, int isPublish, int clickNum, int examStatus, String statusReason1, int kind, String remark) {
        this.title = title;
        this.source = source;
        this.isOriginal = isOriginal;
        this.author = author;
        this.editorId = editorId;
        this.editor = editor;
        this.auditorId = auditorId;
        this.auditor = auditor;
        this.publishTime = publishTime;
        this.lastestTime = lastestTime;
        this.content = content;
        this.statusReason = statusReason;
        this.picture = picture;
        this.isHot = isHot;
        this.isPublish = isPublish;
        this.clickNum = clickNum;
        this.examStatus = examStatus;
        this.statusReason = statusReason1;
        this.kind = kind;
        this.remark = remark;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getLastestTime() {
        return lastestTime;
    }

    public void setLastestTime(String lastestTime) {
        this.lastestTime = lastestTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public int getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(int isPublish) {
        this.isPublish = isPublish;
    }

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }

    public int getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(int examStatus) {
        this.examStatus = examStatus;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(int isOriginal) {
        this.isOriginal = isOriginal;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", isOriginal=" + isOriginal +
                ", author='" + author + '\'' +
                ", editorId=" + editorId +
                ", editor='" + editor + '\'' +
                ", auditorId=" + auditorId +
                ", auditor='" + auditor + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", lastestTime='" + lastestTime + '\'' +
                ", content='" + content + '\'' +
                ", picture='" + picture + '\'' +
                ", isHot=" + isHot +
                ", isPublish=" + isPublish +
                ", clickNum=" + clickNum +
                ", examStatus=" + examStatus +
                ", statusReason='" + statusReason + '\'' +
                ", kind=" + kind +
                ", remark='" + remark + '\'' +
                '}';
    }


}
