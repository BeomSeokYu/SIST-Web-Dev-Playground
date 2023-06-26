package javaz.api;

class MoneyBox {
	int money;
	
	public void deposit(int money) {
		this.money += money;
	}
}

class MoneyMoa extends Thread {
	private MoneyBox moneyBox;

	public MoneyMoa(String name, MoneyBox moneyBox) {
		super(name);
		this.moneyBox = moneyBox;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
//			moneyBox.money++;
//			synchronized (moneyBox) {
//				moneyBox.money++;
//				System.out.println(getName() + " : " + moneyBox.money);
//			}
			synchronized (moneyBox) {
				moneyBox.deposit(1);
				System.out.println(getName() + " : " + moneyBox.money);
			}
		}
	}
}

public class ThreadSynch {

	public static void main(String[] args) {
		MoneyBox mb = new MoneyBox();
		new MoneyMoa("Ann", mb).start();
		new MoneyMoa("Ben", mb).start();
//		new MoneyMoa("T3", mb).start();
//		new MoneyMoa("T4", mb).start();
	}

}
