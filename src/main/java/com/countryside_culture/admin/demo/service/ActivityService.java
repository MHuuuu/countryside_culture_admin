package com.countryside_culture.admin.demo.service;

import com.countryside_culture.admin.demo.entity.Activity;
import com.countryside_culture.admin.demo.entity.News;
import org.springframework.data.domain.Page;

public interface ActivityService {
    public Page<Activity> getActivitysList(int page, int limit);

    public Activity getDetail(int id);

    void createActivity(Activity activity);
}
