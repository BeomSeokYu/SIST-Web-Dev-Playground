package edu.springz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class SecurityController {

	@GetMapping("/sample/all")
	public void getAll() {
		log.info("getAll()...................");
	}
	
	@GetMapping("/sample/member")
	public void getMember() {
		log.info("getMember()...................");
	}
	
	@GetMapping("/sample/admin")
	public void getAdmin() {
		log.info("getAdmin()...................");
	}
	
}
