package javaz.oop;

public class Overloading {
	final static double PI = 3.1415926535;
	private String type;
	
	public Overloading() {}
	
	public Overloading(String type) {
		this.type = type;
	}
	
	
	public void area() {
		System.out.println("--- 넓이 구하기 ---");
	}
	
	public void area(int x) {
		//System.out.println("--- 정사각형 넓이 구하기 ---");
		System.out.println(x*x);
	}
	
	public void area(double r) {
		//System.out.println("--- 원 넓이 구하기 ---");
		System.out.printf("%.2f\n", (float)PI * r * r);
	}
	
	public void area(int x, int h) {
		//System.out.println("--- 삼각형 넓이 구하기 ---");
		System.out.printf("%.1f\n", (float)(x * h)/2);
	}
	
	public String toString() {
		return "타입 : " + type;
	}
}
