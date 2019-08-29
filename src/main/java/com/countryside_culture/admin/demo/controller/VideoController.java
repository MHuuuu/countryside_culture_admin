package com.countryside_culture.admin.demo.controller;

import com.countryside_culture.admin.demo.entity.Video;
import com.countryside_culture.admin.demo.entity.Result;
import com.countryside_culture.admin.demo.entity.Video;
import com.countryside_culture.admin.demo.service.AdminUserService;
import com.countryside_culture.admin.demo.service.VideoService;
import com.countryside_culture.admin.demo.util.JsonWebTokenUtils;
import com.countryside_culture.admin.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//施工中

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/list")
    public Result getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit,
            @RequestHeader("X-Token") String token) {
        Integer id = JsonWebTokenUtils.getAppUID(token);
        if (id != null) {
            //adminUserService.getUserInfo(id);
            Page<Video> videoList = videoService.getVideoList(id, page, limit);
            Map<String, Object> map = new HashMap<>();
            map.put("total", videoList.getTotalElements());
            map.put("items", videoList.getContent());
            return ResultUtil.success(map);
        }
        return null;
    }

    @GetMapping("/auditList")
    public Result getAuditVideoList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit,
            @RequestHeader("X-Token") String token) {
        Integer id = JsonWebTokenUtils.getAppUID(token);
        // token权限身份验证
        Page<Video> videoList = videoService.getAuditVideoList(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("total", videoList.getTotalElements());
        map.put("items", videoList.getContent());
        return ResultUtil.success(map);
    }

    /**
     * 审核功能待定
     * @param id
     * @param remark
     * @param token
     * @return
     */
    @PostMapping("/audit")
    public Result auditVideo(
            @RequestParam int id,
            @RequestParam(required = false) String remark,
            @RequestHeader("X-Token") String token) {
        Integer authorId = JsonWebTokenUtils.getAppUID(token);
        // videoService.auditVideo(id,authorId, remark);
        return ResultUtil.success();
    }


    @GetMapping("/detail")
    public Result getVideoDetail(@RequestParam int id) {
        Video video = videoService.getDetail(id);
        return ResultUtil.success(video);
    }

    @GetMapping("/pv")
    public Result getPv(HttpServletResponse response) {

        return null;
    }

    @PostMapping("/submit")
    public Result submitVideo(
            @RequestBody Video video,
            @RequestHeader("X-Token") String token) {

        Integer id = JsonWebTokenUtils.getAppUID(token);
        videoService.submit(id, video);
        return ResultUtil.success();
    }

//    @PostMapping("/draft")
//    public Result draftVideo(
//            @RequestBody Video video,
//            @RequestHeader("X-Token") String token) {
//        Integer id = JsonWebTokenUtils.getAppUID(token);
//        // video.setAuthor(id);
//        videoService.draft(video);
//        return ResultUtil.success();
//    }


}
