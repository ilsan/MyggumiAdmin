package com.sp.mapper.provider;

import org.apache.ibatis.annotations.Param;

import com.sp.domain.PaginationInfo;
import com.sp.domain.Product;

public class ProductProvider {

	public String productList(PaginationInfo pageInfo) {
		
		StringBuilder query = new StringBuilder();
		
			/*query.append("SELECT A.PRODUCT_NO");
			query.append(",A.PRODUCT_NAME");
			query.append(",A.PRODUCT_CONTENT");
			query.append(",A.PRODUCT_TYPE");
			query.append(",A.PRODUCT_DC");
			query.append(",A.PRODUCT_PRICE");
			query.append(",A.PRODUCT_CATEGORY");
			query.append(",A.REG_USER");
			query.append(",A.REG_DATE");
			query.append(",A.UPD_USER");
			query.append(",A.UPD_DATE");
			query.append(",A.USE_YN");
			query.append(",B.COM_NM AS TYPE_NM");
			query.append(",C.COM_NM AS CATEGORY_NM");
			query.append(" FROM PRODUCT A");
			query.append(" INNER JOIN COMMON_CD B ON A.PRODUCT_TYPE=B.COM_CD");
			query.append(" 										AND A.PRODUCT_CATEGORY=B.COM_CD");
			query.append(" ORDER BY A.PRODUCT_NO DESC");*/
		
		 query.append("SELECT") ;
				query.append("    AAA.*") ;
				query.append("FROM("); 
				query.append("    SELECT"); 
				query.append("        AA.*"); 
				query.append("    FROM("); 
				query.append("        SELECT"); 
				query.append("            ROW_NUMBER() OVER (ORDER BY PRODUCT_NO DESC) RNUM,"); 
				query.append("            PRODUCT_NO,"); 
				query.append("            PRODUCT_NAME,"); 
				query.append("            PRODUCT_DC,"); 
				query.append("            PRODUCT_PRICE, ");
				query.append("            PRODUCT_TYPE, "); 
				query.append("            PRODUCT_CATEGORY, "); 
				query.append("			 REG_USER,"); 
				query.append("			 REG_DATE,"); 
				query.append("			 UPD_USER,"); 
				query.append("			 UPD_DATE,"); 
				query.append("			 USE_YN ");	
				query.append("        FROM PRODUCT");
			if(pageInfo.getSearchOption() != null) {	
				if(pageInfo.getSearchOption().equals("all")) {	
					query.append("        WHERE PRODUCT_NAME like '%'||#{keyword}||'%'");
					query.append("        OR PRODUCT_TYPE like '%'||#{keyword}||'%'");
					query.append("        OR PRODUCT_CATEGORY like '%'||#{keyword}||'%'");
				}else {
					query.append("        WHERE #{searchOption} like '%'||#{keyword}||'%'");
				}
			}
				query.append("    ) AA"); 
				query.append(") AAA"); 
				query.append(" WHERE"); 
				query.append(" AAA.RNUM BETWEEN #{firstRecordIndex} AND #{lastRecordIndex}");
			
		return query.toString();
	}
	
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
	
//	public String productDetail(@Param("productNo") int productNo) {
//		return new SQL() {{
//				SELECT("*");
//				FROM("PRODUCT");
//				WHERE("PRODUCT_NO = #{productNo}");
//			}}.toString();
//	}

	public String productDetail(@Param("productNo") int productNo) {
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT A.PRODUCT_NO");
		query.append(",A.PRODUCT_NAME");
		query.append(",A.PRODUCT_CONTENT");
		query.append(",A.PRODUCT_TYPE");
		query.append(",A.PRODUCT_DC");
		query.append(",A.PRODUCT_PRICE");
		query.append(",A.PRODUCT_CATEGORY");
		query.append(",A.REG_USER");
		query.append(",A.REG_DATE");
		query.append(",A.UPD_USER");
		query.append(",A.UPD_DATE");
		query.append(",A.USE_YN");
		query.append(",B.COM_NM AS TYPE_NM");
		query.append(",C.COM_NM AS CATEGORY_NM");
		query.append(" FROM PRODUCT A ");
		query.append(" INNER JOIN COMMON_CD B ON A.PRODUCT_TYPE=B.COM_CD");
		query.append(" INNER JOIN COMMON_CD C ON A.PRODUCT_CATEGORY=C.COM_CD");
		query.append(" WHERE A.PRODUCT_NO = #{productNo}");
		
		return query.toString();
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
