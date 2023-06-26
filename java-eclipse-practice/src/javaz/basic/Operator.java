package javaz.basic;

public class Operator {

	public static void main(String[] args) {
		// 연산자
		// - 특정 연산을 나타내는 기호
		// - 우선 순위가 높은 연산자 먼저 계산
		// - 동일 우선 순위에서는 왼쪽에서 오른쪽으로
		// - 대입 연산자는 가장 마지막에 수행
		// - ( )를 사용헤서 우선 순위 조절
		
		// 부호 연산자
		// + : 피연산자에 1 곱하기
		// - : 피연산자에 -1 곱하기
		int booho = 3;
		System.out.println(+booho);
		System.out.println(-booho);
		
		// 산술 연산자
		// +, -, *, / : 사칙연산
		int divide = 7 + 6 - 5 * 4 / 3;
		int modulo = 7 + 6 - 5 * 4 % 3;
		System.out.printf("%d\n%d\n", divide, modulo);
		// 0 또는 0.0으로 나누기 또는 나머지 구하기 조심
//		System.out.println(divide / 0); // ArithmeticException 0으로 나누기 예외 발생
		System.out.println(divide / 0.0); // Infinity 출력 / Double.isInfinite()로 체크
		System.out.println(modulo % 0.0); // NaN 출력 (Not a Number) / Double.isNan()으로 체크
		
		int time = 3695; // 3695초
		int h = time/3600;
		int m = (time%3600)/60;
		int s = (time%3600)%60;
		System.out.printf("%d 초는 %d시간 %d분 %d초\n", time, h, m, s);
		
		// 증감 연산자
		// ++ 변수의 값을 1 증가
		// -- 변수의 값을 1 감소
		// 연산자의 위치에 따라 결과 값이 달라짐
		int year = 2022;
		System.out.println("last year : " + --year); // 해당 줄에서 즉시 감소
		System.out.println("last year : " + ++year); // 해당 줄에서 즉시 증가
		System.out.println("last year : " + year--); // 다음 명령에서 감소
		System.out.println("last year : " + year++); // 다음 명령에서 증가
		System.out.println("last year : " + year);
		
		// 대입 연산자
		// - 변수의 값 또는 수식의 연산 결과를 변수에 저장
		// - 다른 연산자와 결합하여 사용 가능 (+=, -+, *=, /=, %=)
		int i = 1;
		System.out.println(i);
		System.out.println(i = i + 1);
		System.out.println(i += 1);
		System.out.println(i = i + 1);
		
		// 비교 연산자
		// - 비교 결과 true 또는  false 반환
		// >, <, >=, <= : boolean을 제외한 기본형 변수 비교
		// ==, != : 기본형은 값을 비교, 참조형은 주솟값을 비교
		// 			모든 자료형에 사용 가능
		//			단, 문자열 비교 안됨
		// instanceof : 특정 객체의 인스턴스 비교
		String q = "질문) 1부터 10까지의 정수를 모두 더한 값은?";
		int answer = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
		int input = 100;
		boolean result = answer == input;
		System.out.println("입력) " + input);
		System.out.println("정답) " + answer);
		System.out.println("판정) " + result);
		System.out.println(answer != input);
		
		// 논리 연산자
		// - 비교 결과 true 또는  false 반환
		// - 2가지 조건을 비교, 먼저 조건을 만족하면 나머지 검사는 하지 않음
		// && : AND연산 - 모든 조건이 참일 경우 참
		// || : OR연산 - 하나라도 참일 경우 참
		// !  : NOT연산 - 참은 거짓, 거짓은 참
		input = 333;
		boolean baesoo3 = (input % 3) == 0;
		System.out.println(baesoo3);
		// 입력값이 100미만의 3의 배수인가?
		
		baesoo3 = (input < 100) && (input % 3 == 0);
		System.out.println(baesoo3);
		// 입력값이 100이상이거나 3의 배수가 아니거나?
		baesoo3 = (input >= 100) || (input % 3 != 0);
		System.out.println(baesoo3);
		
		char ch = 'x';
		boolean lower, upper, alpha;
		lower = ch >= 'a' && ch <= 'z';
		upper = ch >= 'A' && ch <= 'Z';
		alpha = lower || upper;
		System.out.println("입력 문자 : " + ch);
		System.out.println("소문자? : " + lower);
		System.out.println("대문자? : " + upper);
		System.out.println("알파벳? : " + alpha);
		
		// 비트 연산자
		// - 2진수 비트 단위 연산
		// - float, double X
		// - 정수값의 특정 위치에 있는 비트 마스크 추출 가능
		// 센서값 검사
		// & : 비트 단위 and연산
		// | : 비트 단위 or연산
		// ~ : 비트 반전
		// ^ : 비트 단위 xor 연산
		int x = 0b0011;
		int y = 0b0010;
		System.out.println(~x);
		System.out.println(~y);
		System.out.println(x & y);
		System.out.println(x | y);
		System.out.println(x ^ y);
		
		// 비트 이동 연산자
		// - 곱셈 또는 나눗셈 연산자보다 빠름
		// << : 왼쪽으로 이동 2의 n제곱 씩 증가 (0으로 채움)
		// >> : 오른쪽으로 이동 2의 -n제곱 씩 증가 (부호 비트 유지)
		// >>> : 오른쪽으로 이동 2의 -n제곱 씩 증가 (부호 비트 유지하지 않고 0으로 채움)
		x = 0b10000000000000000000000000001011;
		System.out.println(x >> 1);
		System.out.println(x << 1);
		System.out.println(x >>> 1);
		
		// 조건(삼항) 연산자
		// 3개의 연산자 필요
		// (조건식) ? (참일 경우) : (거짓일 경우);
		x = -3;
		y = -4;
		int absX, max, min;
		absX = x >= 0 ? x : -x;
		System.out.println(absX);
		max = x > y ? x : y;
		System.out.println(max);
		min = x < y ? x : y;
		System.out.println(min);
		
		x = 5;
		ch = (x % 2 == 0) ? '짝' : '홀';
		System.out.println(ch);
		
		// 윤년 계산 ---------------
		// - 특정 연도를 4로 나누어 나머지가 없고
		// 100으로 나눠서 나머지가 있으면 윤년
		// 단 400으로 나눠서 나머지가 없으면 윤년
		y = 2022;
		ch = (y % 4 == 0 && y % 100 != 0) || y % 400 == 0 ? 'O' : 'X';
		System.out.println(ch);
		
	}

}
