package com.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.sp.domain.PaginationInfo;
import com.sp.domain.Product;
import com.sp.domain.User;
import com.sp.domain.form.ProductForm;
import com.sp.mapper.provider.ProductProvider;

@Mapper
public interface ProductMapper {
	
	@Select("SELECT * FROM SYS_USR")
    List<User> getUserList();
	
	@InsertProvider(type = ProductProvider.class , method = "productInsert")
	int productInsert(@Param("vo") ProductForm vo);
	
	@SelectProvider(type=ProductProvider.class, method="productList")
	List<Product> productList(PaginationInfo pageInfo);
	
	@Select("SELECT COUNT(*) FROM PRODUCT")
	int productTotalCount();

	@SelectProvider(type=ProductProvider.class, method="productDetail")
	Product productDetail(@Param("productNo") int productNo);
	
	@UpdateProvider(type = ProductProvider.class, method="productUpdate")
	int productUpdate(@Param("vo") Product vo);

}

