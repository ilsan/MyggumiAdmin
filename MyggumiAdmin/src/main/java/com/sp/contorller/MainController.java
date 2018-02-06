package com.sp.contorller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView main(Model model, ModelAndView modelAndView) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>메인페이지 접속");
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	@RequestMapping("/include/page")
	public String page(HttpServletRequest request) {

		int pageCnt = 10; //Integer.parseInt(request.getParameter("pageCnt"));			// 페이지 당 게시글 수
		int pageNaviCnt = 10; //Integer.parseInt(request.getParameter("pageNaviCnt"));	// 페이지바의 페이지번호 표시 개수
		
		try{
			int totalCnt = Integer.parseInt(request.getParameter("totalCnt"));			// 전체 게시글 수
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));	// 현재 페이지번호	

	        int naviCnt = totalCnt / pageCnt;			// 총 페이지 바 개수
	        if ( totalCnt % pageCnt > 0 ) {
	        	naviCnt++;
	        }
	        
			int startNo = currentPage / pageNaviCnt;	// 현재 페이지 바의 첫번째 페이지 번호
			if ( currentPage % pageNaviCnt > 0 ) {
				startNo++;
			}
			
			// 최초 접속한 경우
			if ( startNo == 0 ) {
				startNo = 1;
			}
			startNo = (startNo * pageNaviCnt) - (pageNaviCnt - 1);
			
			int endNo = startNo + pageNaviCnt - 1;
			if ( endNo > naviCnt ) {
				endNo = naviCnt;
			}

			request.setAttribute("maxPageNo", naviCnt);
			request.setAttribute("startPageNo", startNo);
			request.setAttribute("endPageNo", endNo);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("naviCnt", pageNaviCnt);

			request.setAttribute("pageYN", "Y");
		}catch(Exception e){
			request.setAttribute("pageYN", "N");
		}
		
		return "include/page";
	}
}
