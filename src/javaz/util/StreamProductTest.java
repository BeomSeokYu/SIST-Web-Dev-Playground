package javaz.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product {
	private String name;
	private int price;
	private int bonusPoint;
	
	public Product(String name, int price, int bonusPoint) {
		super();
		this.name = name;
		this.price = price;
		this.bonusPoint = bonusPoint;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	
}

public class StreamProductTest {
	public static void main(String[] args) {
		// 1.Product를 담는 List 타입의 productList 객체 생성
		List<Product> productList = new ArrayList<>();
		// 2.ProduxtList에 Product 객체 3개 생성
		productList.add(new Product("TV", 10000, 0));
		productList.add(new Product("냉장고", 30000, 0));
		productList.add(new Product("컴퓨터", 20000, 0));
		// 3.Product의 가격이 20000 이상인 제품만 담는 newList 객체 생성
		List<Product> newList = productList.stream()
								.filter(o -> o.getPrice() >= 20000)
								.collect(Collectors.toList());
		int sum = productList.stream()
                .mapToInt(Product::getPrice)
                .sum();
		double avg = productList.stream()
		                .mapToInt(Product::getPrice)
		                .average()
		                .getAsDouble();
		// 4.newList 전체 제품의 개수, 가격, 평균 가격 출력
		System.out.println("전체 제품 개수 : " + newList.size());
		System.out.println("-------제품 리스트-------");
		newList.forEach(o -> System.out.println(o.getName() + "의 가격 : " + o.getPrice()));
		System.out.println("----------------------");
		System.out.println("평균 가격 : " + sum/newList.size());
	}
}
