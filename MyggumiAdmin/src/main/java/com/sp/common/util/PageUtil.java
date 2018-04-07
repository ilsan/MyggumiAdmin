package com.sp.common.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class PageUtil {
	/** 
	 * @param request
	 * @param modelAndView
	 * @param map
	 * @param pageCnt 	한 페이지에 보여줄 게시글 수
	 * 
	 * */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void pageBar(HttpServletRequest request, ModelAndView modelAndView, Map map, int count) {
		int currentPage =  request.getParameter("currentPage") == null ? 1 : Integer.parseInt((String) request.getParameter("currentPage"));	// 현재 페이지 번호
		
		map.put("endNo", currentPage * count);
		map.put("startNo", ((currentPage - 1) * count + 1));
		modelAndView.addObject("currentPage", currentPage);
		modelAndView.addObject("requestURI", request.getRequestURI());
		
	}
}
