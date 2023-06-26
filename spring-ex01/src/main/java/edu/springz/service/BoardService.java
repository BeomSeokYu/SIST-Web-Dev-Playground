package edu.springz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;

public interface BoardService {

	public List<BoardVO> list(Criteria criteria);		// 전체 게시물 가져오기
	
	public int totalCount(Criteria criteria);			// 전체 게시물 수 가져오기
	
	public BoardVO view(int bno);						// 게시물 가져오기
	
	public boolean register(BoardVO bvo);				// bno 사전에 증가 후 insert 수행
	
	public boolean remove(int bno);						// 게시물 삭제

	public boolean modify(BoardVO bvo);					// 게시물 수정
	
	public boolean setReplyCnt(	@Param("bno") int bno, 
								@Param("replyCnt") int replyCnt);					// 댓글 수 수정
	
}
