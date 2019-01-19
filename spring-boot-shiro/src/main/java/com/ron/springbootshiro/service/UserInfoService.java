package com.ron.springbootshiro.service;

import com.ron.springbootshiro.entities.UserInfo;

public interface UserInfoService {

    UserInfo getUserInfoByUserName(String userName);
}
