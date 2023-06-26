package javaz.basic;

public class For {
	
//	for
//	- 반복 횟수가 명확한 경우에 주로 사용
//	- 초기식 : 가장 먼저 1회만 수행, 반복 제어 변수의 선언 또는 초기화
//	- 조건식 : 반복의 지속 여부 검사, 조건식이 거짓일 때까지 반복
//	- 증감식 : 반복 제어 변수의 값을 증감 처리
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		System.out.println("--------------------------");
		System.out.println("2 ~ 10까지의 2의 배수");
		for(int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("--------------------------");
		System.out.println("1 ~ 10까지의 2의 배수");
		for(int i = 1; i <= 10; i++) {
			if(i % 3 == 0)	System.out.println(i);
		}
		System.out.println("--------------------------");
		System.out.println("1 ~ 10까지의 모든 정수의 합");
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println("--------------------------");
		System.out.println("구구단 2단 출력");
		for(int i = 1; i < 10; i++) {
			System.out.printf("2 * %d\t= %d\n", i, i*2);
		}
		
		// for 중첩
		
		System.out.println("--------------------------");
		System.out.println("별 찍기");
		for(int i = 1; i < 6; i++) {
			System.out.printf("%d : ", i);
			for(int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------");
		System.out.println("알파벳 찍기");
		char a = 'A';
		for(int i = 0; i < 5; i++) {
			//System.out.printf("%d : ", i);
			for(int j = 0; j < 6; j++) {
				if(a > 'Z') break;
				System.out.print(a++ + " ");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------");
		System.out.println("구구단 9단까지 출력 (세로)");
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j <10; j++) {
				System.out.printf("%d * %d\t= %d\n", i, j, i*j);
			}
			System.out.println();
		}
		
		System.out.println("--------------------------");
		System.out.println("구구단 9단까지 출력 (가로)");
		for(int i = 1; i < 10; i++) {
			for(int j = 2; j <10; j++) {
				System.out.printf("%d * %d\t= %d\t", j, i, i*j);
			}
			System.out.println();
		}
		
		System.out.println("--------------------------");
		System.out.println("구구단 9단까지 출력 (2줄로 출력)");
		for(int i = 1; i < 20; i++) {
			for(int j = 2; j < 10; j++) {
				if(i < 10 && j < 6) {
					System.out.printf("%d * %d\t= %d\t", j, i, i*j);
				} else if(i > 10 && j >= 6) {
					System.out.printf("%d * %d\t= %d\t", j, i, i*j);
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		for(int i = 1; i < 20; i++) {
			if(i < 10) {
				for(int j = 2; j < 6; j++) {
					System.out.printf("%d * %d\t= %d\t", j, i, i*j);
				}
			} else if(i > 10) {
				for(int j = 6; j < 10; j++) {
					System.out.printf("%d * %d\t= %d\t", j, (i-10), (i-10)*j);
				}
			}
			System.out.println();
		}
		
		//foreach문은 배열에서 다룸
	}
}
