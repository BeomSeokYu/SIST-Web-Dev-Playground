package javaz.oop;

public abstract class Animal {
	String name;
	String place;
	String food;
	
	public Animal() {}
	public Animal(String name, String place, String food) {
		super();
		this.name = name;
		this.place = place;
		this.food = food;
	}

	public abstract void move();
	
	public void eat(String food) {
		System.out.println(name + "이 " + food + "를 먹습니다.");
	}
}

class Dolphin extends Animal {
	
	public Dolphin(String name, String place, String food) {
		this.name = name;
		this.place = place;
		this.food = food;
	}

	@Override
	public void move() {
		System.out.println(name + "이라는 돌고래가 헤엄칩니다.");
	}
	
	public void speak() {
		System.out.println(name + "이라는 돌고래가 초음파를 냅니다.");
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", place=" + place + ", food=" + food + "]";
	}
}

class Dog extends Animal {
	
	public Dog(String name, String place, String food) {
		this.name = name;
		this.place = place;
		this.food = food;
	}

	@Override
	public void move() {
		System.out.println(name + "이라는 개가 네 다리로 뜁니다.");
	}
	
	public void bark() {
		System.out.println(name + " : 왈!왈!");
	}
}