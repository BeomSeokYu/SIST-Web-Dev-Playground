package com.carshop.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CarDTO {
	private String cid;
	private String cname;
	private String cprice;
	private String ccate;
	private String cdesc;
	private MultipartFile carImage;
	
	public CarDTO(String cid, String cname, String cprice, String ccate, String cdesc, MultipartFile carImage) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cprice = cprice;
		this.ccate = ccate;
		this.cdesc = cdesc;
		this.carImage = carImage;
	}
}