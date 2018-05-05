package com.sp.domain;

import lombok.Getter;
import lombok.Setter;



public enum CommonCodeInfo {
	
	USEYN("사용유무","000100"),
	PRODUCT_TYPE("상품타입","001000"),
	PRODUCT_CATEGORY("상품카테고리","001100"),
	;	
	
	/** 코드 정보 */
	@Getter @Setter
	private String info;
	
	/** 코드 값 */
	@Getter	@Setter
	private String code;
    
    private CommonCodeInfo(String info, String code) {
    	this.info = info;
    	this.code = code;
    }

    
}
