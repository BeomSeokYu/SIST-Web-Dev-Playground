package edu.springz.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TestMapper1 {
	
	@Insert(value = { "INSERT INTO tbl_sample1 VALUES (#{s})" })
	public void insertCol1(String s);
}
