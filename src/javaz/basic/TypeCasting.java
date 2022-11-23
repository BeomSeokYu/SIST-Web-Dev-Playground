package javaz.basic;

public class TypeCasting {

	public static void main(String[] args) {
		// 자바에서의 연산
		// - 피연산자의 타입이 같아야 가능
		// - 타입이 다른 경우 연산 전에 일치 시킨 후 연산
		// - 자료형끼리의 연산에 주의 필요
		
		// 묵시적 형 변환 (자동 형 변환)
		// - JVM내부에서 자동 수행
		// - 4byte 이하는 int로 바꿔 수행
		// - 정수, 실수의 연산은 실수로 바꿔서 수행
		// - byte >> short >> int >> long >> float >> double
		// - 		  char >> 
		
		// 명시적 형 변환 (강제 형 변환)
		// - 범위가 큰 자료형을 작은 자료형으로 변환
		// - 데이터 손실 발생 가능
		// - (변환하려는 자료형)변수명|리터럴

		byte one = 1;
		byte two = 2;
		// byte sum = one + two;  // 4byte 이하는 int로 바꿔 연산이 수행되므로 오류
		byte sum = (byte) (one + two);  // 강제 형 변환으로 타입을 바꿔줌
		int hamaDul = one + two;	// 자동 형 변환됨
		
		int oneMil = 1000000, twoMil = 2000000;
		int intMil = oneMil * twoMil; // 오버 플로우 발생
		System.out.println(intMil);
		long longMil = (long) oneMil * twoMil; // 명시적 형 변환과 묵시적 형 변환
		System.out.println(longMil);
		
		char ch = 'B';
		System.out.println("문자 " + ch + "의 아스키코드 값 : " + (int)ch);
		int code = 33;
		System.out.println("아스키코드 값 " + code + "의 문자 : " + (char)code);
		
	}

}
