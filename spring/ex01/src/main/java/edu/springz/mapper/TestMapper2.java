package edu.springz.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TestMapper2 {
	
	@Insert(value = { "INSERT INTO tbl_sample2 VALUES (#{s})" })
	public void insertCol2(String s);
}
