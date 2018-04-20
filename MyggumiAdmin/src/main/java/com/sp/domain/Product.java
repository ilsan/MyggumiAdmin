package com.sp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author ShipJH
 * 상품 VO
 */

@EqualsAndHashCode(callSuper=false)
@Data
public class Product extends Common{

	private int productNo;
	private String productName;
	private String productContent;
	private String productType;
	private int productDc;
	private int productPrice;
	private int productCategory;
	private String useYn;
	
}
