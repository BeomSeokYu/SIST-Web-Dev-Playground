package javaz.oop;

public class VarArgsTest {

	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		
		System.out.println("10 + 20 = " + va.sumAll(10, 20));
		System.out.println("10 + 20 + 30 = " + va.sumAll(10, 20, 30));
		
		// 정수형 배열 변수 intArr을 생성하면서 1,2,3,4,5로 초기화
		// VarArgs 클래스에 배열을 받는 메소드를 호출하여 반환되는 값을 화면에 출력
		
		int[] intArr = {1, 2, 3, 4, 5};
		double[] douArr = {1.0, 2.0, 3.0, 4.0, 5.0};
		System.out.println("1 + 2 + 3 + 4 + 5 = " + va.sumAll(intArr));
		System.out.println("1 + 2 + 3 + 4 + 5 = " + va.sumAll(1.0, 2.0, 3.0, 4.0, 5.0));
		System.out.println("1 + 2 + 3 + 4 + 5 = " + va.sumAll(douArr));
		
	}
}
