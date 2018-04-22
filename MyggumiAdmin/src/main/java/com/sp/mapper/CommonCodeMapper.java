/**
 * 
 */
package com.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sp.domain.CommonCode;

/**
 * @author ShipJH
 * 공통코드 Mapper
 */

@Mapper
public interface CommonCodeMapper {

	@Select("  SELECT * "
			+ "  FROM COMMON_CD "
			+ " WHERE COM_CD_REF = #{code}")
	List<CommonCode> findByCode(String code);

}
