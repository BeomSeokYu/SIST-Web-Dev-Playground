package edu.springz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.springz.domain.SampleVO;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample/")
@Log4j
public class SampleController {
//	priduces = 서버에서 보내오는 데이터를 어떤 형식으로 받을 것인가를 결정 (기본은 html)
	@GetMapping(value = "getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("getText()..................." + MediaType.TEXT_PLAIN_VALUE);
		return "Hello World!~";
	}
//	기본으로 json과 xml 데이터 타입을 전송
	@GetMapping(value = "getSample", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		log.info("getSample()...................");
		return new SampleVO(1, "firstName", "lastName");
	}
	
	@GetMapping(value = "getList")
	public List<SampleVO> getList() {
		log.info("getList()...................");
		
		return IntStream.range(1, 5).mapToObj(i -> new SampleVO(i, "aaa"+i, "bbb"+i)).collect(Collectors.toList());
	}
	
	@GetMapping(value = "getMap")
	public Map<String, SampleVO> getMap() {
		log.info("getMap()...................");
		
		Map<String, SampleVO> m = new HashMap<>();
		m.put("111", new SampleVO(1, "aaa", "bbb"));
		return m;
	}
	
	@GetMapping(value = "check")
	public ResponseEntity<SampleVO> check(int h, int w) {
		log.info("check()..................." );
		
		SampleVO svo = new SampleVO(6, "firstName", "lastName");
		ResponseEntity<SampleVO> resp = null;
		
		if(h > 100) {
			resp = ResponseEntity.status(HttpStatus.OK).body(svo);
		} else {
			resp = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(svo);
		}
		return resp;
	}
	// @PathVariable - url 경로를 이용해 파라미터를 전송
	@GetMapping(value = "product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") int pid) {
		log.info("PathVariable()..................." );
		
		return new String[] { "category:" + cat, "product id:" + pid };
	}
	
	@PostMapping(value = "sample")
	public SampleVO sample(@RequestBody SampleVO svo) {
		log.info("sample()..................." + svo);
		
		return svo;
	}
}
