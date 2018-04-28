package com.sp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import com.sp.domain.Product;
import com.sp.domain.User;

@Mapper
public interface TestMapper {
	
	@Select("SELECT * FROM SYS_USR")
    List<User> getUserList();
	
	@InsertProvider(type = productProvider.class , method = "productInsert")
	int productInsert(@Param("vo") Product vo);
	
	
	class productProvider{
		
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
	
	@Select( "SELECT\n" + 
			"    AAA.*\n" + 
			"FROM(\n" + 
			"    SELECT\n" + 
			"        COUNT(*) OVER() AS TOTAL_COUNT,\n" + 
			"        AA.*\n" + 
			"    FROM(\n" + 
			"        SELECT\n" + 
			"            ROW_NUMBER() OVER (ORDER BY productNo DESC) RNUM,\n" + 
			"            productNo,\n" + 
			"            productName,\n" + 
			"            productDc,\n" + 
			"            productPrice \n" + 
			"        FROM PRODUCT\n" + 
			"     \n" + 
			"    ) AA\n" + 
			") AAA\n" + 
			"WHERE\n" + 
			"    AAA.RNUM BETWEEN #{startPage} AND #{endPage}\n")
	List<Product> productList(Map map);
	
	@SelectProvider(type=productProvider.class, method="productDetail")
	Product productDetail(@Param("productNo") int productNo);
	

//	@Select( "SELECT PRODUCT_NO "
//			+ "		,PRODUCT_NAME "
//			+ "		,PRODUCT_CONTENT "
//			+ "		,PRODUCT_TYPE "
//			+ "		,PRODUCT_DC "
//			+ "		,PRODUCT_PRICE "
//			+ "		,PRODUCT_CATEGORY "
//			+ "		,REG_USER "
//			+ "		,REG_DATE "
//			+ "		,UPD_USER "
//			+ "		,UPD_DATE "
//			+ "		,USE_YN "
//			+ "	FROM PRODUCT "
//			+ " WHERE PRODUCT_NO = #{productNo}" )
//	Product productDetail(int productNo);
	
	@UpdateProvider(type = productProvider.class, method="productUpdate")
	int productUpdate(@Param("vo") Product vo);


}

