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

	@NotEmpty(message="Name Plz~~!")
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