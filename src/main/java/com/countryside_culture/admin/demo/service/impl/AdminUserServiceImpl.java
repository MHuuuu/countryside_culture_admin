package com.countryside_culture.admin.demo.service.impl;

import com.countryside_culture.admin.demo.entity.AdminUser;
import com.countryside_culture.admin.demo.dao.AdminUserRepository;
import com.countryside_culture.admin.demo.entity.AdminUserCustom;
import com.countryside_culture.admin.demo.service.AdminUserService;
import com.countryside_culture.admin.demo.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminUserServiceImpl implements AdminUserService{
    @Resource
    private AdminUserRepository adminUserRepository;

    //保存数据
    @Transactional
    public AdminUser login(String username,String password) {
        return adminUserRepository.findAdminUserByUsernameAndPassword(username, password);
    }

    @Transactional
    public AdminUserCustom getUserInfo(Integer id) {
        List<Object[]> objects= adminUserRepository.findAdminUserInfoById(id);
        List<AdminUserCustom> list;
        list=EntityUtils.castEntity(objects,AdminUserCustom.class);
        AdminUserCustom userInfo=list.get(0);
        List<String> roles=new ArrayList<>();
        for (AdminUserCustom ac:list){
            roles.add(ac.getRole());
        }
        userInfo.setRoles(roles);
        return userInfo;
    }

}
