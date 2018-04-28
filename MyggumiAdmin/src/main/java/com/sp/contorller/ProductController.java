package com.sp.contorller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sp.domain.PaginationInfo;
import com.sp.domain.Product;
import com.sp.service.Impl.TestServiceImpl;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired(required=true)
	private TestServiceImpl testServiceImpl;
	
//	 @RequestMapping("/admin/product/productList")
//	  public ModelAndView productList(ModelAndView modelAndView) {
//		 
//		System.out.println(">>>>>>>>>>> 접속 product/productList ");
//		
//		List<User> d = testServiceImpl.getUserList();
//		
//		System.out.println(d.size());
//		
//		modelAndView.addObject("userList", d);
//		modelAndView.setViewName("product/productList");
//	    return modelAndView;
//	  }
	
	 @RequestMapping("/product/productList")
	  public String productList(Model model, @RequestParam("currentPage") String currentPage) {
		 
		System.out.println(">>>>>>>>>>> 접속 product/productList ");
		
		Map<String, Object> resultMap = testServiceImpl.productList(currentPage);
		
		model.addAttribute("paginationInfo", (PaginationInfo)resultMap.get("paginationInfo"));
		model.addAttribute("list", resultMap.get("result"));

	    return "product/productList";
	  }
	 
	 @RequestMapping("/product/productDetail")
	 public ModelAndView productDetail(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 
		 System.out.println(">>>>>>>>>>> 접속 product/productDetail ");
		 
		 Product productDetail = testServiceImpl.productDetail(productNo);
		 
		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productDetail");
		 return modelAndView;
	 }
	 
	 @RequestMapping("/product/productWrite")
	  public ModelAndView productWrite(Model model, ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 productWrite ");
		modelAndView.setViewName("product/productWrite");
	    return modelAndView;
	  }
	 
	 @RequestMapping("/product/productWriteAfter")
	 public String productWriteAfter(@ModelAttribute Product vo) {
		 testServiceImpl.productInsert(vo);
		 System.out.println(">>>>>>>>>>> 상품등록 productInsert");
		 
		 return "redirect:/admin/product/productList";
	 }
	 
	 @RequestMapping("/product/productUpdate")
	 public ModelAndView productUpdate(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 
		 System.out.println(">>>>>>>>>>> 접속 productUpdate");
		 
		 Product productDetail = testServiceImpl.productDetail(productNo);

		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productUpdate");
		 return modelAndView;
	 }
	 
	 @RequestMapping("/product/productUpdateAfter")
	 public String productUpdateAfter(@ModelAttribute Product vo, @RequestParam("updatePno") int productNo) {
		 vo.setProductNo(productNo);
		 int res = testServiceImpl.productUpdate(vo);
		 if(res>0) {
			 System.out.println(">>>>>>>>>>> 상품수정 productUpdateAfter"); 
		 }else {
			 System.out.println(">>>>>>>>>>> 상품실패 productUpdateAfter");
		 }
		 return "redirect:/admin/product/productDetail?productNo="+productNo;
	 }
	 
	 @RequestMapping("/member/memberList")
	 public ModelAndView memberList(Model model, ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 memberList ");
		modelAndView.setViewName("member/memberList");
	    return modelAndView;
	  }
}
