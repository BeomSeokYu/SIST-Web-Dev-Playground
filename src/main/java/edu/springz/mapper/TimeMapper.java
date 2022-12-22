package edu.springz.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	public String getTimeTomorrow();		// xml 매퍼 이용
	
	@Select("SELECT SYSDATE FROM DUAL")	// 쿼리를 직접 명시
	public String getTime();
}
