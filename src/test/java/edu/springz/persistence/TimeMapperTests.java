package edu.springz.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import edu.springz.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// Junit으로 스프링 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	@Setter(onMethod_ = @Autowired)	// 세터 인젝션
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTimeTomorrow() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTimeTomorrow());
	}
	
	//@Test
	public void testMyBatis() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
}
