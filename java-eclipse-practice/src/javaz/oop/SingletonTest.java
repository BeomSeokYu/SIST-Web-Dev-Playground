package javaz.oop;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton s0 = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		
		System.out.println(s0);
		System.out.println(s1);
		
		Car car1 = new Car();
		Car car2 = new Car();
		
		System.out.println(car1);
		System.out.println(car2);
	}

}
