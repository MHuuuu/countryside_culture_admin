package com.countryside_culture.admin.demo.service.impl;

import com.countryside_culture.admin.demo.dao.AdminUserRepository;
import com.countryside_culture.admin.demo.dao.NewsRepository;
import com.countryside_culture.admin.demo.entity.AdminUser;
import com.countryside_culture.admin.demo.entity.News;
import com.countryside_culture.admin.demo.service.NewsService;
import com.countryside_culture.admin.demo.util.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsRepository newsRepository;
    @Resource
    private AdminUserRepository adminUserRepository;

    @Transactional
    public Page<News> getNewsList(int id, int page, int limit) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //默认从第零页开始
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return newsRepository.findAllByEditorId(id, pageRequest);
    }


    @Transactional
    public Page<News> getAuditNewsList(int page, int limit) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //默认从第零页开始
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return newsRepository.findAllByExamStatusGreaterThan(0,pageRequest);
    }


    public News getDetail(int id) {
        Optional<News> news = newsRepository.findById(id);
        if (news != null) {
            return news.get();
        }
        return null;
    }

    @Transactional
    public void submit(News news) {
        news.setPublishTime(DateUtil.getCurrentDate());
        news.setLastestTime(DateUtil.getCurrentDate());
        // if (news.getExamStatus()==0 || news.getExamStatus()==3)
        news.setExamStatus(1);
        newsRepository.save(news);
    }

    @Transactional
    public void draft(News news) {
        news.setLastestTime(DateUtil.getCurrentDate());
        newsRepository.save(news);
    }

    @Transactional
    public void auditArticle(int id,int auditorId, String statusReason) {
        Optional<AdminUser> optional=adminUserRepository.findById(auditorId);
        AdminUser author=new AdminUser();
        if (optional.isPresent()) {
            author=optional.get();
        }

        News news=getDetail(id);
        boolean isPass;
        if((null == statusReason)){
            isPass=true;
        }else if(statusReason.length()==0){
            isPass=true;
        }else{
            isPass=false;
        }
        if (isPass){
            news.setExamStatus(News.Signal.PASS.ordinal());
        }else {
            news.setAuditor(author.getNickname());
            news.setAuditorId(auditorId);
            news.setExamStatus(News.Signal.FAIL.ordinal());
            news.setStatusReason(statusReason);
        }
        news.setLastestTime(DateUtil.getCurrentDate());
        newsRepository.save(news);
    }
}
