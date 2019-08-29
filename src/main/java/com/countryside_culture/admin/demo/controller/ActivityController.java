package com.countryside_culture.admin.demo.controller;


import com.countryside_culture.admin.demo.entity.Activity;
import com.countryside_culture.admin.demo.entity.News;
import com.countryside_culture.admin.demo.entity.Result;
import com.countryside_culture.admin.demo.service.ActivityService;
import com.countryside_culture.admin.demo.util.JsonWebTokenUtils;
import com.countryside_culture.admin.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/list")
    public Result getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit,
            @RequestHeader("X-Token") String token) {
        Integer id = JsonWebTokenUtils.getAppUID(token);
        if (id != null) {
            //adminUserService.getUserInfo(id);
            Page<Activity> newsList = activityService.getActivitysList(page, limit);
            Map<String, Object> map = new HashMap<>();
            map.put("total", newsList.getTotalElements());
            map.put("items", newsList.getContent());
            return ResultUtil.success(map);
        }
        return null;
    }

    @GetMapping("/detail")
    public Result getActivity(
            @RequestParam int id) {
        Activity activity=activityService.getDetail(id);
        return ResultUtil.success(activity);
    }

    @PostMapping("/create")
    public Result createActivity(
            @RequestBody Activity activity) {
        activityService.createActivity(activity);
        return ResultUtil.success();
    }

}
