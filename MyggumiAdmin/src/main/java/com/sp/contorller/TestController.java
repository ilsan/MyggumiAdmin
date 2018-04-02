package com.sp.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sp.domain.User;
import com.sp.service.Impl.TestServiceImpl;

@Controller
public class TestController {

	 @RequestMapping("admin/test/test")
	  public ModelAndView productList(Model model, ModelAndView modelAndView) {
		 
		 modelAndView.setViewName("test/testChoice");
		 
	    return modelAndView;
	  }
	 
	 @RequestMapping(value = "/admin/test/choice", method = RequestMethod.POST)
	  public ResponseEntity<String> productList2(Model model,  HttpServletRequest req) {
		 
		 req.getParameter("chkCnt");
		 
		 int intNum = (int)(Math.random()*1001);
		 String result = "??";
		 if(intNum<501) { //500 50%
			 result = "g";
		 }else if(intNum>501 && intNum<850) {// 35%
			 result = "b";
		 }else if(intNum>850 && intNum<950) { // 10%
			 result = "p";
		 }else if(intNum>950 && intNum<990) { // 0.3%
			 result = "y";
		 }else if(intNum>990 && intNum<1001) { // 0.1%
			 result = "o";
		 }
			 
		 return new ResponseEntity<String>(result, HttpStatus.OK);
	  }
}

///* 개     발 : baejaehyun
// * 완 료 일 : 2018.01.04
// * 수 정 자 : baejaehyun
// * 수 정 일 : 2018.01.04  
// * 내     용 : 기업/가맹점관리 -> 기업관리 -> 기업등록 -> 사업자번호 조회 ( ajax )
// */
//@RequestMapping(value = "/admin/member/memberSearchBizNo", method = RequestMethod.POST)
//@ResponseBody
//public ResponseEntity<HashMap<String, Object>> memberSearchBizNo(HttpServletRequest req, ModelMap model) {
//
//	String bizLcnsNo = req.getParameter("bizLcnsNo");
//	
//	List<Member> memberList = memberService.getSameBizNoMember(bizLcnsNo);
//	List<Mcht> mchtList = memberService.getSameBizMcht(bizLcnsNo);
//	HashMap<String, Object> resultMap = new HashMap();
//	resultMap.put("memberList", memberList);
//	resultMap.put("mchtList", mchtList);
//
//	ResponseEntity<HashMap<String, Object>> responseEntity = new ResponseEntity<>(resultMap, HttpStatus.OK);
//
//	return responseEntity;
//}
//
