package javaz.oop.rpg;

public abstract class Player implements Skill, Item{
	private int x;
	private int y;
	private int heart;
	private int power;
	private int gold;
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
	
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold += gold;
		System.out.println("[" + name + "] GOLD 보유량 : " + this.gold);
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


class Warrior extends Player {

	public Warrior(String name) {
		super(name);
	}

	@Override
	public void move(int x, int y) {
		setX(x);
		setY(y);
		System.out.println(this);
	}

	@Override
	public void attack() {
		if(getHeart() > 0) {
			System.out.println("공격합니다.");
			setPower(1);
			setGold(1);
			setHeart(-1);
		} else {
			System.out.println("Heart가 부족합니다.");
		}
	}
	
	public void angry() {
		setPower(3);
	}
	
}