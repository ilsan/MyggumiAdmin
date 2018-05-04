	package com.sp.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sp.domain.PaginationInfo;
import com.sp.domain.Product;
import com.sp.domain.User;

@Mapper
public interface TestService {

	 public List<User> getUserList();
	 public int productInsert(Product vo);
	 public List<Product> productList(PaginationInfo pageInfo);
	 public int productTotalCount(); 
	 public Product productDetail(int productNo);
	 public int productUpdate(Product vo);
}
