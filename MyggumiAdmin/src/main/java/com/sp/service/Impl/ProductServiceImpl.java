package com.sp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.domain.PaginationInfo;
import com.sp.domain.Product;
import com.sp.domain.User;
import com.sp.domain.form.ProductForm;
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
	public int productInsert(ProductForm vo) {

		return testMapper.productInsert(vo);
	}

	@Override
	public List<Product> productList(PaginationInfo pageInfo) {
		
		return testMapper.productList(pageInfo);
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
