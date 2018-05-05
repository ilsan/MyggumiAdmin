	package com.sp.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sp.domain.Product;
import com.sp.domain.User;
import com.sp.domain.form.ProductForm;

@Mapper
public interface ProductService {

	 List<User> getUserList();
	 int productInsert(ProductForm vo);
	 List<Product> productList();
	 Product productDetail(int productNo);
	 int productUpdate(Product vo);
}
