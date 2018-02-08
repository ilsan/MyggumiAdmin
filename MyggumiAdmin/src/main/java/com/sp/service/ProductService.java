	package com.sp.service;

import java.util.List;
import java.util.Map;

public interface ProductService {

	// 페이지별 상품목록 조회
    @SuppressWarnings("rawtypes")
	List<Map> getProductList(Map map);
    
    // 전체 상품 개수 조회
    int getProductCount();
}

