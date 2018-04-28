package com.sp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.domain.Product;
import com.sp.domain.User;
import com.sp.mapper.ProductMapper;
import com.sp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper testMapper;
	 
	@Override
	public List<User> getUserList() {
		
		return testMapper.getUserList();
	}

	@Override
	public int productInsert(Product vo) {

		return testMapper.productInsert(vo);
	}

	@Override
	public List<Product> productList() {
		
		return testMapper.productList();
	}

	@Override
	public Product productDetail(int productNo) {
		
		return testMapper.productDetail(productNo);
	}

	@Override
	public int productUpdate(Product vo) {

		return testMapper.productUpdate(vo);
	}
	
    
}
