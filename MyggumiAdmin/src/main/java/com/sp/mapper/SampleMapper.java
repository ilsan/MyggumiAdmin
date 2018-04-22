package com.sp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sp.domain.User;

@Repository
public interface SampleMapper {


    List<User> getUserList();
}
