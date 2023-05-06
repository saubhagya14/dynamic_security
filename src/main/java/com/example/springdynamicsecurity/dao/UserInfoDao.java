package com.example.springdynamicsecurity.dao;

import com.example.springdynamicsecurity.model.UserInfo;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
    @Query(value = "select u from UserInfo u where u.userName=?1")
    public UserInfo getActiveUser(String userName);
}
