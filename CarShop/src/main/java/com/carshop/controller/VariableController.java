package com.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vari")
public class VariableController {
	
	@GetMapping("/names/{name}/{gender}")
	public String names1(@PathVariable String name, @PathVariable String gender, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		return "/study/name";
	}
	
	@GetMapping("/names/car/{carId}")
	public String names2(@PathVariable String carId, @MatrixVariable String cate, Model model) {
		model.addAttribute("id", carId);
		model.addAttribute("cate", cate);
		return "/study/car";
	}
}
