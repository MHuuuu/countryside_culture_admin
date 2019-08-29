package com.countryside_culture.admin.demo.service.impl;

import com.countryside_culture.admin.demo.dao.UserInfoRepository;
import com.countryside_culture.admin.demo.entity.AdminUser;
import com.countryside_culture.admin.demo.entity.UserInfo;
import com.countryside_culture.admin.demo.service.UserInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findUserById(int id) {
        Optional<UserInfo> optional=userInfoRepository.findById(id);
        UserInfo userInfo=new UserInfo();
        if (optional.isPresent()) {
            userInfo=optional.get();
        }
        return userInfo;
    }

    @Override
    public Page<UserInfo> getUserList(int page, int limit) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //默认从第零页开始
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return userInfoRepository.findAll(pageRequest);
    }

    @Override
    @Transactional
    public void lockUser(int id) {
        UserInfo userInfo=findUserById(id);
        userInfo.setStatus(UserInfo.Signal.LOCK.ordinal());
        userInfoRepository.save(userInfo);
    }

    @Override
    @Transactional
    public void unlockUser(int id) {
        UserInfo userInfo=findUserById(id);
        userInfo.setStatus(UserInfo.Signal.UNLOCK.ordinal());
        userInfoRepository.save(userInfo);
    }
}
