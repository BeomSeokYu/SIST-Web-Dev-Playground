package javaz.oop;

public class Singleton {
//	싱글톤 패턴
//	- 하나의 프로그램에서 인스턴스가 하나만 존재해야할 경우 사용
//	- 생성자의 접근을 private으로 제한하고 인스턴스를 반환하는 정적 메소드를 사용
//	- 네트워크 연결 pool, thread pool 등에 사용
	
	private static Singleton instance;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
			return instance;
		}
		else {
			return instance;
		}
	}
}
