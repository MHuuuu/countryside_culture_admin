package com.countryside_culture.admin.demo.service.impl;

import com.countryside_culture.admin.demo.dao.VideoRepository;
import com.countryside_culture.admin.demo.entity.Video;
import com.countryside_culture.admin.demo.service.VideoService;
import com.countryside_culture.admin.demo.util.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService{
    @Resource
    private VideoRepository videoRepository;

    @Override
    @Transactional
    public Page<Video> getVideoList(int id, int page, int limit) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //默认从第零页开始
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return videoRepository.findAllByAuthorId(id, pageRequest);
    }

    @Override
    @Transactional
    public Page<Video> getAuditVideoList(int page, int limit) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //默认从第零页开始
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return videoRepository.findAllByStatusGreaterThan(0,pageRequest);
    }

    @Override
    @Transactional
    public Video getDetail(int id) {
        Optional<Video> video = videoRepository.findById(id);
        if (video != null) {
            return video.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void submit(int id,Video video) {
        video.setPublishTime(DateUtil.getCurrentDate());
        // if (news.getExamStatus()==0 || news.getExamStatus()==3)
        video.setStatus(1);
        video.setAuthorId(id);
        videoRepository.save(video);
    }

    @Override
    @Transactional
    public void auditArticle(int id, int authorId,String remark) {
        Video video=getDetail(id);
        boolean isPass= null == remark;
        if (isPass){
            video.setStatus(Video.Signal.PASS.ordinal());
        }else {
            video.setStatus(Video.Signal.FAIL.ordinal());
            video.setRemark(remark);
        }
        videoRepository.save(video);
    }
}
