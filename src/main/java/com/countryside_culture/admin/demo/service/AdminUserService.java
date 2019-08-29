package com.countryside_culture.admin.demo.service;

import com.countryside_culture.admin.demo.dao.AdminUserRepository;
import com.countryside_culture.admin.demo.entity.AdminUser;
import com.countryside_culture.admin.demo.entity.AdminUserCustom;
import com.countryside_culture.admin.demo.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public interface AdminUserService {
    public AdminUser login(String username,String password);

    public AdminUserCustom getUserInfo(Integer id);

}
