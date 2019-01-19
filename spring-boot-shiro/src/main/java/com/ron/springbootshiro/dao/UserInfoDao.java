package com.ron.springbootshiro.dao;

import com.ron.springbootshiro.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfo,Long> {

    UserInfo findUserInfoByUserName(String userName);

}
