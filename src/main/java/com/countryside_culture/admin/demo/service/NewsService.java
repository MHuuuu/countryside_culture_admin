package com.countryside_culture.admin.demo.service;

import com.countryside_culture.admin.demo.dao.AdminUserRepository;
import com.countryside_culture.admin.demo.dao.NewsRepository;
import com.countryside_culture.admin.demo.entity.News;
import com.countryside_culture.admin.demo.util.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public interface NewsService {
    public Page<News> getNewsList(int id, int page, int limit);

    public Page<News> getAuditNewsList(int page, int limit);

    public News getDetail(int id);

    public void submit(News news);

    public void draft(News news);

    public void auditArticle(int id,int auditorId, String statusReason);
}
