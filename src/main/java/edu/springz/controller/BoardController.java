package edu.springz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.domain.PageDTO;
import edu.springz.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j
public class BoardController {
	private BoardService boardService;
	
	@PostMapping("remove")
	public String remove(int bno, RedirectAttributes rttr) {
		rttr.addFlashAttribute("result", boardService.remove(bno) ? "success" : "fail");
		return "redirect:/board/list";
	}
	
	@PostMapping("modify")
	public String modify(BoardVO bvo, RedirectAttributes rttr) {
		rttr.addFlashAttribute("result", boardService.modify(bvo) ? "success" : "fail");
		return "redirect:/board/list";
	}
	
	@GetMapping("list")
	public void list(Model model, Criteria criteria) {
		model.addAttribute("list", boardService.list(criteria));
		int totalCount = 123;
		model.addAttribute("pageDTO", new PageDTO(criteria, totalCount));
	}
	
	@GetMapping({"view", "modify"})	// 게시물 조회, 수정폼
	public void view(int bno, Model model) {
		model.addAttribute("bvo", boardService.view(bno));
	}
	
	@GetMapping("register")
	public void register() {
	}
	
	@PostMapping("register")
	public String register(BoardVO bvo, RedirectAttributes rttr) { // RedirectAttributes -> 리다이렉트 하는 곳으로 데이터를 가져갈 수 있음 
		boardService.register(bvo);
		rttr.addFlashAttribute("result", bvo.getBno());
		return "redirect:/board/list";
	}
	
}
