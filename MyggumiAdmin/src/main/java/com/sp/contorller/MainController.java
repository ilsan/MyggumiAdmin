package com.sp.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView main(Model model, ModelAndView modelAndView) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>메인페이지 접속");
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
}
