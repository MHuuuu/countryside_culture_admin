package com.countryside_culture.admin.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 定义文件上传相关的类，代表文件的基础信息；另一个是Chunk，代表文件块。
 */
@Entity
@Table(name="file_info")
public class FileInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private String identifier;

    @Column(nullable = false)
    private Long totalSize;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String location;

    public FileInfo() {}

    public FileInfo(String filename, String identifier, Long totalSize, String type) {
        this.filename = filename;
        this.identifier = identifier;
        this.totalSize = totalSize;
        this.type = type;
    }

    public FileInfo(String filename, String identifier, Long totalSize, String type, String location) {
        this.filename = filename;
        this.identifier = identifier;
        this.totalSize = totalSize;
        this.type = type;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
