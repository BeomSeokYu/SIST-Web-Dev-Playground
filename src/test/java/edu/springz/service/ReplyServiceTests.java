package edu.springz.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {
	@Setter(onMethod_ = @Autowired)
	ReplyService replyService;
	
	private int[] bnoArr = {38, 39, 40, 41, 42};
	
//	@Test
	public void testModify() {
		ReplyVO rvo = replyService.view(3);
		rvo.setReply("updateReplyService");
		replyService.modify(rvo);
	}
	
//	@Test
	public void testRemove() {
		replyService.remove(2);
	}
	
//	@Test
	public void testList() {
		Criteria criteria = new Criteria();
		criteria.setPageNum(1);
		log.info(replyService.list(bnoArr[0], criteria));
		replyService.list(bnoArr[0], criteria).forEach(bvo -> {
			log.info(bvo);
		});
	}
	
//	@Test
	public void testView() {
		log.info(replyService.view(2));
	}
	
//	@Test
	public void testReg() {
		ReplyVO rvo = new ReplyVO();
		rvo.setBno(bnoArr[0]);
		rvo.setReply("replyService");
		rvo.setReplyer("replyerService");
		replyService.register(rvo);
	}
	
//	@Test
	public void testExists() {
		assertNotNull(replyService);
		
		log.info(replyService);
		log.info("--------------------");
	}
	
}
