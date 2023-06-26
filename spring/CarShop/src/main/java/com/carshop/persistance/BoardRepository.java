package com.carshop.persistance;

import java.util.List;

import com.carshop.domain.BoardDTO;

public interface BoardRepository {
	
	List<BoardDTO> getAllBoardList();

}