package com.sp.mapper;

import com.sp.domain.Product;
import com.sp.domain.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.junit.experimental.theories.FromDataPoints;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Mapper
public interface TestMapper {
	
	@Select("SELECT * FROM SYS_USR")
    List<User> getUserList();
	
	@Insert("INSERT INTO "
			+ "(PRODUCT_PRODUCTNO,PRODUCT_NAME,PRODUCT_CONTENT,"
			+ "PRODUCT_TYPE,PRODUCT_DC,PRODUCT_PRICE,PRODUCT_CATEGORY,REG_USER,"
			+ "REG_DATE,UPD_USER,UPD_DATE,USE_YN)"
			+ " VALUES"
			+ "(PRODUCT_PRODUCT_NO.NEXTVAL,#{vo.productName},"
			+ "#{vo.productContent},#{vo.productType},#{vo.productDc},"
			+ "#{vo.productPrice},#{vo.productCategory},#{vo.regUser},"
			+ "SYSDATE,null,SYSDATE,#{vo.useYn})")
	int productInsert(@Param("vo") Product vo);
	
}

