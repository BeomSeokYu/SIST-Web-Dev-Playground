package javaz.oop;

public class CallByValueReference {
	
	public static void main(String[] args) {
		int medium = 15;
		int large  = 20;
		
		Pizza shrimpPizza = new Pizza(medium, "Shrimp Pizza");
		Pizza potatoPizza = new Pizza(large, "Potato Pizza");
		
		Pizza largePizza = Pizza.getLargePizza(shrimpPizza, potatoPizza);
		System.out.println("쉬림프 피자의 크기 : " + shrimpPizza.getRadius());
		System.out.println("포테이토 피자의 크기 : " + potatoPizza.getRadius());
		System.out.println("둘 중 더 큰 피자 : " + largePizza.getName());
		
		Pizza.makeLargePizza(shrimpPizza, large);
		Pizza.makeLargePizza(potatoPizza, large);
		System.out.println();
		System.out.println("쉬림프 피자의 크기 : " + shrimpPizza.getRadius());
		System.out.println("포테이토 피자의 크기 : " + potatoPizza.getRadius());
		System.out.println();
		Pizza.setRadius(potatoPizza, 50);
		System.out.println("포테이토 피자의 크기 : " + potatoPizza.getRadius());
		System.out.println("라지 피자의 크기 : " + largePizza.getRadius());
	}
	
}