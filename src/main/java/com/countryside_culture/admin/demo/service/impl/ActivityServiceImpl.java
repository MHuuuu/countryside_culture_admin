package com.countryside_culture.admin.demo.service.impl;

import com.countryside_culture.admin.demo.dao.ActivityRepository;
import com.countryside_culture.admin.demo.entity.Activity;
import com.countryside_culture.admin.demo.entity.News;
import com.countryside_culture.admin.demo.service.ActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService{
    @Resource
    private ActivityRepository activityRepository;

    @Override
    public Page<Activity> getActivitysList(int page, int limit) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //默认从第零页开始
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return activityRepository.findAll(pageRequest);
    }

    @Override
    public Activity getDetail(int id) {
        Optional<Activity> activity = activityRepository.findById(id);
        if (activity != null) {
            return activity.get();
        }
        return null;
    }

    @Override
    public void createActivity(Activity activity) {
        activityRepository.save(activity);
    }


}
