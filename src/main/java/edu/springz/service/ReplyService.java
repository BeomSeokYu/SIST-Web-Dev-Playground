package edu.springz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> list(	@Param("bno") 		int bno,
								@Param("criteria") 	Criteria criteria );		// 전체 댓글 가져오기

	public int totalCount(Criteria criteria);			// 전체 댓글 수 가져오기
	
	public ReplyVO view(int rno);						// 댓글 가져오기
	
	public boolean register(ReplyVO rvo);				// 댓글 등록
	
	public boolean remove(int rno);						// 댓글 삭제
	
	public boolean modify(ReplyVO rvo);					// 댓글 수정
}
