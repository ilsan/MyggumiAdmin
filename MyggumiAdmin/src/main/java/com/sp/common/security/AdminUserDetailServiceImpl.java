package com.sp.common.security;

import com.sp.domain.AdminUserInfo;
import com.sp.mapper.SignInMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class AdminUserDetailServiceImpl implements UserDetailsService {

    private final SignInMapper signInMapper;

    @Autowired
    public AdminUserDetailServiceImpl(SignInMapper signInMapper) {
        this.signInMapper = signInMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String adminName) {

        log.debug("loadUserByUsername(adminName : {})", adminName);

        HashMap<String, Object> adminUserInfo = signInMapper.getAdminInfo(adminName);
        assert adminUserInfo != null;

        log.debug("adminUserInfo {},{},{}", adminUserInfo.get("ADMINID"), adminUserInfo.get("ADMINPASSWORD"), adminUserInfo.get("ADMINNAME"));

        return new AdminUserInfo(adminUserInfo.get("adminId").toString()
                , adminUserInfo.get("adminPassword").toString()
                , adminUserInfo.get("adminName").toString()
                , this.getAuthorization(adminUserInfo));
    }


    //SimpleGrantedAuthority 클래스는 권한을 저장하기 위한 구조는 단순하게 되어있다.
    // 예를들어 "ROLE_ADMIN"이란 문자열값을 생성자 파라미터로 넣어주는것으로 권한설정이 끝난다.
    private List<GrantedAuthority> getAuthorization(HashMap adminUserInfo) {
        List<GrantedAuthority> aurhorities = new ArrayList<>();
        aurhorities.add(new SimpleGrantedAuthority(adminUserInfo.get("role").toString()));
        return aurhorities;
    }

}
