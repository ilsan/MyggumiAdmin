package com.sp.common.security;

import com.sp.domain.AdminUserInfo;
import com.sp.mapper.SignInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AdminUserDetailServiceImpl implements UserDetailsService{

    private final SignInMapper signInMapper;

    @Autowired
    public AdminUserDetailServiceImpl(SignInMapper signInMapper) {
        this.signInMapper = signInMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String adminId) {

        ConcurrentHashMap adminUserInfo = signInMapper.getAdminInfo(adminId);

        return new AdminUserInfo(adminUserInfo.get("adminId").toString()
                    , adminUserInfo.get("adminPassword").toString()
                    , adminUserInfo.get("adminName").toString()
                    , this.getAuthorization(adminUserInfo));
    }

    private List<GrantedAuthority> getAuthorization(ConcurrentHashMap adminUserInfo) {
        List<GrantedAuthority> aurhorities = new ArrayList<GrantedAuthority>();
        aurhorities.add(new SimpleGrantedAuthority(adminUserInfo.get("role").toString()));
        return aurhorities;
    }

}
