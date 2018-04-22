package com.sp.mapper.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.sp.domain.Product;

public class ProductProvider {

	public String productInsert(@Param("vo") Product vo) {
		
		StringBuilder query = new StringBuilder();
		
		query.append(" INSERT INTO PRODUCT ");
		query.append(" (PRODUCT_NO,");
		query.append("  PRODUCT_NAME,");
		query.append("  PRODUCT_CONTENT,");
		query.append("  PRODUCT_TYPE,");
		query.append("  PRODUCT_DC,");
		query.append("  PRODUCT_PRICE,");
		query.append("  PRODUCT_CATEGORY,");
		query.append("  REG_USER,");
		query.append("  REG_DATE,");
		if(vo.getRegUser() == null) {
			query.append("  UPD_USER,");	
		}
		query.append("  UPD_DATE, ");
		query.append("  USE_YN)");
		query.append("  VALUES");
		query.append(" (PRODUCT_PRODUCT_NO.NEXTVAL, ");
		query.append("  #{vo.productName}, ");
		query.append("  #{vo.productContent}, ");
		query.append("  #{vo.productType},");
		query.append("  #{vo.productDc},");
		query.append("  #{vo.productPrice}, ");
		query.append("  #{vo.productCategory},");
		query.append("  #{vo.regUser}, ");
		query.append("  SYSDATE,");
		if(vo.getRegUser() == null) {
			query.append("  null,");	
		}
		query.append("  SYSDATE");
		query.append("  ,#{vo.useYn})");
		
		return query.toString();
	}
	
	public String productDetail(@Param("productNo") int productNo) {
		return new SQL() {{
				SELECT("*");
				FROM("PRODUCT");
				WHERE("PRODUCT_NO = #{productNo}");
			}}.toString();
	}
	
	public String productUpdate(@Param("vo") Product vo) {
		
		StringBuilder query = new StringBuilder();
		
		query.append("UPDATE PRODUCT SET ");
		query.append("PRODUCT_NAME=#{vo.productName}");
		query.append(",PRODUCT_TYPE=#{vo.productType}");
		query.append(",PRODUCT_CATEGORY=#{vo.productCategory}");
		query.append(",PRODUCT_PRICE=#{vo.productPrice}");
		query.append(",PRODUCT_DC=#{vo.productDc}");
		query.append(",USE_YN=#{vo.useYn}");
		query.append(",PRODUCT_CONTENT=#{vo.productContent}");
		query.append("WHERE PRODUCT_NO = #{vo.productNo}");
		
		return query.toString();
	}
}
