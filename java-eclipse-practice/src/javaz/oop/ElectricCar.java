package javaz.oop;
//상속 (Inheritance)
//- 클래스의 재사용 : 코드의 중복 사용을 줄이고 프로그램의 확장성 향상
//- 기존 클래스의 확장|특화
//- IS-A 관계 : [자식클래스 is a 부모클래스] 가 만족하는 관계
//- 부모 클래스의 필드, 메소드를 자식 클래스가 상속 받아 사용 가능 (생성자는 제외)
//- 단일 상속만 가능
//- UML에서는 자식 클래스에서 부모 클래스로 화살표 표시
//- 자식 클래스에서 부모 클래스의 메소드 오버라이딩 가능
//    - 메소드 오버라이딩
//        - 반환형, 메소드이름, 매개변수가 일치하고 메소드의 내용이 달라야 함.
//        - 접근제어자는 일치하거나 접근 범위가 넓어져야 함
//        - 같은 이름의 필드나 메소드 존재 시 자식 클래스 우선
//- 상속 불가 클래스는 선언 시 final 명시
//- 자바의 최상위 클래스는 java.lang.Object 로 모든 객체가 묵시적 상속 받는다.
public class ElectricCar extends Car {
	private int battery;
	private Tire frontL;
	private Tire frontR;
	private Tire rearL;
	private Tire rearR;
	private Tire[] tires;
	
	public void start() {
		super.start();
		if (battery < 1) {
			System.out.println("배터리를 충전해 주세요.");
			stop();
		}
	}
	public ElectricCar() {}
	public ElectricCar(int battery, Tire frontL, Tire frontR, Tire rearL, Tire rearR) {
		this.battery = battery;
		this.frontL = frontL;
		this.frontR = frontR;
		this.rearL = rearL;
		this.rearR = rearR;
		
		frontL.setTire();
		frontR.setTire();
		rearL.setTire();
		rearR.setTire();
	}
	public ElectricCar(int battery, Tire...tires) {
		this.battery = battery;
		this.tires = tires;
		for(Tire tire : tires) {
			tire.setTire();
		}
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery += battery;
	}
}
