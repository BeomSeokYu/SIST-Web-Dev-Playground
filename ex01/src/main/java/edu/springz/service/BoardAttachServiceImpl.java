package edu.springz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyPageDTO;
import edu.springz.domain.ReplyVO;
import edu.springz.mapper.BoardAttachMapper;
import edu.springz.mapper.BoardMapper;
import edu.springz.mapper.ReplyMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardAttachServiceImpl implements BoardAttachService {
	BoardAttachMapper boardAttachMapper;

	@Override
	public boolean removeAll(int bno) {
		return boardAttachMapper.deleteAttachAll(bno) == 1 ? true : false;
	}
	
}
