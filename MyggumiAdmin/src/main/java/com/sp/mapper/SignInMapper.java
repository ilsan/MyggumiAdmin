package com.sp.mapper;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
@Repository
public interface SignInMapper {

    ConcurrentHashMap getAdminInfo(String userId);


}
