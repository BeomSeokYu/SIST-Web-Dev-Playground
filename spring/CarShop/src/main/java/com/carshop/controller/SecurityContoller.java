package com.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityContoller {
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("data", "admin");
		return "/test";
	}
	
	@GetMapping("/manager")
	public String manager(Model model) {
		model.addAttribute("data", "manager");
		return "/test";
	}
	
	@GetMapping("/member")
	public String member(Model model) {
		model.addAttribute("data", "member");
		return "/test";
	}
	
	@GetMapping("/guest")
	public String guest(Model model) {
		model.addAttribute("data", "guest");
		return "/test";
	}
}
