package javaz.oop;

public class ElectricCarTest {

	public static void main(String[] args) {
		Car car = new Car();
		ElectricCar eCar = new ElectricCar();
		car.maker = "HyunDai";
		car.color = "blue";
		car.key = true;
		eCar.maker = "Kia";
		eCar.color = "yellow";
		eCar.key = true;
		
		System.out.println("전기차 eCar의 현재 배터리 : " + eCar.getBattery());
		eCar.start();
		eCar.setBattery(100);
		System.out.println("전기차 eCar의 현재 배터리 : " + eCar.getBattery());
		
		System.out.println("=============================================================");
		System.out.println("- 한국타이어가 모두 장착된 바퀴 4개짜리 전기차 만들기 -");
		Tire frontL = new Tire("HanKook", "Front-Left");
		Tire frontR = new Tire("HanKook", "Front-Right");
		Tire rearL = new Tire("HanKook", "Rear-Left");
		Tire rearR = new Tire("HanKook", "Rear-Right");
		ElectricCar nCar = new ElectricCar(100, frontL, frontR, rearL, rearR);
		System.out.println("=============================================================");
		System.out.println("- 미쉐린 타이어가 장착된 바퀴 3개짜리 전기차 만들기 -");
		ElectricCar mCar = new ElectricCar(80, 	new Tire("Michelin", "Front-Center"),
												new Tire("Michelin", "Rear-Left"),
												new Tire("Michelin", "Rear-Right"));
	}

}
