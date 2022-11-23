package javaz.basic;

import java.util.Iterator;

public class BreakContinueReturn {

	public static void main(String[] args) {
//		break
//		- 가까운 switch문 또는 반복문 실행을 중단
//		
//		continue
//		- 반복문 내에서만 사용 - 반복문의 증감식으로 이동
//		
//		return
//		- 현재 수행중인 메소드를 중단하고 호출한 곳으로 제어 반환
		
		System.out.println("1 ~ 100까지의 모든 7의 배수 출력");
		for(int i = 1; i < 101; i++) {
			if(i % 7 == 0)	System.out.print(i + " ");
		}
		
		System.out.println("----------------------------");
		System.out.println("1 ~ 100까지의 모든 7의 배수 출력");
		for(int i = 100; i > 0; i--) {
			if(i % 7 == 0) {
				System.out.print(i + " ");
				break;
			}
		}
		
		System.out.println("----------------------------");
		System.out.println("1 ~ 100까지의 모든 7의 배수 출력 단, 짝수는 제외");
		for(int i = 100; i > 0; i--) {
			if(i % 2 == 0) {
				continue;					// 다음 조건 검사로 이동
			}
			if(i % 7 == 0) {
				System.out.print(i + " ");
				break;
			}
		}
		
		System.out.println("----------------------------");
		System.out.println("반대로 별찍기");
		outer: //외부 포문의 레이블
		for(int i = 1; i < 6; i++) {
			for(int j = 6; j > i; j--) {
				//if (i == 3) break outer; 	// outer레이블로 해당 for문을 중단
				//if (i == 3) return;		// 외부 메소드 중단
				System.out.print("ㅁ");
			}
			System.out.println();
		}
	} 

}
