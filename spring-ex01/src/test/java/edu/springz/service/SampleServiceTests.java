package edu.springz.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleServiceTests {
	@Setter(onMethod_ = @Autowired)
	private SampleService service;
	
	@Test
	public void testAround() throws Exception {
		log.info(service.doAdd("300", "400"));
	}
	
//	@Test
	public void testException() throws Exception {
		log.info(service.doAdd("200", "삼백"));
	}
	
//	@Test
	public void testParam() throws Exception {
		log.info(service);
		log.info(service.getClass().getName());
		log.info(service.doAdd("200", "300"));
	}
	
//	@Test
	public void testAdvice() throws Exception {
		log.info(service);
		log.info(service.getClass().getName());
		log.info(service.doAdd("100", "200"));
	}
}
