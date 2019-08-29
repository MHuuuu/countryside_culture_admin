package com.countryside_culture.admin.demo.service;

import com.countryside_culture.admin.demo.entity.Video;
import org.springframework.data.domain.Page;

public interface VideoService {
    public Page<Video> getVideoList(int id, int page, int limit);

    public Page<Video> getAuditVideoList(int page, int limit);

    public Video getDetail(int id);

    public void submit(Video video);

    // public void draft(Video video);

    public void auditArticle(int id, int authorId,String remark);
}
