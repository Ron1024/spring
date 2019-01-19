package com.ron.springbootshiro.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "UserInfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userInfoId;

    /**
     * 姓名
     */
    private String name;
    /**
     * 登陆用户名
     */
    private String userName;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 校验盐值，添加用户时随机生成
     */
    private String salt;

    /**
     * 账户状态
     */
    private byte status;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户备注
     */
    private String userInfoDescription;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserinfoRole",joinColumns = {@JoinColumn(name = "userInfoId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    /**
     * 用户角色列表
     */
    List<Role> roles;

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getUserInfoDescription() {
        return userInfoDescription;
    }

    public void setUserInfoDescription(String userInfoDescription) {
        this.userInfoDescription = userInfoDescription;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
