package com.sp.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController {

	 @RequestMapping("goods")
	  public String goods(Model model) {
	    return "goods";
	  }

}
