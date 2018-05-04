package com.sp.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sp.common.util.PageUtil;
import com.sp.domain.PaginationInfo;
import com.sp.domain.Product;
import com.sp.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired(required=true)
	private TestService testService;
	
//	 @RequestMapping("/admin/product/productList")
//	  public ModelAndView productList(ModelAndView modelAndView) {
//		 
//		log.info(">>>>>>>>>>> 접속 product/productList ");
//		
//		List<User> d = testServiceImpl.getUserList();
//		
//		log.info(d.size());
//		
//		modelAndView.addObject("userList", d);
//		modelAndView.setViewName("product/productList");
//	    return modelAndView;
//	  }
	
	 @RequestMapping("/product/productList")
	  public String productList(Model model, @ModelAttribute("paginationInfo") PaginationInfo pageInfo) {
		 
		log.info(">>>>>>>>>>> 접속 product/productList ");
		
		String url = "/admin/product/productList";
		
		model.addAttribute("productList", testService.productList(pageInfo));
		model.addAttribute("count", testService.productTotalCount());
		model.addAttribute("pageResult", PageUtil.getPageNavigation(pageInfo, url, null));

	    return "product/productList";
	  }
	 
	 @RequestMapping("/product/productDetail")
	 public ModelAndView productDetail(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 
		 log.info(">>>>>>>>>>> 접속 product/productDetail ");
		 
		 Product productDetail = testService.productDetail(productNo);
		 
		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productDetail");
		 return modelAndView;
	 }
	 
	 @RequestMapping("/product/productWrite")
	  public ModelAndView productWrite(Model model, ModelAndView modelAndView) {
		 
		log.info(">>>>>>>>>>> 접속 productWrite ");
		modelAndView.setViewName("product/productWrite");
	    return modelAndView;
	  }
	 
	 @RequestMapping("/product/productWriteAfter")
	 public String productWriteAfter(@ModelAttribute Product vo) {
		 testService.productInsert(vo);
		 log.info(">>>>>>>>>>> 상품등록 productInsert");
		 
		 return "redirect:/admin/product/productList";
	 }
	 
	 @RequestMapping("/product/productUpdate")
	 public ModelAndView productUpdate(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 
		 log.info(">>>>>>>>>>> 접속 productUpdate");
		 
		 Product productDetail = testService.productDetail(productNo);

		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productUpdate");
		 return modelAndView;
	 }
	 
	 @RequestMapping("/product/productUpdateAfter")
	 public String productUpdateAfter(@ModelAttribute Product vo, @RequestParam("updatePno") int productNo) {
		 vo.setProductNo(productNo);
		 int res = testService.productUpdate(vo);
		 if(res>0) {
			 log.info(">>>>>>>>>>> 상품수정 productUpdateAfter"); 
		 }else {
			 log.info(">>>>>>>>>>> 상품실패 productUpdateAfter");
		 }
		 return "redirect:/admin/product/productDetail?productNo="+productNo;
	 }
	 
	 @RequestMapping("/member/memberList")
	 public ModelAndView memberList(Model model, ModelAndView modelAndView) {
		 
		log.info(">>>>>>>>>>> 접속 memberList ");
		modelAndView.setViewName("member/memberList");
	    return modelAndView;
	  }
}
