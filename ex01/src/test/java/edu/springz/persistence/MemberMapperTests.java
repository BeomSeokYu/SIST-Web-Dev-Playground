package edu.springz.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.springz.mapper.MemberMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// Junit으로 스프링 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	@Setter(onMethod_ = @Autowired)
	MemberMapper memberMapper;
	
	@Test
	public void testSelect() {
		log.info(memberMapper.getClass().getName());
		log.info(memberMapper.selectMember("member88"));
		log.info(memberMapper.selectMember("admin99"));
	}
	
}
