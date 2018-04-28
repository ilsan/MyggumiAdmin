package com.sp.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.sp.domain.PaginationInfo;

/**
 * 
 * @author	윤지수
 * @since 	2018.04.24
 * 
 */
public class PageUtil {
	
	@Autowired
	private int pageUnit = 10;
	private int pageSize = 10;
	
	public String setFirstPage(PaginationInfo page) throws Exception {
		String result = "";
		
		if ("0".equals(page.getFirstRecordIndex())){
			result = String.valueOf(page.getFirstRecordIndex());
		} else {
			result = String.valueOf(page.getFirstRecordIndex()+1);
		}
		
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map setPageInfo(Map paramMap, PaginationInfo page) throws Exception {		
		if ((String)paramMap.get("pageIndex") == null || "".equals((String)paramMap.get("pageIndex"))){
			paramMap.put("pageIndex", "1");
		}
		
		page.setCurrentPageNo(Integer.parseInt((String)paramMap.get("pageIndex")));
		
		if (paramMap.get("pageUnit") != null){
			if (!"".equals((String)paramMap.get("pageUnit"))){
				pageUnit = Integer.valueOf((String)paramMap.get("pageUnit"));
			}
		}
		
		page.setRecordCountPerPage(pageUnit);
		page.setPageSize(pageSize);
		
		paramMap.put("firstIndex", setFirstPage(page));
		paramMap.put("lastIndex", String.valueOf(page.getLastRecordIndex()));
		paramMap.put("recordCountPerPage", String.valueOf(page.getRecordCountPerPage()));
		
		return paramMap;
	}
	
	@SuppressWarnings("rawtypes")
	public Map getPageInfo(Map paramMap, PaginationInfo page) throws Exception {		
		paramMap = setPageInfo(paramMap, page);
		
		return paramMap;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setTotalCount(Map paramMap, PaginationInfo page) throws Exception {
		page.setTotalRecordCount((Integer)paramMap.get("CNT"));
		paramMap.put("lastPage", String.valueOf(page.getTotalPageCount()));
	}
	
	public void setTotalCount(int cnt, PaginationInfo page) throws Exception {
		page.setTotalRecordCount(cnt);
//		paramMap.put("lastPage", String.valueOf(page.getTotalPageCount()));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void getPage(int totCnt, Map reqMap, ModelMap model) throws Exception {
		
		int index = 1;
		int listCnt = 10;
		int pageCnt = 10;
		
//		if ( reqMap.get("page_list_cnt") != null) {
//			listCnt = reqMap.get("page_list_cnt");
//		}
	    
	    if(reqMap.containsKey("pageIndex") && !"".equals((String)reqMap.get("pageIndex"))) 
			index = Integer.valueOf( (String)reqMap.get("pageIndex") );
	    if(reqMap.containsKey("pageCnt") && !"".equals((String)reqMap.get("pageCnt")))
	    	listCnt = Integer.valueOf( (String)reqMap.get("pageCnt") );
	    PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo( index );
		paginationInfo.setRecordCountPerPage(listCnt);
		paginationInfo.setPageSize(pageCnt);
		
		reqMap.put("firstIndex",         paginationInfo.getFirstRecordIndex()   );
		reqMap.put("lastIndex",          paginationInfo.getLastRecordIndex()    );
		reqMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage() );
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("paginationInfo", paginationInfo);
	}
	
	
	/**
	 * 페이지 적용
	 * @param totCnt
	 * @param reqMap
	 * @param model
	 * @param listCnt
	 * @param pageCnt
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void getPageBoard(int totCnt, Map reqMap, ModelMap model, int listCnt, int pageCnt ) throws Exception {
		
		int index = 1;
//		int listCnt = 5;
//		int pageCnt = 1;
		
	    if(reqMap.containsKey("pageIndex") && !"".equals((String)reqMap.get("pageIndex"))) 
			index = Integer.valueOf( (String)reqMap.get("pageIndex") );
	    
	    PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo( index );
		paginationInfo.setRecordCountPerPage(listCnt);
		paginationInfo.setPageSize(pageCnt);
		
		reqMap.put("firstIndex",         paginationInfo.getFirstRecordIndex()   );
		reqMap.put("lastIndex",          paginationInfo.getLastRecordIndex()    );
		reqMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage() );
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("paginationInfo", paginationInfo);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void getJqGridJsonValPage(int records, Map paramMap, ModelMap model) throws Exception {
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(Integer.parseInt((String)paramMap.get("page")));
		paginationInfo.setRecordCountPerPage(Integer.parseInt((String)paramMap.get("rows")));
		paginationInfo.setPageSize(Integer.parseInt((String)paramMap.get("rows")));
		
		paramMap.put("firstIndex", paginationInfo.getFirstRecordIndex());
		paramMap.put("lastIndex", paginationInfo.getLastRecordIndex());
		paramMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage());
		
		int rownum = (Integer.parseInt((String)paramMap.get("rows")));
    	
    	int total_add = 0;
    	if((records % rownum) > 0)
    		total_add = 1;
    	
    	int total = (records / rownum) + total_add;
    	
    	model.put("page", paramMap.get("page"));
    	model.put("total", total);
    	model.put("records", records);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map selectPagingList(String currentPage){
	     
	    Map<String,Object> map = new HashMap<>();
	    map.put("currentPageNo", currentPage);
	    PaginationInfo paginationInfo = null;
	     
	    if(map.containsKey("currentPageNo") == false || StringUtils.isEmpty(map.get("currentPageNo")) == true)
	        map.put("currentPageNo","1");
	     
	    paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(Integer.parseInt(map.get("currentPageNo").toString()));
	    if(map.containsKey("PAGE_ROW") == false || StringUtils.isEmpty(map.get("PAGE_ROW")) == true){
	        paginationInfo.setRecordCountPerPage(15);
	    }
	    else{
	        paginationInfo.setRecordCountPerPage(Integer.parseInt(map.get("PAGE_ROW").toString()));
	    }
	    paginationInfo.setPageSize(10);
	     
	    int start = paginationInfo.getFirstRecordIndex();
	    int end = start + paginationInfo.getRecordCountPerPage();
	    map.put("START",start+1);
	    map.put("END",end);
	     
	    Map<String,Object> returnMap = new HashMap<String,Object>();
	    List<Map<String, Object>> list = null;
	     
	    if(list.size() == 0){
	        map = new HashMap<String,Object>();
	        map.put("TOTAL_COUNT",0); 
	        list.add(map);
	         
	        if(paginationInfo != null){
	            paginationInfo.setTotalRecordCount(0);
	            returnMap.put("paginationInfo", paginationInfo);
	        }
	    }
	    else{
	        if(paginationInfo != null){
	            paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).get("TOTAL_COUNT").toString()));
	            returnMap.put("paginationInfo", paginationInfo);
	        }
	    }
	    returnMap.put("result", list);
	    return returnMap;
	}

}
