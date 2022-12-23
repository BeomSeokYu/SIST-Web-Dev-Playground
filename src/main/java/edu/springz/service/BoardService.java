package edu.springz.service;

import java.util.List;

import edu.springz.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> list();			// 전체 게시물 가져오기
	
	public BoardVO view(int bno);			// 게시물 가져오기
	
	public boolean register(BoardVO bvo);	// bno 사전에 증가 후 insert 수행
	
	public boolean remove(int bno);				// 게시물 삭제

	public boolean modify(BoardVO bvo);			// 게시물 수정
}
