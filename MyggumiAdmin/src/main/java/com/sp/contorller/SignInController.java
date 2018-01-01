package com.sp.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController {


    @RequestMapping(value = "/")
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect"+ "/admin/signIn.do");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/signIn.do")
    public ModelAndView signIn(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("login");

        return modelAndView;
    }

}
