package com.sp.mapper;

import com.sp.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleMapper {


    List<User> getUserList();
}
