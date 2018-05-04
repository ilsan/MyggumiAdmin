package com.sp.domain;

import lombok.Data;

@Data
public class Product extends Common{

	private int productNo;
	private int rnum;
	private String productName;
	private String productContent;
	private String productType;
	private int productDc;
	private int productPrice;
	private int productCategory;
	private String useYn;
	
}
