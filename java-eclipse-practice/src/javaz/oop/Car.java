package javaz.oop;
//	클래스
//	[접근제어자] [클래스 종류] class 클래스이름 [extends 부모클래스이름] [implements 인터페이스 이름1, …] { 
//		맴버 변수
//		생성자
//		메소드
//	}
//	- 접근제어자 : public, default/package/생략
//	- 클래스 종류 : final, abstract

//	- 필드 = 상태 = 멤버 변수 = 속성 = attribute = property
//	- [접근제어자] [필드종류] 데이터타입 핑드명 [= 초기값]
//	    - 접근제어자 : public, private, protected, default/package/생략
//	    - 필드 종류 : final, static, transient

//	- 생성자
//	- [접근제어자] 생성자이름( [매개변수타입 매개변수명1 …] ) { 수행 구문 }
//	    - 접근제어자 : public, private, protected, default/package/생략

//	- 메소드 = 동작 = 기능 = function = behavior
//	- [접근제어자] [메소드종류] 반환타입 메소드이름 ( [매개변수타입 매개변수명1 …] ) [throws 예외이름] { 수행 구문 [return 반환값|변수;]}
//	    - 접근제어자 : public, private, protected, default/package/생략
//	    - 메소드종류 : final, static, transient, synchronized
public class Car {
	// 객체 변수, 멤버 변수, 속성, 필드 등
	public String maker;
	protected String color;
	boolean key;
	private int door;
	
	// Constroctor
	public Car(){
		System.out.println("자동차가 생성되었습니다.");
	}
	// Constroctor Overloading
	public Car(int door){
		this(); // 기본 생성자 
		this.door = door;
	}
	public Car(String maker, String color, boolean key, int door) {
		this();
		this.maker = maker;
		this.color = color;
		this.key = key;
		this.door = door;
	}
	
	// Method
	public void start() {
		if (key) {
			System.out.println("출발합니다.");
			drive();
		} else {
			System.out.println("키가 없습니다.");
		}
	}
	public void stop() {
		System.out.println("멈춥니다.");
	}
	public void drive () {
		System.out.println("운전 중 입니다.");
	}
	// getter, setter
	public void setDoor(int door) {
		this.door = door;
	}
	public int getDoor() {
		return door;
	}
}
