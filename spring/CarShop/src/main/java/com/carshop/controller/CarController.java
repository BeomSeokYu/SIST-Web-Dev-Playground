package com.carshop.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.carshop.domain.CarDTO;
import com.carshop.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/list")	
	public String carList(Model model) {
		List<CarDTO> list = carService.getAllCarList();
		model.addAttribute("carList",list);
		return "/car/cars";
	}
	
	@GetMapping("/{ccate}")
	public String requestCarByCate(@PathVariable("ccate") String ccate, Model model) {
		List<CarDTO> cscate = carService.getCarListByCategoty(ccate);
		model.addAttribute("carList", cscate);
		return "/car/cars";
	}
	
	@GetMapping("/car")
	public String requestCarById(@RequestParam("id") String carId , Model model) {
		CarDTO car = carService.getCarById(carId);
		model.addAttribute("car", car);
		return "/car/car";
	}
	
	@GetMapping("/admin/add")
	public String add(@ModelAttribute("car") CarDTO car) {
		return "/car/addCar";
	}
	@PostMapping("/admin/add")
	public String addCar(CarDTO car, Model model) {
		MultipartFile carImage = car.getCarImage();
		String upPath = "/resources/upload/";
		String projPath = "C:\\dev\\GitRepo\\Spring\\CarShop\\src\\main\\webapp\\resources\\upload\\";
		String savePath = servletContext.getRealPath(upPath);
		
		System.out.println(projPath);
		if (carImage != null && !carImage.isEmpty()) {
			String filename = carImage.getOriginalFilename();
			File saveFile = new File(savePath + "/" + filename);
			File projFile = new File(projPath + filename);
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}
			
			try {
				carImage.transferTo(saveFile);
				//carImage.transferTo(projFile);
			} catch (Exception e) {
				throw new RuntimeException("이미지 업로드 실패");
			}
		}
		carService.setNewCar(car);
		return "redirect: /cars/list";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/loginFailed")
	public String loginFailed() {
		return "/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "/login";
	}
}
