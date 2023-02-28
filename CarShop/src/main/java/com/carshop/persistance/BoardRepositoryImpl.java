package com.carshop.persistance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.carshop.domain.BoardDTO;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

	private List<BoardDTO> listOfBoards = new ArrayList<BoardDTO>();
	
	public BoardRepositoryImpl() {
		
		BoardDTO board1 = new BoardDTO("1","제목1","내용1","작성자1");
		BoardDTO board2 = new BoardDTO("2","제목2","내용2","작성자2");
		BoardDTO board3 = new BoardDTO("3","제목3","내용3","작성자3");
		
		listOfBoards.add(board1);
		listOfBoards.add(board2);
		listOfBoards.add(board3);
		
	}
	
	@Override
	public List<BoardDTO> getAllBoardList() {
		
		return listOfBoards;
	}

}