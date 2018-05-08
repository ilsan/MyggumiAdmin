/**
 * 
 */
package com.sp.domain.form;

import com.sp.domain.Common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ShipJH
 *
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ProductForm extends Common {

	private String productName;
	private String productContent;
	private String productType;
	private Integer productDc;
	private Integer productPrice;
	private String productCategory;
	private String useYn;
	private String typeNm;
	private String categoryNm;
	
}