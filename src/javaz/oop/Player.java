package javaz.oop;

import javaz.oop.rpg.Character;

public abstract class Player {
	private int x;
	private int y;
	private int heart;
	private int power;
	private String name;
	
	public Player(String name) {
		this.name = name;
		heart = Character.DEFAULT_HEART;
		power = Character.DEFAULT_POWER;
		
		System.out.println("=== My RPG Character ===");
		System.out.println("캐릭터\t : " + name);
		System.out.print("HEART\t : ");
		for (int i = 0; i < heart; i++) {
			System.out.print("♥");
		}
		System.out.println();
		System.out.print("POWER\t : ");
		for (int i = 0; i < power; i++) {
			System.out.print("○");
		}
		System.out.println("\n");
	}
	
	public abstract void move(int x, int y);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart += heart;
		String s = "[" + name + "] HEART " + heart + " " + (heart > 0 ? "증가" : "감소") + " \t| ";
		for (int i = 0; i < this.heart; i++) {
			s +="♥";
		}
		System.out.println(s);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power += power;
		String s = "[" + name + "] HEART " + power + " " + (power > 0 ? "증가" : "감소") + " \t| ";
		for (int i = 0; i < this.power; i++) {
			s +="○";
		}
		System.out.println(s);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + name + "] 이동 - x좌표: " + x + " , y좌표: " + y;
	}
	
}

class Princess extends Player {

	public Princess(String name) {
		super(name);
	}

	@Override
	public void move(int x, int y) {
		if(getPower() > 0) {
			setPower(-1);
			setHeart(1);
			setX(x);
			setY(y);
			System.out.println(this);
		} else {
			System.out.println("Power가 부족합니다.");
		}
	}
	
	public void sleep() {
		setPower(5);
	}
	
}

class Shooter extends Player {
	
	public Shooter(String name) {
		super(name);
	}

	@Override
	public void move(int x, int y) {
		setPower(1);
		setHeart(1);
		setX(x);
		setY(y);
		System.out.println(this);
	}
	
	public void attack() {
		if(getPower() > 0) {
			setPower(-1);
		}
	}


}