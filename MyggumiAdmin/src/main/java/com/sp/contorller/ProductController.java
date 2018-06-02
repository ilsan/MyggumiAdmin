package com.sp.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.sp.common.util.ProductExcelDownload;
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
		modelAndView.addObject("productType", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
		modelAndView.addObject("productCategory", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
		modelAndView.addObject("productList", productList);
		modelAndView.setViewName("product/productList");
	    return modelAndView;
	  }
	 
	 
	 /**
	  * @param modelAndView
	  * @param productNo - 상품번호
	  * @return
	  * 상품 상세내역
	  */
	 @RequestMapping("/admin/product/productDetail")
	 public ModelAndView productDetail(ModelAndView modelAndView,@RequestParam("productNo") int productNo) {
		 Product productDetail = productServiceImpl.productDetail(productNo);
		 modelAndView.addObject("productType", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
			modelAndView.addObject("productCategory", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productDetail");
		 return modelAndView;
	 }
	 
	 
	 /**
	  * @param modelAndView
	  * @return 
	  * 상품 등록페이지 이동
	  */
	 @RequestMapping("/admin/product/productWrite")
	  public ModelAndView productWrite(ModelAndView modelAndView) {
		modelAndView.addObject("productType", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
		modelAndView.addObject("productCategory", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
		modelAndView.setViewName("product/productWrite");
		 modelAndView.addObject("productForm",new ProductForm());
	    return modelAndView;
	  }
	 
	 
	 
	 /**
	  * @param ProductForm - 등록하기 위한 입력 데이터
	  * @return
	  * 상품 등록
	  */
	 @RequestMapping(value="/admin/product/productWriteAfter", method=RequestMethod.POST)
	 public ModelAndView productWriteAfter(@ModelAttribute @Valid ProductForm productForm, BindingResult result) {
		 if(result.hasErrors()) {
			 ModelAndView modelAndView = new ModelAndView();
			 modelAndView.addObject("productType", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
			 modelAndView.addObject("productCategory", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
			 modelAndView.addObject("productForm", productForm);
			 modelAndView.setViewName("product/productWrite");
			 return modelAndView;
		 }
		 
		 productServiceImpl.productInsert(productForm);
		 return new ModelAndView("redirect:/admin/product/productList");
	 }
	 
	 
	 
	 /**
	  * @param ModelAndView
	  * @param productNo - 상품번호
	  * @return 
	  * 상품 수정
	  */ 
	 @RequestMapping("/admin/product/productUpdate")
	 public ModelAndView productUpdate(ModelAndView modelAndView, @RequestParam("productNo") int productNo) {
		 Product productDetail = productServiceImpl.productDetail(productNo);
		 modelAndView.addObject("productType", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
		 modelAndView.addObject("productCategory", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
		 modelAndView.addObject("productDetail",productDetail);
		 modelAndView.setViewName("product/productUpdate");
		 return modelAndView;
	 }
	 
	 

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
	 
	@RequestMapping("/admin/product/productExcelDownload")
	public View productExcelDownload(Model model) {
		List<Product> productList = productServiceImpl.productList(); 

		model.addAttribute("productType", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_TYPE.getCode()));
		model.addAttribute("productCategory", commonCodeServiceImpl.findByCode(CommonCodeInfo.PRODUCT_CATEGORY.getCode()));
		model.addAttribute("list", productList);
		
		return (View) new ProductExcelDownload();
	}
	 
	 
	 
}
