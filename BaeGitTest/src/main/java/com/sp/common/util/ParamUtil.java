package com.sp.common.util;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParamUtil {

	private static final Logger logger = LoggerFactory.getLogger(ParamUtil.class);
	
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> paramMap(HttpServletRequest request) throws Exception{
		Enumeration parameterNames = request.getParameterNames();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		int idx = 0;
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement().toString();
			String[] values = request.getParameterValues(key);
			String value="";
			
			for(int i=0; i<values.length; i++){
				value += values[i]+",";
			}
			
			value = value.substring(0, value.lastIndexOf(","));
			
			idx++;
			paramMap.put(key, value);
		}
		
		return paramMap;
	}
}
