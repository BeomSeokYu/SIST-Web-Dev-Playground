package javaz.basic;

public class OperatorExam {

	public static void main(String[] args) {
		// 가성비 피자 주문하기
		// - 미디엄 피자 : 반지름 20cm, 10000원
		// - 라지 피자 : 반지름 40cm, 20000원
		// 예산 20000원
		final double PI = 3.141592;
		double midPizza = (PI * 0.2 * 0.2) * 2;
		double larPizza = (PI * 0.4 * 0.4);
		System.out.println("----- PIZZA MENU -----");
		System.out.println("미디엄 피자\t10000원");
		System.out.println("라지 피자\t20000원");
		System.out.println("미디엄 피자 2판의 면적 : " + midPizza + "m^2");
		System.out.println("라지 피자 1판의 면적 : " + larPizza + "m^2");
		String result =  midPizza > larPizza ? "미디엄 피자 2판" : "라지 피자 1판";
		System.out.println("가성비 피자 : " + result);
		System.out.println();
		
		
		
		System.out.println("----- 동전 출금 -----");
		System.out.println("출금액 : 7,777원");
		System.out.println("-------------------");
		int a = 7777;
		System.out.println("오백원 : \t" + a/500);
		System.out.println("백원 : \t" + (a%500)/100);
		System.out.println("오십원 : \t" + ((a%500)%100)/50);
		System.out.println("십원 : \t" + (((a%500)%100)%50)/10);
		System.out.println("남은 금액 : " + (((a%500)%100)%50)%10 + "원");
		System.out.println("-------------------");

	}

}
