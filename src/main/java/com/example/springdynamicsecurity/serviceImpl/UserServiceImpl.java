package com.example.springdynamicsecurity.serviceImpl;

import com.example.springdynamicsecurity.dao.UserInfoDao;
import com.example.springdynamicsecurity.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.getActiveUser(username);

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userInfo.getRole());
        User user = new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(grantedAuthority));
        return (UserDetails) user;
    }
}
