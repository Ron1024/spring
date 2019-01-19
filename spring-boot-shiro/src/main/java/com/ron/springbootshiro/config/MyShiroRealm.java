package com.ron.springbootshiro.config;

import com.ron.springbootshiro.entities.UserInfo;
import com.ron.springbootshiro.service.PermissionService;
import com.ron.springbootshiro.service.RoleService;
import com.ron.springbootshiro.service.UserInfoService;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    RoleService roleService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从安全管理器中获取用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户角色信息
        Set<String> roleNamesSet = new HashSet<>();
        Set<Integer> roleIdsSet = new HashSet<>();
        userInfoService.getUserInfoByUserName(user.getUsername()).getRoles()
                .forEach(role -> roleNamesSet.add(role.getRoleName()));
        userInfoService.getUserInfoByUserName(user.getUsername()).getRoles()
                .forEach(role -> roleIdsSet.add(role.getRoleId()));
        simpleAuthorizationInfo.setRoles(roleNamesSet);
        //获取用户权限信息
        Set<String> permissionSet = new HashSet<>();
        roleIdsSet
                .forEach(roleid -> roleService.getRoleByRoleId(roleid).getPermissions()
                .forEach(permission -> permissionSet.add(permission.getPerms())));
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从认证信息中获取登陆用户名
        String userName = authenticationToken.getPrincipal().toString();
        //根据用户名获取用户信息
        UserInfo userInfo = userInfoService.getUserInfoByUserName(userName);
        if (userInfo == null){
            throw new UnknownAccountException("用户名不存在");
        }
        return new SimpleAuthenticationInfo(userName,userInfo.getPassword(),getName());
    }
}
