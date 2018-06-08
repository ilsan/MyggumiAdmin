package com.sp.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sp.common.util.PageUtil;
import com.sp.domain.CommonCodeInfo;
import com.sp.domain.PaginationInfo;
import com.sp.domain.Product;
import com.sp.domain.form.ProductForm;
import com.sp.service.CommonCodeService;
import com.sp.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired(required=true)
	private ProductService productService;
	
	@Autowired(required=true)
	private CommonCodeService commonCodeService;
	
	 @RequestMapping("/product/productList")
	  public String productList(Model model, @ModelAttribute("paginationInfo") PaginationInfo pageInfo) {
		 
		log.info(">>>>>>>>>>> 접속 product/productList ");
		
		String url = "/admin/product/productList";
		
		/*pageInfo.setTotalRecordCount(productService.productTotalCount());
		
		model.addAttribute("productList", productService.productList(pageInfo));
		model.addAttribute("count", pageInfo.getTotalRecordCount());
		model.addAttribute("pageResult", PageUtil.getPageNavigation(pageInfo, url, null));
*/
	    return "product/productList";
	  }
	 /**
	  * @param modelAndView
	  * @param productNo - 상품번호
	  * @return
	  * 상품 상세내역
	  */
	 @RequestMapping("/product/productDetail")
	 public ModelAndView productDetail(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 Product productDetail = productService.productDetail(productNo);
		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productDetail");
		 return modelAndView;
	 }
	 
	 
	 /**
	  * @param modelAndView
	  * @return 
	  * 상품 등록페이지 이동
	  */
	 @RequestMapping("/product/productWrite")
	  public ModelAndView productWrite(ModelAndView modelAndView) {
		modelAndView.addObject("productType", commonCodeService.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
		modelAndView.addObject("productCategory", commonCodeService.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
		modelAndView.setViewName("product/productWrite");
	    return modelAndView;
	  }
	 
	 
	 
	 /**
	  * @param ProductForm - 등록하기 위한 입력 데이터
	  * @return
	  * 상품 등록
	  */
	 @RequestMapping(value="/product/productWriteAfter", method=RequestMethod.POST)
	 public String productWriteAfter(@ModelAttribute ProductForm productForm) {
		 productService.productInsert(productForm);
		 return "redirect:/admin/product/productList";
	 }
	 
	 
	 
	 /**
	  * @param ModelAndView
	  * @param productNo - 상품번호
	  * @return 
	  * 상품 수정
	  */ 
	 @RequestMapping("/product/productUpdate")
	 public ModelAndView productUpdate(ModelAndView modelAndView, @RequestParam("productNo") int productNo) {
		 Product productDetail = productService.productDetail(productNo);
		 modelAndView.addObject("productType", commonCodeService.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
		 modelAndView.addObject("productCategory", commonCodeService.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productUpdate");
		 return modelAndView;
	 }
	 
	 

	 @RequestMapping(value="/product/productUpdateAfter" , method=RequestMethod.POST)
	 public String productUpdateAfter(@ModelAttribute Product vo, @RequestParam("updatePno") int productNo) {
		 vo.setProductNo(productNo);
		 int res = productService.productUpdate(vo);
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
