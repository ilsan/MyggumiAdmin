package com.sp.contorller;

import com.sp.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class SampleController {


    private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    
    //테스트 화면1 부트스트랩적용
    @RequestMapping("/main.do")
   public ModelAndView mainpage() {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("/sample/test");
       
       return modelAndView;
   }
  //테스트 화면2 부트스트랩적용
    @RequestMapping("/test/main.do")
   public ModelAndView mainpage2() {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("/sample/test2");
       
       return modelAndView;
   }
    
    
    
    //다음주소 API 테스트
    @RequestMapping("/join.do")
    public ModelAndView join() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/sample/join");
        
        return modelAndView;
    }

}
