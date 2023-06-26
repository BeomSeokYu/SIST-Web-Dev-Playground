package javaz.util;

import java.util.ArrayList;
import java.util.Iterator;

class Pizza {
	private String name;
	private String size;
	private int price;
	
	public Pizza(String name, String size, int price) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

public class ListPizza {

	public static void main(String[] args) {
		ArrayList<Pizza> pizzaList = new ArrayList<>();
		pizzaList.add(new Pizza("pizza1", "Large", 10000));
		pizzaList.add(new Pizza("pizza2", "Family", 20000));
		pizzaList.add(new Pizza("pizza3", "Large", 15000));
		System.out.println("------ PIZZA ORDER LIST ------");
		System.out.println("no.\tname\tsize\tprice");
		for (int i = 0; i < pizzaList.size(); i++) {
			System.out.println(i+1 + "\t" + pizzaList.get(i).getName() 
								+ "\t" + pizzaList.get(i).getSize()
								+ "\t" + pizzaList.get(i).getPrice());	
		}
		System.out.println("-----------------------------");
		System.out.println("전체 주문 수량 : " + pizzaList.size());
	}

}
