package edu.springz.mapper;

import java.util.List;


import edu.springz.domain.BoardAttachVO;

public interface BoardAttachMapper {
	
	public List<BoardAttachVO> selectAttachAll(int bno);	// 첨부파일 목록 가져오기
	
	public int insertAttach(BoardAttachVO bavo);		// 첨부파일 등록 
	
	public int deleteAttach(String uuid);				// 첨부파일 삭제
	
}
