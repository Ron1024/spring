package com.ron.springbootshiro.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer permissionId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限描述
     */
    private String permissionDescription;

    /**
     * 权限地址
     */
    private String permissionUrl;

    /**
     * 权限父id
     */
    private Integer permissionParentId;

    /**
     * 权限排序
     */
    private int permissionSort;
    /**
     *  类型, 0=菜单,1=按钮
     */
    private String type;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 图标
     */
    private String icon;
    /**
     * 权限角色关联
     */
    @ManyToMany
    @JoinTable(name = "RolePermission", joinColumns = {@JoinColumn(name = "permissionId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    List<Role> roles;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public Integer getPermissionParentId() {
        return permissionParentId;
    }

    public void setPermissionParentId(Integer permissionParentId) {
        this.permissionParentId = permissionParentId;
    }

    public int getPermissionSort() {
        return permissionSort;
    }

    public void setPermissionSort(int permissionSort) {
        this.permissionSort = permissionSort;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
