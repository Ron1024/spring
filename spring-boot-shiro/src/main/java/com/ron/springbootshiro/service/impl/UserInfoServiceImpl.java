package com.ron.springbootshiro.service.impl;

import com.ron.springbootshiro.dao.UserInfoDao;
import com.ron.springbootshiro.entities.UserInfo;
import com.ron.springbootshiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfoByUserName(String userName) {
        return userInfoDao.findUserInfoByUserName(userName);
    }
}
