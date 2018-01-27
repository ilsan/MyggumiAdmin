package com.sp.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {

	@RequestMapping("stat")
	public String stat(Model model) {
		return "stat";
	}
}
