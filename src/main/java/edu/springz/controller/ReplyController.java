package edu.springz.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;
import edu.springz.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies/")
@AllArgsConstructor
@Log4j
public class ReplyController {
	private ReplyService replyService;
	
	@GetMapping(value = "{rno}")
	public ResponseEntity<ReplyVO> view( @PathVariable("rno") int rno ) {
		return 	new ResponseEntity<ReplyVO>(replyService.view(rno), HttpStatus.OK);
	}
	
	@PostMapping(value = "register", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> register( @RequestBody ReplyVO rvo ) {
		return 	replyService.register(rvo)
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH}, produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify( @PathVariable("rno") int rno, @RequestBody ReplyVO rvo ) {
		rvo.setRno(rno);
		return 	replyService.modify(rvo)
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "{rno}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove( @PathVariable("rno") int rno ) {
		return 	replyService.remove(rno)
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "list/{bno}/{pageNum}")
	public ResponseEntity<List<ReplyVO>> list( @PathVariable("bno") int bno, @PathVariable("pageNum") int pageNum ) {
//		ResponseEntity<List<ReplyVO>> resp = null;
//		resp = new ResponseEntity.status(HttpStatus.OK).body(replyService.list(bno, criteria));
		Criteria criteria = new Criteria(3, pageNum);
		//int totalCount = replyService.totalCount(criteria);

		return new ResponseEntity<>(replyService.list(bno, criteria), HttpStatus.OK);
	}
}
