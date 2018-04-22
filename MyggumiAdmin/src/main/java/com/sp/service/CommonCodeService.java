package com.sp.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sp.domain.CommonCode;

/**
 * @author ShipJH
 * 공통코드를 불러온다.
 */
@Mapper
public interface CommonCodeService {

	List<CommonCode> findByCode(String code);

}
