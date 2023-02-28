package com.carshop.domain;

import lombok.Data;

@Data
public class BoardDTO {
	private String bno;
	private String btitle;
	private String bcontent;
	private String bauthor;
	
	public BoardDTO(String bno, String btitle, String bcontent, String bauthor) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bauthor = bauthor;
	}
}