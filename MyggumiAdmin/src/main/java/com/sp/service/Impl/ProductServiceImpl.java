package com.sp.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.mapper.ProductMapper;
import com.sp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper productMapper;

	/*@Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }*/
	
	// 페이지별 상품목록 조회
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> getProductList(Map map) {
        return productMapper.getProductList(map);
    }
    
    // 전체 상품 개수 조회
    public int getProductCount() {
    	return productMapper.getProductCount();
    }
}
