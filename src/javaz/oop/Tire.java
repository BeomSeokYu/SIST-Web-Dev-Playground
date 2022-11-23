package javaz.oop;

public class Tire {
	private String maker;
	private String position;
	
	public Tire(String maker, String position) {
		this.maker = maker;
		this.position = position;
	}
	
	public void setTire() {
		System.out.println(maker + "의 타이어가 " + position + "위치에 장착되었습니다.");
	}
}
