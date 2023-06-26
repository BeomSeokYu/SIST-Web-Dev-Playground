package javaz.oop;

public class Staticz {
//	static
//	- static field 와 static method 가 있음
//	- 클래스의 모든 객체가 공유
//	- 객체 생성없이 클래스 이름만으로 사용 가능
//	- 객체 생성 이전에 클래스가 로드될 때 메모리에 올라감
//	- this 사용 불가
//	- 사용법
//	[클래스 이름].정적필드이름
//	[클래스 이름].정적메소드이름
	
	String name = "Lee";
	static int age = 10;
	
	// name과 age의 값을 화면에 출력하는 인스턴스 메소드 print
	public void print() {
		System.out.println("name : " + name + ", age : " + age);
	}
	// name과 age의 값을 문자열로 반환하는 정적 메소드 printt
	public static String printt() {
		return "name : " + new Staticz().name + ", age : " + age;
	}
	
	
	public static void main (String[] args) {
		System.out.println(Overloading.PI);
		
		Staticz staticz = new Staticz();
		System.out.println("name : " + staticz.name);
		System.out.println("age : " + age);
		
		staticz.print();
		System.out.println(printt());
		
		//System 
	}
}
