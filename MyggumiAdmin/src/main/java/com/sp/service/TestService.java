	package com.sp.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sp.domain.Product;
import com.sp.domain.User;

@Mapper
public interface TestService {

	 List<User> getUserList();
	 int productInsert(Product vo);
	 List<Product> productList();
	 Product productDetail(int productNo);
	 int productUpdate(Product vo);
}
