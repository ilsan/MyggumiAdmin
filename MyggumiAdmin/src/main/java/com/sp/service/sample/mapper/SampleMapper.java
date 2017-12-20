package com.sp.service.sample.mapper;

import java.util.List;
import java.util.Map;

public interface SampleMapper {

	public List<Map<String, Object>> selectListSample(Map<String, Object> paramMap) throws Exception;
	
	public Integer selectListSampleCnt(Map<String, Object> paramMap) throws Exception;
}
