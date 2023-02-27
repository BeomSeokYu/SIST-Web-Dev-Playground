package com.carshop.domain;

import lombok.Data;

@Data
public class CarDTO {
	private String cid;
	private String cname;
	private String cprice;
	private String ccate;
	private String cdesc;
	
	public CarDTO(String cid, String cname, String cprice, String ccate, String cdesc) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cprice = cprice;
		this.ccate = ccate;
		this.cdesc = cdesc;
	}
}