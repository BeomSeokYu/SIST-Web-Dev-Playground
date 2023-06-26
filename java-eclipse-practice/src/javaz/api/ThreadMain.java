package javaz.api;

class ThreadExtends extends Thread {
	
	public ThreadExtends() {
	}

	public ThreadExtends(String name) {
		super(name);
	}

	@Override
	public void run() {
		int cnt = 0;
		while(cnt < 3) {
			try {
				System.out.println(getName());
				Thread.sleep(1000);
				cnt++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

public class ThreadMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("---------- Main() Begin ---------");
		
		ThreadExtends t2 = new ThreadExtends();
		t2.setName("티투");
		
		Thread t3 = new ThreadExtends("티삼");
		
		t2.start();
		t3.start();
		
		t2.join();
		t3.join();
		
		Thread t = Thread.currentThread();
		System.out.println("실행 중인 스레드의 이름 : " + t.getName());
		
		System.out.println("---------- Main End ---------");
	}

}