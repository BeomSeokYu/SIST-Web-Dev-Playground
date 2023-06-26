package javaz.basic;

public class Variable {

	public static void main(String[] args) {
		// 상수
		// - 변하지 않는 값 하나를 저장하는 메모리 공강
		// - 처음 값을 기억
		// - 선언과 동시에 초기화하거나 생성자에서 초기화
		// - final 및 static과 함께 사용
		final int CON = 10; // 상수
		// CON = 100  // final로 선언된 변수는 재할당 불가
		
		// 변수
		// - 데이터를 저장하는 메모리 공간
		// - 변하는 값을 기억, 마지막 값이 사용됨
		
		// 변수의 이름
		// - 메모리 주소에 붙인 이름
		
		// 변수의 종류
		// - 지역 변수 : 특정 블럭 내에서만 유효한 변수
		// - 매개 변수 : 메소드 호출 시 인자가 전달되어 저장되는 변수
		// - 인스턴스 변수 : 특정 객체가 소유하는 변수
		// - 클래스 변수 : 모든 객체가 공유 static하는 변수
		
		// 데이터 타입
		// - 기본형 (primitive type)
		// boolean, char, byte, short, int, long, float, double
		// - 참조형 (reference type)
		// - 기본형 외 모든 것
		// String, ...
		
		// 변수 선언
		// - 데이터타입 변수이름;
		// - 중괄호 블럭{} 내부에 선언
		// - 데이터타입이 같은 경우 콜론(,)으로 연결해 여러개 선언이 가능하다. (초기화도 가능)
		
		// 변수 초기화 방법
		// - 선언된 변수이름 = 리터럴|변수|연산|특정 메소드의 반환값;
		
		// 변수 선언과 동시에 초기화
		// - 데이터타입 선언된 변수이름 = 리터럴|변수|연산|특정 메소드의 반환값;
		
		// 논리형 변수 tf 선언
		boolean tf;
		// 문자형 변수 c 선언
		char c;
		
		//선언된 변수 초기화 및 사용
			// 초기화하지 않은 지역 변수는 사용할 수 없음
		tf = true;
		c = 'a';
		System.out.println(tf + " , " + c);
		tf = 1 > 4;
		c = '\u0041'; // 유니코드
		System.out.println(tf + " , " + c);
		c = 65; // ASCII
		System.out.println(c);
		c = 0b01000001; // ASCII 65 2진수
		System.out.println(c);
		c = 0101; // ASCII 65 8진수
		System.out.println(c);
		c = 0x41; // ASCII 65 16진수
		System.out.println(c);
		
		// escape sequence
		c = '\n'; // 개행문자
		System.out.print(c);
		c = '\''; // 작은 따옴표 출력
		System.out.print(c);
		c = '\t'; // 탭
		System.out.print(c);
		c = '\\'; // 역슬래시 출력
		System.out.println(c);
		
		// char
		// - 2byte 유니코드 (16진수)
		// - 한글 등 거의 모든 언어 가능
		// - 내부적으로 부호없는 정수 형태 저장
		// - 0 ~ 127까지 ASCII와 호환
		
		//정수형 변수 및 실수형 변수 선언 및 초기화
		byte b = 127;
		short s = 32767;
		int i = 2147483647;
		long l = 9223372036854775807L; //정수 리터럴은 기본이 int이므로 long으로 바꿔주기 위해 접미사 L을 붙여야 함
		System.out.println(b + " " + s + " " + i + " " + l);
		
		float f = 0.1234567890987654321F; ////실수 리터럴은 기본이 double이므로 float로 바꿔주기 위해 접미사 F를 붙여야 함
		double d = 0.1234567890987654321;
		System.out.println(f + " " + d);
		// 0.12345679 0.12345678909876544 과 같은 결과가 나옴 -> 컴퓨터의 실수 표현 방식을 이해해야 함
	}

}
