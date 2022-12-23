package edu.springz.mapper;

import java.util.List;

import edu.springz.domain.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> selectBoardAll();			// 전체 게시물 가져오기
	
	public BoardVO selectBoard(int bno);			// 게시물 가져오기
	
	public void insertBoard(BoardVO bvo);			// 게시물 등록 
	
	public int insertBoardSelectKey(BoardVO bvo);	// bno 사전에 증가 후 insert 수행
	
	public int deleteBoard(int bno);				// 게시물 삭제

	public int updateBoard(BoardVO bvo);			// 게시물 수정
	
}
