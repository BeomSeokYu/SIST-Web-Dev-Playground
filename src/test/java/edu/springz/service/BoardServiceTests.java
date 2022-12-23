package edu.springz.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.springz.domain.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)		//Junit으로 스프링 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	@Test
	public void testModify() {
		BoardVO bvo = boardService.view(12);
		bvo.setTitle("updateTitle");
		bvo.setContent("updateContent");
		bvo.setBno(bvo.getBno());
		boardService.modify(bvo);
	}
	
	//@Test
	public void testRemove() {
		boardService.remove(12);
	}
	
	//@Test
	public void testList() {
		boardService.list().forEach(bvo -> {
			log.info(bvo);
		});
	}
	
	//@Test
	public void testView() {
		log.info(boardService.view(1));
	}
	
	//@Test
	public void testReg() {
		BoardVO bvo = new BoardVO();
		bvo.setTitle("aaa");
		bvo.setContent("aaa");
		bvo.setWriter("aaa");
		boardService.register(bvo);
	}
	
	//@Test
	public void testExists() {
		assertNotNull(boardService);
		
		log.info(boardService);
		log.info("--------------------");
	}
}
