package com.sp.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	 @RequestMapping("product/productList")
	  public ModelAndView productList(Model model, ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 product/productList ");
		modelAndView.setViewName("product/productList");
	    return modelAndView;
	  }
	 
	 @RequestMapping("product/productWrite")
	  public ModelAndView productWrite(Model model, ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 product/productList ");
		modelAndView.setViewName("product/productWrite");
	    return modelAndView;
	  }
}
