	package com.sp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sp.domain.Product;
import com.sp.domain.User;

@Mapper
public interface TestService {

	 List<User> getUserList();
	 int productInsert(Product vo);
	 Map<String, Object> productList(String currentPage);
	 Product productDetail(int productNo);
	 int productUpdate(Product vo);
}
