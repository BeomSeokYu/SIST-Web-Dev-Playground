package edu.springz.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.springz.mapper.TestMapper1;
import edu.springz.mapper.TestMapper2;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class TestServiceImpl implements TestService {
	private TestMapper1 tm1;
	private TestMapper2 tm2;
	
	@Transactional
	@Override
	public void registerCol(String s) {
		tm1.insertCol1(s);
		tm2.insertCol2(s);
	}

}
