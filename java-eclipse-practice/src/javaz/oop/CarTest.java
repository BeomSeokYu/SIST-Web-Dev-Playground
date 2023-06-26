package javaz.oop;

public class CarTest {

	public static void main(String[] a) {
//		Car sonata = new Car("HyeonDai", "black", true, 4);
//		sonata.start();
//		
		//Car redCar = new Car(4);
		Car redCar = new Car("KIA", "red", true, 4);
		redCar.start();
//		redCar.key = true;
		redCar.start();
		
		//Car blueCar = new Car(2);
		Car blueCar = new Car("HYUNDAI", "blue", true, 2);
//		blueCar.maker = "HyunDai";
//		blueCar.color = "SkyBlue";
//		blueCar.key = true;
		blueCar.start();
		Car blackCar = new Car("MINI", "black", true, 4);
		blackCar.start();
		blackCar.drive();
		blackCar.stop();
	}

}
