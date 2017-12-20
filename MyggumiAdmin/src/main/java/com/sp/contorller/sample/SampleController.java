package com.sp.contorller.sample;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.common.util.ParamUtil;
import com.sp.service.sample.SampleService;


@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleService sampleService;

	
	@RequestMapping(value = "/sample")
	public String sample(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("=======SampleController=======sample Start");
			Map<String,Object> paramMap = ParamUtil.paramMap(request);
			
			List<Map<String,Object>> resultList = null;
			
			Integer resultCount = 0;
			
		try {
			
			resultList = sampleService.selectListSample(paramMap);
			resultCount = sampleService.selectListSampleCnt(paramMap);
			
			request.setAttribute("resultList", resultList);
			request.setAttribute("resultCount", resultCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/sample/sample";
	}
	
	/*배포테스트*/
	@RequestMapping(value = "/homeTest")
	public String homeTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("=======SampleController=======sample Start");
			Map<String,Object> paramMap = ParamUtil.paramMap(request);
			
			List<Map<String,Object>> resultList = null;
			
			Integer resultCount = 0;
			
		try {
			
			resultList = sampleService.selectListSample(paramMap);
			resultCount = sampleService.selectListSampleCnt(paramMap);
			
			request.setAttribute("resultList", resultList);
			request.setAttribute("resultCount", resultCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
}
