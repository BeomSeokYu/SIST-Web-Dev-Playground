package edu.springz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.springz.domain.BoardAttachVO;
import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.mapper.BoardAttachMapper;
import edu.springz.mapper.BoardMapper;
import edu.springz.mapper.ReplyMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	private BoardMapper boardMapper;
	private BoardAttachMapper boardAttachMapper;
	
	@Override
	public List<BoardVO> list(Criteria criteria) {
		return boardMapper.selectBoardAllPaging(criteria);
	}
	
	@Override
	public int totalCount(Criteria criteria) {
		return boardMapper.totalCount(criteria);
	}
	
	@Transactional
	@Override
	public BoardVO view(int bno) {
		BoardVO bvo = new BoardVO();
		bvo = boardMapper.selectBoard(bno);
		bvo.setAttachList(boardAttachMapper.selectAttachAll(bno));
		return bvo;
	}
	
	@Transactional
	@Override
	public boolean register(BoardVO bvo) {
		List<BoardAttachVO> attachList = bvo.getAttachList();
		boardMapper.insertBoardSelectKey(bvo);
		if(!attachList.isEmpty()) {
			attachList.forEach( bavo -> {
				bavo.setBno(bvo.getBno());
				boardAttachMapper.insertAttach(bavo);
			});
		}
		return true;
	}

	@Override
	public boolean remove(int bno) {
		return boardMapper.deleteBoard(bno) == 1 ? true : false;
	}

	@Override
	public boolean modify(BoardVO bvo) {
		return boardMapper.updateBoard(bvo) == 1 ? true : false;
	}
	
	@Override
	public boolean setReplyCnt(int bno, int replyCnt) {
		boardMapper.updateReplyCnt(bno, replyCnt);
		return false;
	}
}
