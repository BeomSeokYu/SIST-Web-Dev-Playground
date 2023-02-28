package com.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/study")
public class StudyController {
	
	@GetMapping("/test1")
	public String test1(Model model) {
		model.addAttribute("data1", "모델입니다.1");
		model.addAttribute("data2", "모델입니다.2");
		
		return "/study/test";
	}
	
	@GetMapping("/test2")
	public String test2(ModelMap model) {
		model.addAttribute("data1", "모델맵입니다.1");
		model.addAttribute("data2", "모델맵입니다.2");
		
		return "/study/test";
	}
	
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		mv.addObject("data1", "모델앤뷰입니다.1");
		mv.addObject("data2", "모델앤뷰입니다.2");
		mv.setViewName("/study/test");
		
		return mv;
	}
}
