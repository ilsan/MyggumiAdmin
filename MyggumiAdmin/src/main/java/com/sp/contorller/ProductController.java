package com.sp.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sp.domain.Product;
import com.sp.service.Impl.TestServiceImpl;

/**
 * 
 * @author ShipJH
 * 상품 컨트롤러 
 */
@Controller
public class ProductController {

	@Autowired(required=true)
	private TestServiceImpl testServiceImpl;
	

	/**
	 * 20180421 배
	 * @param modelAndView
	 * @return 
	 * 상품 리스트 조회
	 */
	 @RequestMapping("/admin/product/productList")
	  public ModelAndView productList(ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 product/productList ");
		
		List<Product> productList = testServiceImpl.productList();
		
		System.out.println(productList.size());
		
		modelAndView.addObject("productList", productList);
		modelAndView.setViewName("product/productList");
	    return modelAndView;
	  }
	 
	 /**
	  * 
	  * @param modelAndView
	  * @param productNo - 상품번호
	  * @return
	  * 
	  */
	 @RequestMapping("/admin/product/productDetail")
	 public ModelAndView productDetail(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 
		 System.out.println(">>>>>>>>>>> 접속 product/productDetail ");
		 
		 Product productDetail = testServiceImpl.productDetail(productNo);
		 
		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productDetail");
		 return modelAndView;
	 }
	 @RequestMapping("/admin/product/productWrite")
	  public ModelAndView productWrite(Model model, ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 productWrite ");
		modelAndView.setViewName("product/productWrite");
	    return modelAndView;
	  }
	 @RequestMapping("/admin/product/productWriteAfter")
	 public String productWriteAfter(@ModelAttribute Product vo) {
		 testServiceImpl.productInsert(vo);
		 System.out.println(">>>>>>>>>>> 상품등록 productInsert");
		 
		 return "redirect:/admin/product/productList";
	 }
	 @RequestMapping("/admin/product/productUpdate")
	 public ModelAndView productUpdate(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 
		 System.out.println(">>>>>>>>>>> 접속 productUpdate");
		 
		 Product productDetail = testServiceImpl.productDetail(productNo);

		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productUpdate");
		 return modelAndView;
	 }
	 @RequestMapping("/admin/product/productUpdateAfter")
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
	 @RequestMapping("/admin/member/memberList")
	  public ModelAndView memberList(Model model, ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 memberList ");
		modelAndView.setViewName("member/memberList");
	    return modelAndView;
	  }
}
