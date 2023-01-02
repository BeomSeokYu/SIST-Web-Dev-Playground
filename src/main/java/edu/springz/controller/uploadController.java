package edu.springz.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class uploadController {
	// ajax로 업로드
	@GetMapping("/upload/ajaxAction")
	public void uploadAjax() {
		log.info("upload formAction Ajax");
	}
	
	@PostMapping("/upload/ajaxAction")
	public void uploadActionAjax(MultipartFile[] files) {
		log.info("upload action Ajax");
		String uploadPath = "c:\\dev\\upload";
		for(MultipartFile file : files) {
			log.info("==============================");
			log.info("file name : " + file.getOriginalFilename());
			log.info("file size : " + file.getSize());
			
			File saveFile = new File(uploadPath, file.getOriginalFilename());
			
			try {
				file.transferTo(saveFile);	// 파일 업로드 처리
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// form 태그로 업로드
	@GetMapping("/upload/formAction")
	public void uploadForm() {
		log.info("upload formAction");
	}
	
	@PostMapping("/upload/formAction")
	public void uploadAction(MultipartFile[] files) {
		log.info("upload action");
		String uploadPath = "c:\\dev\\upload";
		for(MultipartFile file : files) {
			log.info("==============================");
			log.info("file name : " + file.getOriginalFilename());
			log.info("file size : " + file.getSize());
			
			File saveFile = new File(uploadPath, file.getOriginalFilename());
			
			try {
				file.transferTo(saveFile);	// 파일 업로드 처리
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
