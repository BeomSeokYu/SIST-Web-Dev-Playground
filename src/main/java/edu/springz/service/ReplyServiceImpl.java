package edu.springz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyPageDTO;
import edu.springz.domain.ReplyVO;
import edu.springz.mapper.ReplyMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	private ReplyMapper replyMapper;
	
	@Override
	public ReplyPageDTO list(int bno, Criteria criteria) {
		return new ReplyPageDTO(replyMapper.totalReply(bno),
								replyMapper.selectReplyAllPaging(bno, criteria));
	}

	@Override
	public int totalReply(int bno) {
		return replyMapper.totalReply(bno);
	}

	@Override
	public ReplyVO view(int rno) {
		return replyMapper.selectReply(rno);
	}

	@Override
	public boolean register(ReplyVO rvo) {
		return replyMapper.insertReply(rvo) == 1 ? true : false;
	}

	@Override
	public boolean remove(int rno) {
		return replyMapper.deleteReply(rno) == 1 ? true : false;
	}

	@Override
	public boolean modify(ReplyVO rvo) {
		return replyMapper.updateReply(rvo) == 1 ? true : false;
	}

}
