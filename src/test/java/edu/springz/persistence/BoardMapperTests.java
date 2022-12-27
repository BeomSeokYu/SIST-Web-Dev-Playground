package edu.springz.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// Junit으로 스프링 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)	// 세터 인젝션
	private BoardMapper boardMapper;
	
	@Test
	public void testSearch() {
		Criteria criteria = new Criteria();
		criteria.setType("TC");
		criteria.setKeyword("t");
		
		log.info(boardMapper.selectBoardAllPaging(criteria));
		boardMapper.selectBoardAllPaging(criteria).forEach(bvo -> {
			log.info(bvo.getBno());
		});
	}
	
	//@Test
	public void testSelectAllPaging() {
		Criteria criteria = new Criteria();
		criteria.setPageNum(2);
		log.info(boardMapper.selectBoardAllPaging(criteria));
		boardMapper.selectBoardAllPaging(criteria).forEach(bvo -> {
			log.info(bvo.getBno());
		});
	}
	
	//@Test
	public void testUpdate() {
		BoardVO bvo = new BoardVO();
		bvo.setTitle("updateTitle");
		bvo.setContent("updateContent");
		bvo.setBno(11);
		boardMapper.updateBoard(bvo);
		testSelectAll();
	}
	
	//@Test
	public void testDelete() {
		boardMapper.deleteBoard(12);
		testSelectAll();
	}
	
	//@Test
	public void testInsertSelectKey() {
		BoardVO bvo = new BoardVO();
		bvo.setTitle("111");
		bvo.setContent("222");
		bvo.setWriter("333");
		
		int bno = boardMapper.insertBoardSelectKey(bvo);
		log.info("insertBoardSelectKey - bno : " + bno);
	}
	
	//@Test
	public void testInsert() {
		BoardVO bvo = new BoardVO();
		bvo.setTitle("title");
		bvo.setContent("content");
		bvo.setWriter("kim");
		
		boardMapper.insertBoard(bvo);
	}
	
	//@Test
	public void testSelectAll() {
		log.error(boardMapper.selectBoard(1));
		log.info(boardMapper.getClass().getName());
		log.info(boardMapper.selectBoardAll());
		boardMapper.selectBoardAll().forEach(bvo -> {
			log.info(bvo);
		});
	}
	
	//@Test
	public void testSelect() {
		log.info(boardMapper.getClass().getName());
		log.info(boardMapper.selectBoard(2));
	}
}
