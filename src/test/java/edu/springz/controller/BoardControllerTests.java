package edu.springz.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)		//Junit으로 스프링 지정
@ContextConfiguration({	"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@Log4j
public class BoardControllerTests {
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockmvc;
	
	@Before
	public void setup() {
		mockmvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testRemove() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "7"))
							.andReturn()
							.getModelAndView()
							.getModelMap()
			);
		testList();
	}
	
//	@Test
	public void testModify() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.post("/board/modify")
													   .param("title", "mod title")
													   .param("content", "mod content")
													   .param("bno", "5")
				   
								).andReturn()
								.getModelAndView()
								.getViewName());
		testList();
	}
	
//	@Test
	public void testView() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.get("/board/view").param("bno", "2"))
					.andReturn()
					.getModelAndView()
					.getModelMap()
				);
	}
	
//	@Test
	public void testRegister() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.post("/board/register")
													   .param("title", "new title")
													   .param("content", "new content")
													   .param("writer", "new writer")
													   
								).andReturn()
								 .getModelAndView()
								 .getViewName()
				);
		testList();
	}
	
//	@Test
	public void testList() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.get("/board/list"))
					.andReturn()
					.getModelAndView()
					.getModelMap()
				);
	}
}
