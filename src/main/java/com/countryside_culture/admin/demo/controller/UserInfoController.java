package com.countryside_culture.admin.demo.controller;


import com.countryside_culture.admin.demo.entity.News;
import com.countryside_culture.admin.demo.entity.Result;
import com.countryside_culture.admin.demo.entity.UserInfo;
import com.countryside_culture.admin.demo.service.UserInfoService;
import com.countryside_culture.admin.demo.service.VideoService;
import com.countryside_culture.admin.demo.util.JsonWebTokenUtils;
import com.countryside_culture.admin.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/management")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/userList")
    public Result getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit) {
        Page<UserInfo> newsList = userInfoService.getUserList(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("total", newsList.getTotalElements());
        map.put("items", newsList.getContent());
        return ResultUtil.success(map);
    }


    @PostMapping("/lockUser")
    public Result lockUser(@RequestParam int userId) {
        userInfoService.lockUser(userId);
        return ResultUtil.success();
    }

    @PostMapping("/unlockUser")
    public Result unlockUser(@RequestParam int userId) {
        userInfoService.unlockUser(userId);
        return ResultUtil.success();
    }
}
