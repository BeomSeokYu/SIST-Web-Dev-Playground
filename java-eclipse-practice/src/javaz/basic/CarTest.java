package javaz.basic;

import javaz.oop.Car;

public class CarTest extends Car{

	public static void main(String[] args) {
		CarTest eeCar = new CarTest();
		eeCar.maker = "Kia";
		eeCar.color = "Orange"; // 상속 받아 protected 사용 가능
		//eeCar.key = true;
		//eeCar.door = 4;
		
		Car greenCar = new Car();
		greenCar.maker = "kia";
//		greenCar.color = "green"; // color는 protected
		greenCar.start();
		greenCar.stop();
	}

}
