package javaz.oop;

public class CounterTest {

	public static void main(String[] args) {
		Counter c1 = new Counter("c1");
		Counter c2 = new Counter("c2");
		new Counter("noname");
	}

}

class Counter {
	
	private String instanceName;
	private static int instanceNum = 0;
	
	public Counter(String instanceName) {
		this.instanceName = instanceName;
		instanceNum++;
		System.out.println("생성된 인스턴스의 이름: " + this.instanceName + " , 누적 인스턴스의 개수: " + instanceNum);
	}
}
