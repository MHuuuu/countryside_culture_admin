package com.countryside_culture.admin.demo.service;

import com.countryside_culture.admin.demo.entity.Video;
import com.countryside_culture.admin.demo.entity.VideoCustom;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VideoService {
    public Page<Video> getVideoList(int id, int page, int limit);

    public Page<Video> getAuditVideoList(int page, int limit);

    public Video getDetail(int id);

    public void submit(int id ,Video video);

    // public void draft(Video video);

    public void auditVideo(int id, int auditorId,String remark);
}
