package javaz.util;

class ThreadA extends Thread {

	@Override
	public void run() {
		System.out.println("ThreadA class");
	}
	
}

class RunnableB implements Runnable {

	@Override
	public void run() {
		System.out.println("RunnableB class");
	}
	
}

@FunctionalInterface
interface interfaceA {
	public void method();
}

@FunctionalInterface
interface interfaceB {
	public void method(int x);
}

@FunctionalInterface
interface interfaceC {
	public String method(int x);
}

@FunctionalInterface
interface interfaceD {
	public int method(int x, int y);
}

public class LambdaTest {
	
	public static void main(String[] args) {
		new ThreadA().start();
		
		new Thread(new RunnableB()).start();
		
		Thread a = new Thread() {
			@Override
			public void run() {
				System.out.println("Anony class");
			}
		};
		a.start();
		
		new Thread(new RunnableB() {
			@Override
			public void run() {
				System.out.println("Anony class2");
			}
		}).start();

		new Thread(() -> System.out.println("Lambda class")).start();
		
		interfaceA ia = () -> System.out.println("Lambda interfaceA");
		ia.method();
		
		interfaceB ib = x -> System.out.println("받은 매개변수 : " + x);
		ib.method(999);
		
		interfaceC ic = x -> "받은 매개변수 반환 : " + x;
		System.out.println(ic.method(999));
		
		interfaceD id = (x, y) -> x + y;
		System.out.println(id.method(3, 5));
	}

}
