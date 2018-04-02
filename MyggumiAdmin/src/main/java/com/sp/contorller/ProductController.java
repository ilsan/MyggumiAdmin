package com.sp.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sp.domain.User;
import com.sp.service.Impl.TestServiceImpl;

@Controller
public class ProductController {

	@Autowired(required=true)
	private TestServiceImpl testServiceImpl;
	
	 @RequestMapping("admin/product/productList")
	  public ModelAndView productList(Model model, ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 product/productList ");
		
		List<User> d = testServiceImpl.getUserList();
		
		System.out.println(d.size());
		
		modelAndView.setViewName("product/productList");
	    return modelAndView;
	  }
	 
	 @RequestMapping("admin/product/productWrite")
	  public ModelAndView productWrite(Model model, ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 productWrite ");
		modelAndView.setViewName("product/productWrite");
	    return modelAndView;
	  }
	 
	 @RequestMapping("/admin/member/memberList")
	  public ModelAndView memberList(Model model, ModelAndView modelAndView) {
		 
		System.out.println(">>>>>>>>>>> 접속 memberList ");
		modelAndView.setViewName("member/memberList");
	    return modelAndView;
	  }
}
