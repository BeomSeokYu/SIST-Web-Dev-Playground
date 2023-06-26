package javaz.oop;

public class ProductTest {

	public static void main(String[] args) {
		TV tv = new TV();
		Notebook notebook = new Notebook();
		Monitor monitor = new Monitor();
		
		Buyer b1 = new Buyer();
		
		b1.buy(tv);
		b1.buy(notebook);
		b1.buy(monitor);
		
		Buyer b2 = new Buyer();
	}

}

class Product {
	private String name;
	private int price;
	private int bonusPoint;
}

class TV extends Product {
	
}

class Notebook extends Product {
	
}

class Monitor extends Product {
	
}

class Buyer {
	int money = 10000;
	int bonusPoint = 0;
	
	public void buy(Product product) {
		System.out.println(product.getClass().getSimpleName() + "제품을 구매합니다.");
	}
}