package com.sp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.domain.CommonCode;
import com.sp.domain.CommonCodeInfo;
import com.sp.mapper.CommonCodeMapper;
import com.sp.service.CommonCodeService;

/**
 * @author ShipJH
 * 공통코드를 가져온다.
 */
@Service
public class CommonCodeServiceImpl implements CommonCodeService{

	@Autowired CommonCodeMapper commonCodeMapper;
	
	@Override
	public List<CommonCode> findByCode(String code) {
		return commonCodeMapper.findByCode(code);
	}


}
