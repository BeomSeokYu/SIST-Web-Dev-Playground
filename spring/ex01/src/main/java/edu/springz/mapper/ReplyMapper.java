package edu.springz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.springz.domain.ReplyVO;
import edu.springz.domain.Criteria;

public interface ReplyMapper {
	
	public List<ReplyVO> selectReplyAllPaging(	@Param("bno") 		int bno,
												@Param("criteria") 	Criteria criteria );	// 댓글 페이징 해서 가져오기
	
	public int totalReply(int bno);						// 전체 댓글 수 가져오기
	
	public ReplyVO selectReply(int rno);							// 댓글 가져오기
	
	public int insertReply(ReplyVO rvo);							// 댓글 등록 
	
	public int deleteReply(int rno);								// 댓글 삭제

	public int updateReply(ReplyVO rvo);							// 댓글 수정
}
