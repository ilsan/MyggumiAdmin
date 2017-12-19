package com.sp.controller.sample;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.sp.common.util.ParamUtil;
import com.sp.service.sample.SampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:com/sp/config/db/context-*.xml"})
public class testController {
	
	@Autowired
	SampleService sampleService;
	
	@Test
	public void test1() throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		List<Map<String,Object>> resultList = null;
		resultList = sampleService.selectListSample(paramMap);
		assertTrue(resultList.size() > 0);
		System.out.println(resultList.size());
	}
}
