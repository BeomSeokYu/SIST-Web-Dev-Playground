package com.carshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carshop.domain.CarDTO;
import com.carshop.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/list")
	public String CarList(Model model) {
		List<CarDTO> list = carService.getAllCarList();
		model.addAttribute("carList",list);
		return "cars";
	}
	
	@RequestMapping("/{ccate}")
	public String requestCarById(@PathVariable("ccate") String ccate, Model model) {
		List<CarDTO> cscate = carService.getCarListByCategoty(ccate);
		model.addAttribute("carList", cscate);
		return "cars";
	}
}
