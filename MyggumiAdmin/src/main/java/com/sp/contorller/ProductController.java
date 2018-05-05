package com.sp.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sp.domain.CommonCodeInfo;
import com.sp.domain.Product;
import com.sp.domain.form.ProductForm;
import com.sp.service.Impl.CommonCodeServiceImpl;
import com.sp.service.Impl.ProductServiceImpl;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author ShipJH
 * 상품 컨트롤러 
 */
@Controller
public class ProductController {

	@Autowired(required=true)
	private ProductServiceImpl productServiceImpl;
	
	@Autowired(required=true)
	private CommonCodeServiceImpl commonCodeServiceImpl;

	/**
	 * 20180421 배
	 * @param modelAndView
	 * @return 
	 * 상품 리스트 조회
	 */

	 @RequestMapping("/admin/product/productList")
	  public ModelAndView productList(ModelAndView modelAndView) {
		List<Product> productList = productServiceImpl.productList();
		modelAndView.addObject("productList", productList);
		modelAndView.setViewName("product/productList");
	    return modelAndView;
	  }
	 
//	 @RequestMapping("/admin/product/productList")
//	  public ModelAndView LoginYNproductList(ModelAndView modelAndView) {
//		List<Product> productList = productServiceImpl.productList();
//		modelAndView.addObject("productList", productList);
//		modelAndView.setViewName("product/productList");
//	    return modelAndView;
//	  }
	 
	 /**
	  * 
	  * @param modelAndView
	  * @param productNo - 상품번호
	  * @return
	  * 
	  */
	 @RequestMapping("/admin/product/productDetail")
	 public ModelAndView productDetail(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 Product productDetail = productServiceImpl.productDetail(productNo);
		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productDetail");
		 return modelAndView;
	 }
	 
	 
	 /**
	  * 
	  * @param modelAndView
	  * @param productNo - 상품번호
	  * @return 
	  * 
	  */
	 @RequestMapping("/admin/product/productWrite")
	  public ModelAndView productWrite(Model model, ModelAndView modelAndView) {
		modelAndView.addObject("productType", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
		modelAndView.addObject("productCategory", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
		modelAndView.setViewName("product/productWrite");
	    return modelAndView;
	  }
	 
	 
	 @RequestMapping(value="/admin/product/productWriteAfter", method=RequestMethod.POST)
	 public String productWriteAfter(@ModelAttribute ProductForm vo) {
		 
		 System.out.println(">>" + vo.getProductName());
		 
		 productServiceImpl.productInsert(vo);
		 return "redirect:/admin/product/productList";
	 }
	 
	 
	 
	 
	 @RequestMapping("/admin/product/productUpdate")
	 public ModelAndView productUpdate(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 Product productDetail = productServiceImpl.productDetail(productNo);
		 modelAndView.addObject("productType", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
		 modelAndView.addObject("productCategory", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productUpdate");
		 return modelAndView;
	 }
//	 @RequestMapping("/admin/product/productUpdateAfter")
	 @RequestMapping(value="/admin/product/productUpdateAfter" , method=RequestMethod.POST)
	 public String productUpdateAfter(@ModelAttribute Product vo, @RequestParam("updatePno") int productNo) {
		 vo.setProductNo(productNo);
		 int res = productServiceImpl.productUpdate(vo);
		 if(res>0) {
			 System.out.println(">>>>>>>>>>> 상품수정 productUpdateAfter"); 
		 }else {
			 System.out.println(">>>>>>>>>>> 상품실패 productUpdateAfter");
		 }
		 return "redirect:/admin/product/productDetail?productNo="+productNo;
	 }
	 @RequestMapping("/admin/member/memberList")
	  public ModelAndView memberList(Model model, ModelAndView modelAndView) {
		modelAndView.setViewName("member/memberList");
	    return modelAndView;
	  }
}
