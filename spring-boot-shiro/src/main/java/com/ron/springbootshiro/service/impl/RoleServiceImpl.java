package com.ron.springbootshiro.service.impl;

import com.ron.springbootshiro.dao.RoleDao;
import com.ron.springbootshiro.entities.Role;
import com.ron.springbootshiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public Role getRoleByRoleId(Integer roleId) {
        return roleDao.findRoleByRoleId(roleId);
    }
}
