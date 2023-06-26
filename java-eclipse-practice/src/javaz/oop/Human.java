package javaz.oop;

public class Human extends Animal {
	
	public Human() {
	}
	
	public Human(String name, String place, String food) {
		super(name, place, food);
	}

	@Override
	public void move() {
		System.out.println(name + "이라는 사람이 두 발로 걷습니다.");
	}
	
	public void study() {
		System.out.println(name + "이라는 사람이 공부를 합니다.");
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", place=" + place + ", food=" + food + "]";
	}
	
}
