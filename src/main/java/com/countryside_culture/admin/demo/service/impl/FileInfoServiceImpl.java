package com.countryside_culture.admin.demo.service.impl;

import com.countryside_culture.admin.demo.dao.FileInfoRepository;
import com.countryside_culture.admin.demo.entity.FileInfo;
import com.countryside_culture.admin.demo.service.FileInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FileInfoServiceImpl implements FileInfoService {
    @Resource
    private FileInfoRepository fileInfoRepository;

    @Override
    public FileInfo addFileInfo(FileInfo fileInfo) {
        return fileInfoRepository.save(fileInfo);
    }
}