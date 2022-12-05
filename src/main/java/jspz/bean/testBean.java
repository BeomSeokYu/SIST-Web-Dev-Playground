package jspz.bean;

public class testBean {
	private String country;
	private String city;
	private String name;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "국가 : " + getCountry() + " / 도시 : " + getCity() + " / 이름 : " + getName();
	}
}
