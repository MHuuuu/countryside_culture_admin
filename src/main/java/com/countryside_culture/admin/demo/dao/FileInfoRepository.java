package com.countryside_culture.admin.demo.dao;

import com.countryside_culture.admin.demo.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository extends JpaRepository<FileInfo, Integer> {
}