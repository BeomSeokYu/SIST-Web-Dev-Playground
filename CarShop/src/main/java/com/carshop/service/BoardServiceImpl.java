package com.carshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carshop.domain.BoardDTO;
import com.carshop.persistance.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	@Override
	public List<BoardDTO> getAllBoardList() {
		return boardRepository.getAllBoardList();
	}

}