package com.ron.springbootshiro.dao;

import com.ron.springbootshiro.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PermissionDao extends JpaRepository<Permission,Long> {

    Permission findPermissionByPermissionId(Integer permissionId);


    @Query(value = "SELECT p.* FROM permission p WHERE p.type='menu' and p.permission_id in(\n" +
            "\tSELECT DISTINCT rp.permission_id from role_permission rp\n" +
            "\tLEFT JOIN role r on (rp.role_id = r.role_id)\n" +
            "\tLEFT JOIN userinfo_role ur on (ur.role_id = r.role_id)\n" +
            "\tLEFT JOIN user_info u on (u.user_info_id = ur.user_info_id)\n" +
            "\tWHERE u.user_name = ?1\n" +
            ") order by p.permission_id",nativeQuery = true)
    List<Permission> getPermissionsByUserName(String userName);
}
