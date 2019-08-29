package com.countryside_culture.admin.demo.controller;

import com.countryside_culture.admin.demo.entity.News;
import com.countryside_culture.admin.demo.entity.Result;
import com.countryside_culture.admin.demo.service.AdminUserService;
import com.countryside_culture.admin.demo.service.NewsService;
import com.countryside_culture.admin.demo.util.JsonWebTokenUtils;
import com.countryside_culture.admin.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/list")
    public Result getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit,
            @RequestHeader("X-Token") String token) {
        Integer id = JsonWebTokenUtils.getAppUID(token);
        if (id != null) {
            //adminUserService.getUserInfo(id);
            Page<News> newsList = newsService.getNewsList(id, page, limit);
            Map<String, Object> map = new HashMap<>();
            map.put("total", newsList.getTotalElements());
            map.put("items", newsList.getContent());
            return ResultUtil.success(map);
        }
        return null;
    }

    @GetMapping("/auditList")
    public Result getAuditNewsList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit,
            @RequestHeader("X-Token") String token) {
        Integer id = JsonWebTokenUtils.getAppUID(token);
        // token权限身份验证
        Page<News> newsList = newsService.getAuditNewsList(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("total", newsList.getTotalElements());
        map.put("items", newsList.getContent());
        return ResultUtil.success(map);
    }

    @PostMapping("/audit")
    public Result auditArticle(
            @RequestParam int id,
            @RequestParam(required = false,name = "remark") String statusReason,
            @RequestHeader("X-Token") String token) {
        Integer auditorId = JsonWebTokenUtils.getAppUID(token);
        newsService.auditArticle(id,auditorId, statusReason);
        return ResultUtil.success();
    }


    @GetMapping("/detail")
    public Result getArticleDetail(@RequestParam int id) {
        News news = newsService.getDetail(id);
        return ResultUtil.success(news);
    }

    @GetMapping("/pv")
    public Result getPv(HttpServletResponse response) {

        return null;
    }

    @PostMapping("/submit")
    public Result submitArticle(
            @RequestBody News news) {
        newsService.submit(news);
        return ResultUtil.success();
    }

    @PostMapping("/draft")
    public Result draftArticle(
            @RequestBody News news,
            @RequestHeader("X-Token") String token) {
        Integer id = JsonWebTokenUtils.getAppUID(token);
        news.setEditorId(id);
        newsService.draft(news);
        return ResultUtil.success();
    }


}
