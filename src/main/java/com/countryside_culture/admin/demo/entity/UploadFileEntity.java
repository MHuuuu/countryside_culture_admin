package com.countryside_culture.admin.demo.entity;


import java.util.Date;

/**
 * @author 江西DJ烟仔
 *	@time 2018年6月18日 :上午12:57:05
 * @description 文件上传包装类，为util包下的DownloadKit和UploadKit
 */

public class UploadFileEntity {

    /**文件ID*/
    private Integer id;

    /**文件原名称*/
    private String origName;

    /**文件新名称*/
    private String newName;

    /**文件上传后服务器访问地址*/
    private String serverPath;

    /**文件大小*/
    private Double fileSize;

    /**文件MD5*/
    private String fileMd5;

    /**文件上传时间*/
    private Date uploadTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigName() {
        return origName;
    }

    public void setOrigName(String origName) {
        this.origName = origName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}

