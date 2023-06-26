package javaz.api;

public class ThreadRunnableAnony {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				int cnt = 11;
				while(cnt < 16) {
					try {
						System.out.println(Thread.currentThread().getName() + " | " + cnt);
						Thread.sleep(1000);
						cnt++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		};
		new Thread(r, "myRun").start();
		
		new Thread("myThr") {
			@Override
			public void run() {
				int cnt = 16;
				while(cnt < 21) {
					try {
						System.out.println(Thread.currentThread().getName() + " | " + cnt);
						Thread.sleep(1000);
						cnt++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
