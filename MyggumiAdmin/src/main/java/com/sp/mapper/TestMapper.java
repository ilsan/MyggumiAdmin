package com.sp.mapper;

import com.sp.domain.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

	@Select("SELECT * FROM SYS_USR ")
    List<User> getUserList();
}
