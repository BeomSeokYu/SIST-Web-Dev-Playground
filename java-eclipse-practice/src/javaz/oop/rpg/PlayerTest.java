package javaz.oop.rpg;

public class PlayerTest {

	public static void main(String[] args) {
		Warrior w = new Warrior("Warrior");
		System.out.println(w);
		w.attack();
		w.attack();
		w.attack();
		w.attack();
		w.attack();
		w.attack();
		w.angry();
		w.helpSkill();
		Item.helpItem();
	}

}
