package edu.springz.persistence;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;
import edu.springz.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// Junit으로 스프링 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Setter(onMethod_ = @Autowired)	// 세터 인젝션
	ReplyMapper replyMapper;
	// 실제 게시물 번호
	private int[] bnoArr = {38, 39, 40, 41, 42};
	
	@Test
	public void testList() {
		Criteria criteria = new Criteria();
		criteria.setPageNum(1);
		criteria.setAmount(3);
		replyMapper.selectReplyAllPaging(38, criteria);
	}
	
//	@Test
	public void testDelete() {
		log.info(replyMapper.selectReply(3));
		replyMapper.deleteReply(1);
	}
	
//	@Test
	public void testUpdate() {
		log.info(replyMapper.selectReply(3));
		ReplyVO rvo = new ReplyVO();
		rvo.setRno(10);
		rvo.setReply("replyUpdate");
		replyMapper.updateReply(rvo);
	}
	
//	@Test
	public void testSelect() {
		log.info(replyMapper.selectReply(3));
	}
	
//	@Test
	public void testInsert() {
		log.info("testInsert -------- ");
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO rvo = new ReplyVO();
			rvo.setBno(bnoArr[i % 5]);
			rvo.setReply("reply" + i);
			rvo.setReplyer("replyer" + i);
			replyMapper.insertReply(rvo);
		});
	}
	
//	@Test
	public void testMapper() {
		log.info("replyMapper TEST -------- " + replyMapper);
	}
}
