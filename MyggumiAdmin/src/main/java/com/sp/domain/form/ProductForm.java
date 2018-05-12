/**
 * 
 */
package com.sp.domain.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

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

	@NotEmpty(message="상품 이름을 입력해주세요.")
	private String productName;
	
	private String productContent;
	private String productType;
	private Integer productDc;
	
	@NotNull(message="상품 가격을 입력해주세요.")
	private Integer productPrice;
	private String productCategory;
	private String useYn;
	private String typeNm;
	private String categoryNm;
	
}