package edu.springz.domain;

import lombok.Data;

@Data
public class BoardAttachVO {
	private String uuid;
	private int bno;
	private String upFolder;
	private String fileName;
	private String image;
}
