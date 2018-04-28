package com.sp.mapper;

import com.sp.domain.Product;
import com.sp.domain.User;
import com.sp.mapper.provider.ProductProvider;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;
import org.junit.experimental.theories.FromDataPoints;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Mapper
public interface ProductMapper {
	
	@Select("SELECT * FROM SYS_USR")
    List<User> getUserList();
	
	@InsertProvider(type = ProductProvider.class , method = "productInsert")
	int productInsert(@Param("vo") Product vo);
	
	
	@Select( "SELECT PRODUCT_NO "
			+ "		,PRODUCT_NAME "
			+ "		,PRODUCT_CONTENT "
			+ "		,PRODUCT_TYPE "
			+ "		,PRODUCT_DC "
			+ "		,PRODUCT_PRICE "
			+ "		,PRODUCT_CATEGORY "
			+ "		,REG_USER "
			+ "		,REG_DATE "
			+ "		,UPD_USER "
			+ "		,UPD_DATE "
			+ "		,USE_YN "
			+ "	FROM PRODUCT "
			+ " ORDER BY PRODUCT_NO DESC " )
	List<Product> productList();
	
	@SelectProvider(type=ProductProvider.class, method="productDetail")
	Product productDetail(@Param("productNo") int productNo);
	
	@UpdateProvider(type = ProductProvider.class, method="productUpdate")
	int productUpdate(@Param("vo") Product vo);


}

