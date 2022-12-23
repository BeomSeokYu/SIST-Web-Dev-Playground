package edu.springz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.springz.domain.BoardVO;
import edu.springz.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> list() {
		return boardMapper.selectBoardAll();
	}

	@Override
	public BoardVO view(int bno) {
		return boardMapper.selectBoard(bno);
	}

	@Override
	public boolean register(BoardVO bvo) {
		return boardMapper.insertBoardSelectKey(bvo) == 1 ? true : false;
	}

	@Override
	public boolean remove(int bno) {
		return boardMapper.deleteBoard(bno) == 1 ? true : false;
	}

	@Override
	public boolean modify(BoardVO bvo) {
		return boardMapper.updateBoard(bvo) == 1 ? true : false;
	}
	
}
