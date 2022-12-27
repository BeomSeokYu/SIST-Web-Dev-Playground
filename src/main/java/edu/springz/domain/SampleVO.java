package edu.springz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SampleVO {
	private int sno;
	private String firstName;
	private String lastName;
	
	public SampleVO() {
	}
}
