package com.carshop.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/img")
public class UploadController {
	@GetMapping("/upload")
	public String imgUploadPage() {
		return "/study/imageExam";
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> imgUpload(
			@RequestParam("name") String name,
			@RequestParam("files") MultipartFile files
			) {
		
		String filename = files.getOriginalFilename();
		System.out.println(filename);
		
		String upPath = "/resources/upload/" + name + "_" + filename;
		
		File f = new File(upPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		try {
			files.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<>("uploaded", HttpStatus.OK);
	}
}
