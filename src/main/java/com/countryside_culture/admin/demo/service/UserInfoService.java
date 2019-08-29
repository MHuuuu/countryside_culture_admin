package com.countryside_culture.admin.demo.service;

import com.countryside_culture.admin.demo.entity.AdminUser;
import com.countryside_culture.admin.demo.entity.AdminUserCustom;
import com.countryside_culture.admin.demo.entity.UserInfo;
import org.springframework.data.domain.Page;

public interface UserInfoService {

    UserInfo findUserById(int id);

    Page<UserInfo> getUserList(int page, int limit);

    void lockUser(int id);

    void unlockUser(int id);
}
