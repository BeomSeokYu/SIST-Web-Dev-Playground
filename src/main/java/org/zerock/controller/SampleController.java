package org.zerock.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
//	파일 업로드 폼
	@GetMapping("uploadEX")
	public void uploadEXForm() {
		log.info("uploadEXForm()............");
	}
	
//	파일 업로드 처리
	@PostMapping("uploadEX")
	public void uploadEXProc(ArrayList<MultipartFile> files) {
		log.info("uploadEX()............\n" + files);
		
		files.forEach(f -> log.info(f.getOriginalFilename() + " / " + f.getSize()));
	}
	
//	json 데이터 보내기 (ResponseEntity<String>)
	@GetMapping("ex06")
	public ResponseEntity<String> ex06() {
		log.info("ex06()............\n");
		
		String msg = "{\"name\":\"Ban\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("content-type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
//	json 데이터 보내기 (@ResponseBody)
	@GetMapping("ex05")
	public @ResponseBody SampleDTO ex05() {
		log.info("ex05()............\n");
		
		SampleDTO sdto = new SampleDTO();
		sdto.setName("Dan");
		sdto.setAge(50);
		return sdto;
	}
	
	@GetMapping("ex04")
	//public void ex04(SampleDTO sdto, int pageNum) {
	public String ex04(SampleDTO sdto, Model model, @ModelAttribute("pageNum") int pageNum) {	// 파라미터 데이터를 모델 속성으로 담음
		model.addAttribute("code", "1234");
		log.info("ex04()............\n" + sdto + " \n " + pageNum);
		
		return "/sample/ex044";
	}
	
//	GET방식으로 tdto 받기 (Date 포함)
	@GetMapping("ex03")
	public void ex03(TodoDTO tdto) {
		log.info("ex03()............\n" + tdto);
	}
	
//	GET방식으로 DTO 리스트 받기
//	http://localhost:8090/sample/ex02BeanList?list%5B0%5D.name=lee&list%5B1%5D.name=kim&list%5B2%5D.name=qwer&list%5B3%5D.name=asdf&list%5B4%5D.name=zxcv
	@GetMapping("ex02BeanList")
	public void ex02BeanList(SampleDTOList list) {
		log.info("ex02BeanList()............\n" + list);
	}
	
//	GET방식으로 id파라미터 배열로 받기
	@GetMapping("ex02Array")
	public void ex02Array(@RequestParam("id") String[] ids) {
		log.info("ex02Array()............\n" + Arrays.toString(ids));
	}
	
//	GET방식으로 id파라미터 리스트로 받기
	@GetMapping("ex02List")
	public void ex02List(@RequestParam("id") ArrayList<String> ids) {
		log.info("ex02List()............\n" + ids);
	}
	
//	GET방식으로 name파라미터와 age파라미터 받기
	@GetMapping("ex02")
	public void ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("ex02()............\n" + name + " / " + age);
	}
	
//	모든 요청에서 dto 받기
	@RequestMapping("ex01")
	public void ex01(SampleDTO sdto) {
		log.info("ex01()............\n" + sdto);
	}
	
//	GET, POST방식 요청 받기
	@RequestMapping(value = "basicGP", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGP() {
		log.info("basicGP()............");
	}
	
	@RequestMapping("basic")
	public void basicGet() {
		log.info("basicGet()............");
	}
	
	@RequestMapping("")
	public void basicAll() {
		log.info("basicAll()............");
	}
}