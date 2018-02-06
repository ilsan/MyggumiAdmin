package com.sp.contorller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sp.common.util.ParamUtil;
import com.sp.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/product/productList")
	public ModelAndView productList(HttpServletRequest request, Model model, ModelAndView modelAndView) {
		
		Map map = ParamUtil.paramMap(request);
		List<Map> list = productService.getProductList(map);
		int productCnt = productService.getProductCount();
		
		System.out.println(list.get(0).toString());
		modelAndView.addObject("productList", list);
		modelAndView.addObject("totalCnt", productCnt);
		
		System.out.println(">>>>>>>>>>> 접속 product/productList ");
		modelAndView.setViewName("product/productList");
		return modelAndView;
	}

	@RequestMapping("/product/productWrite")
	public ModelAndView productWrite(Model model, ModelAndView modelAndView) {

		System.out.println(">>>>>>>>>>> 접속 productWrite ");
		modelAndView.setViewName("product/productWrite");
		return modelAndView;
	}

	@RequestMapping("/member/memberList")
	public ModelAndView memberList(Model model, ModelAndView modelAndView) {

		System.out.println(">>>>>>>>>>> 접속 memberList ");
		modelAndView.setViewName("member/memberList");
		return modelAndView;
	}
}
