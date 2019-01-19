package com.ron.springdatajpa.dao;

import com.ron.springdatajpa.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {

    User findUserByEmail(String email);

}
