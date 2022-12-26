package edu.springz.mapper;

import java.util.List;

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;

public interface BoardMapper {
	
	public List<BoardVO> selectBoardAll();						// 전체 게시물 가져오기
	
	public List<BoardVO> selectBoardAllPaging(Criteria criteria);	// 게시물 페이징 해서 가져오기
	
	public int totalCount(Criteria criteria);									// 전체 게시물 수 가져오기
	
	public BoardVO selectBoard(int bno);						// 게시물 가져오기
	
	public void insertBoard(BoardVO bvo);						// 게시물 등록 
	
	public int insertBoardSelectKey(BoardVO bvo);				// bno 사전에 증가 후 insert 수행
	
	public int deleteBoard(int bno);							// 게시물 삭제

	public int updateBoard(BoardVO bvo);						// 게시물 수정
}
