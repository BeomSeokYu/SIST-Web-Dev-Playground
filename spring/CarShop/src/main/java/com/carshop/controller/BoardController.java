package com.carshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carshop.domain.BoardDTO;

@Controller
@RequestMapping(value="/board", method=RequestMethod.GET)
public class BoardController {
	
	@Autowired
	private com.carshop.service.BoardService BoardService;
	
	@RequestMapping("/list")
	public String BoardList(Model model) {
		List<BoardDTO> list = BoardService.getAllBoardList();
		model.addAttribute("boardList",list);
		return "/board/list";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		return "/board/test";
	}
	
	@RequestMapping("test2")
	public String test2(Model model) {
		return "/board/test";
	}
	
}
