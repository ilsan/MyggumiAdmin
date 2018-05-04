package com.sp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.domain.PaginationInfo;
import com.sp.domain.Product;
import com.sp.domain.User;
import com.sp.mapper.TestMapper;
import com.sp.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestMapper testMapper;
	 
	@Override
	public List<User> getUserList() {
		
		return testMapper.getUserList();
	}

	@Override
	public int productInsert(Product vo) {

		return testMapper.productInsert(vo);
	}

	@Override
	public List<Product> productList(PaginationInfo pageInfo) {
		
		List<Product> productList =  testMapper.productList(pageInfo);
		return productList;
	}

	@Override
	public Product productDetail(int productNo) {
		
		return testMapper.productDetail(productNo);
	}

	@Override
	public int productUpdate(Product vo) {

		return testMapper.productUpdate(vo);
	}

	@Override
	public int productTotalCount() {
		return testMapper.productTotalCount();
	}
	
    
}
