package com.ron.springbootshiro.service;

import com.ron.springbootshiro.common.domain.Tree;
import com.ron.springbootshiro.entities.Permission;


public interface PermissionService {
    Permission getPermissionByPermissionId(Integer permissionId);

    Tree<Permission> getPermissionsByUserName(String userName);
}
