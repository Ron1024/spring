package com.ron.springbootshiro.service.impl;

import com.ron.springbootshiro.common.domain.Tree;
import com.ron.springbootshiro.common.util.TreeUtil;
import com.ron.springbootshiro.dao.PermissionDao;
import com.ron.springbootshiro.dao.RoleDao;
import com.ron.springbootshiro.dao.UserInfoDao;
import com.ron.springbootshiro.entities.Permission;
import com.ron.springbootshiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    RoleDao roleDao;


    @Override
    public Permission getPermissionByPermissionId(Integer permissionId) {
        return permissionDao.findPermissionByPermissionId(permissionId);
    }

    @Override
    public Tree<Permission> getPermissionsByUserName(String userName) {
        List<Tree<Permission>> trees = new ArrayList<Tree<Permission>>();
        List<Permission> permissions  = permissionDao.getPermissionsByUserName(userName);
        permissions.forEach(permission -> {
            Tree<Permission> permissionTree = new Tree<>();
            permissionTree.setId(String.valueOf(permission.getPermissionId()));
            permissionTree.setIcon(permission.getIcon());
            permissionTree.setParentId(String.valueOf(permission.getPermissionParentId()));
            permissionTree.setText(permission.getPermissionName());
            permissionTree.setUrl(permission.getPermissionUrl());
            trees.add(permissionTree);
        });

        return TreeUtil.build(trees);
    }


}
