package com.countryside_culture.admin.demo.controller;

import com.countryside_culture.admin.demo.entity.AdminUser;
import com.countryside_culture.admin.demo.entity.AdminUserCustom;
import com.countryside_culture.admin.demo.entity.Result;
import com.countryside_culture.admin.demo.service.AdminUserService;
import com.countryside_culture.admin.demo.util.JsonWebTokenUtils;
import com.countryside_culture.admin.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public Result login(HttpServletResponse response, @RequestParam String username, @RequestParam String password) {
        // System.out.println("z:进入登陆" + username + "--" + password);
        AdminUser au = adminUserService.login(username, password);
        Result result;
        if (au == null) {
            Map<String, String> map = new HashMap<String, String>();
            result = ResultUtil.error(60204, "wrong user info");
        } else {
            // 返回临时token，需要改进
            String token = JsonWebTokenUtils.createToken((long) au.getId());
            Map<String,String> map=new HashMap<>();
            map.put("token",token);
            result = ResultUtil.success(map);
        }
        return result;
    }

    // 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
    @GetMapping("/info")
    public Result getUserInfo(@RequestParam String token, HttpServletResponse response) {
        Integer id = JsonWebTokenUtils.getAppUID(token);
        Result result;
        if (id == null) {
            result = ResultUtil.error(50008, "Illegal token");
        } else {
            AdminUserCustom adminUserCustom = adminUserService.getUserInfo(id);
            if (adminUserCustom != null) {
                result = ResultUtil.success(adminUserCustom);
            } else {
                result = ResultUtil.error(60204, "wrong user info");
            }
        }
        return result;
    }

    @PostMapping("/logout")
    public Result logout() {
        return ResultUtil.success();
    }
}
