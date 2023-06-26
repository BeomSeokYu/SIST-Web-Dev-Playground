package com.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParamController {
	
	@GetMapping("/exam1")
	public String exam1(@RequestParam String id, Model model) {
		model.addAttribute("id", id);
		
		return "/study/car";
	}
}
