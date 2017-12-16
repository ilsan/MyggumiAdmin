package com.sp.service.sample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.service.sample.mapper.SampleMapper;

@Repository
public class SampleServiceImpl implements SampleService {

	private static final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);
	
	@Autowired
    private SqlSession sqlSession;
	
	@Override
	public List<Map<String, Object>> selectListSample(Map<String, Object> paramMap) throws Exception {
		
		List<Map<String, Object>> returnList = null;
		
			SampleMapper sampleMapper = sqlSession.getMapper(SampleMapper.class);
			returnList = sampleMapper.selectListSample(paramMap);
		
		return returnList;
	}

	@Override
	public Integer selectListSampleCnt(Map<String, Object> paramMap) throws Exception {
		Integer returnInteger = null;
		
		SampleMapper sampleMapper = sqlSession.getMapper(SampleMapper.class);
		returnInteger  = sampleMapper.selectListSampleCnt(paramMap);
		return returnInteger;
	}

}
