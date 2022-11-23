package javaz.api;

class RunnableImplements implements Runnable {

	@Override
	public void run() {
		int cnt = 4;
		while(cnt < 7) {
			try {
				System.out.println(Thread.currentThread().getName() + " | " + cnt);
				Thread.sleep(1000);
				cnt++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class RunnableMain {
	
	public static void main(String[] args) {
		//Runnable rt = new Runnable();	//인터페이스 객체 생성 불가
		Runnable rt = new RunnableImplements();	// P = C는 가능
		//rt.start();	// Runnable은 start() 사용 불가
		
		Thread t4 = new Thread(rt, "티사");	// 사용하기 위해 쓰레드 객체로 만들어야 함
		
		Thread t5 = new Thread(new RunnableImplements(), "티오");
		
		System.out.println("티사 우선 순위 : " + t4.getPriority());
		System.out.println("티오 우선 순위 : " + t5.getPriority());
		System.out.println("--------------------------------");
		t4.setPriority(Thread.MAX_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		System.out.println("티사 우선 순위 : " + t4.getPriority());
		System.out.println("티오 우선 순위 : " + t5.getPriority());
		t4.start();
		t5.start();
	}

}
