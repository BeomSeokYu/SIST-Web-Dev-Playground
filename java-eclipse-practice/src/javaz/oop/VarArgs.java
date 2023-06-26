package javaz.oop;

public class VarArgs {
	// 정수 두 개를 받아서 더한 값을 반환하는 sumAll 메소드
	public int sumAll(int a, int b) {
		return a + b;
	}
	// 정수 세 개를 받아서 더한 값을 반환하는 sumAll 메소드
	public int sumAll(int a, int b, int c) {
		return a + b + c;
	}
	
	//정수형 배열을 매개변수로 받아 모두 더한 값을 반환하는 sumAll 메소드
	public int sumAll(int[] a) {
		int result = 0;
		for(int i : a) {
			result += i;
		}
		return result;
	}
	
	public int sumAll(double ... ds) {
		int result = 0;
		for (double d : ds) {
			result += d;
		}
		return result;
	}
}
