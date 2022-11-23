package javaz.oop;

public class Person {
	private String name;
	private String phoneNum;
	
	public Person() {
	}

	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}
