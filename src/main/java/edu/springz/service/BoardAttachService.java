package edu.springz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.springz.domain.BoardAttachVO;
import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyPageDTO;
import edu.springz.domain.ReplyVO;

public interface BoardAttachService {
	
	public List<BoardAttachVO> listAttach(int bno);	// 첨부파일 목록 가져오기
	
	public int registerAttach(BoardAttachVO bavo);		// 첨부파일 등록 
	
	public int removeAttach(String uuid);				// 첨부파일 삭제
}
