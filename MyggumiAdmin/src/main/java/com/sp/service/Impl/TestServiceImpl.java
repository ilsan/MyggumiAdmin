package com.sp.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Map<String, Object> productList(String currentPage) {
		
		//testMapper.productList(map)
		return null;
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
