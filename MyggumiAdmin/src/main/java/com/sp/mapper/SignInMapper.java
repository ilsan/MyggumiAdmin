package com.sp.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public interface SignInMapper {

    HashMap<String, Object> getAdminInfo(String adminName);


}
