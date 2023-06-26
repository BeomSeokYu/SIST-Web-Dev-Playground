package javaz.oop.rpg;

public interface Character {
	public static final int DEFAULT_HEART = 5;
	int DEFAULT_POWER = 5; //public static final 생략해도 같음
}

interface Move {
	//public abstract void move(int x, int y);
	void move(int x, int y); //public abstract 생략해도 같음
}

interface Attack {
	void attack();
}

interface Skill extends Move, Attack {
	default void helpSkill() {
		System.out.println("[스킬 도움말] 공격과 이동 중에 선택 가능!");
	}
	
	static void helpItem() {
		System.out.println("[아이템 도움말] 골드로 아이템 구매 가능!");
	}
}

interface Item {
	int POTION = 100;
	int SWORD = 200;
	
	static void helpItem() {
		System.out.println("[아이템 도움말] 골드로 아이템 구매 가능!");
	}
}