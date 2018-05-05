package com.sp.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.sp.domain.PaginationInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author	윤지수
 * @since 	2018.04.24
 * 
 */

@Slf4j
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
	
	public PaginationInfo setPageInfo(PaginationInfo page, String pageUnit, String pageSize) {
		
		if(page == null) {
			page = new PaginationInfo();
			page.setCurrentPageNo(1);
		}else if(page.getCurrentPageNo() == 0) {
			page.setCurrentPageNo(1);
		}
		
		if (pageUnit != null){
			if (!pageUnit.equals("")){
				this.pageUnit = Integer.parseInt(pageUnit);
			}
		}
		
		if (pageSize != null){
			if (!pageSize.equals("")){
				this.pageSize = Integer.parseInt(pageSize);
			}
		}
		
		page.setRecordCountPerPage(this.pageUnit);
		page.setPageSize(this.pageSize);
		
		return page;
	}
	
	public void setPageInfo(PaginationInfo page) {
		
		if(page == null) {
			page = new PaginationInfo();
			page.setCurrentPageNo(1);
		}else if(page.getCurrentPageNo() == 0) {
			page.setCurrentPageNo(1);
		}
		
		page.setRecordCountPerPage(pageUnit);
		page.setPageSize(pageSize);
	}
	
	/*@SuppressWarnings("rawtypes")
	public Map getPageInfo(Map paramMap, PaginationInfo page) throws Exception {		
		paramMap = setPageInfo(paramMap, page);
		
		return paramMap;
	}*/
	
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
	
	public static String getPageNavigation(PaginationInfo pageInfo, String url, String linkString) {

        StringBuffer result = new StringBuffer();

        int page = pageInfo.getCurrentPageNo();			// 현재 페이지 번호
        int totalCount = pageInfo.getLastPageNo();		// 전체 페이지 수
        int pagePerPageSize = pageInfo.getPageSize();	// 페이지바에 보여줄 페이지 수
        int pageSize = (int) Math.ceil((double) page / pagePerPageSize);	// 현재 페이지 그룹 수
        int totalPageSize = 0;												// 전체 페이지 그룹 수
        		
        if(pageSize > 0 && totalCount > 0) {
            linkString = StringUtils.isEmpty(linkString) ? "?" : "?"+linkString+"&";
            
            int startPage = 1;

            if(totalCount != 0) {
                totalPageSize = (totalCount % pageSize > 0) ? 1 : 0;
                totalPageSize = totalPageSize + totalCount / pageSize;
                startPage = pageInfo.getFirstPageNoOnPageList();
            }

            int prevPage = (page - 1);
    		int nextPage = (page + 1);

    		/*if (page == totalCount) 	{
    			nextPage = totalCount;
    		}

    		if (prevPage == 0){
    			prevPage = 1;
    		}*/

            int endPage = pageInfo.getLastPageNoOnPageList();
            
            result.append("<nav style=\"text-align:center\"><ul class=\"pagination\" >\n");
            
            log.info("page : " + page +", prevPage : " + prevPage + ", nextPage : " + nextPage +", totalCount : " + totalCount + ", totalPageSize : " + totalPageSize);

            //처음
            if(1 < page) {
                result.append("\n <li><a href=\"" + url + linkString + "currentPageNo=1\" alt=\"처음페이지\"><span aria-hidden=\"true\">&lt;&lt;</span></a></li>\n");
            } else {
                result.append("\n <li><a href=\"#\" onclick=\"return false;\" alt=\"처음페이지\"><span aria-hidden=\"true\">&lt;&lt;</span></a></li>\n");
            }

            //이전페이지 그룹
            if(0 < prevPage) {
                result.append("\n <li><a href=\"" + url + linkString + "currentPageNo=" + prevPage + "\" alt=\"이전\">&lt;</a></li>\n");
            } else {
                result.append("\n <li><a href=\"#\" onclick=\"return false;\" alt=\"이전\">&lt;</a></li>\n");
            }

            for(int i=startPage; i <= endPage ; i++) {
                if(i == page) { // 현재페이지
                    result.append("\n <li class=\"active\"><a href=\"#\" >"+i+"<span class=\"sr-only\">(current)</span></a></li>\n");
                } else {
                    result.append("\n <li><a href=\""+url+linkString+"currentPageNo="+i+"\">"+i+"</a></li>\n");
                }
            }

            //다음페이지 그룹
            if(nextPage <= totalCount) {
                result.append("\n <li><a href=\"" + url + linkString + "currentPageNo=" + nextPage + "\" alt=\"다음\">&gt;</a></li>\n");
            } else {
                result.append("\n <li><a href=\"#\" onclick=\"return false;\" alt=\"다음\">&gt;</a></li>\n");
            }

            //마지막 페이지
            if(page < totalCount) {
                result.append("\n <li><a href=\"" + url + linkString + "currentPageNo=" + totalPageSize + "\" alt=\"마지막페이지\"><span aria-hidden=\"true\">&gt;&gt;</span></a></li>\n");
            } else {
                result.append("\n <li><a href=\"#\" onclick=\"return false;\" alt=\"마지막페이지\"><span aria-hidden=\"true\">&gt;&gt;</span></a></li>\n");
            }
            
            result.append("</ul></nav>");
        }

        return result.toString();
    }
}
