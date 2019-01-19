package com.ron.springbootshiro.dao;

import com.ron.springbootshiro.entities.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleDao extends CrudRepository<Role,Long> {

    Role findRoleByRoleId(Integer roleId);

}
