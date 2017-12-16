package com.sp.service.sample;

import java.util.List;
import java.util.Map;


public interface SampleService {
	
	List<Map<String, Object>> selectListSample(Map<String, Object> paramMap) throws Exception;
	
	Integer selectListSampleCnt(Map<String, Object> paramMap) throws Exception;

}
