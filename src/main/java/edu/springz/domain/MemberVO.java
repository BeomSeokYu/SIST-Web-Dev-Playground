package edu.springz.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String Name;
	private Date regDate;
	private Date updateDate;
	private boolean enable;
	private List<AuthVO> authList;
}
