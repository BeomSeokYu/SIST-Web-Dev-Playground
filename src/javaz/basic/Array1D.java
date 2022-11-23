package javaz.basic;

import java.util.Iterator;

public class Array1D {

	public static void main(String[] args) {
//		배열 (Array)
//		- 같은 자료형의 원소를 정해진 개수만큼 가지고 있는 객체
//		- 여러 개의 저장 공간을 하나의 배열 이름으로 접근
//		- 각각의 공간은 숫자 인덱스(0 부터 시작)를 가져 인덱싱해 접근 가능
//		- 배열이 처음 생성될 때 크기가 정해지고 변경은 불가
//		- 모든 배열은 length라는 필드를 가짐 : 배열의 길이 정보를 저장하는 맴버 변수
//		- 2차원 이상의 배열은 배열의 배열 구조
		
		// 배열의 선언
		int[] scores; 
		// 배열의 생성
		scores = new int[3];
		// 배열의 초기화
		scores[0] = 90;
		scores[1] = 80;
		scores[2] = 77;
		//scores[3] = 4; // ArrayIndexOutOfBoundsException 발생
		for(int i = 0; i < 3; i++) {
			System.out.println(scores[i]);
		}
		System.out.println();
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		// 배열의 선언과 생성
		//int[] scores = new int[3];
		// 배열의 선언과 생성과 초기화
		//int[] scores = new int[] {1, 2, 3, 4, 5};
		//int[] scores = {1, 2, 3, 4, 5}; 
		
		// 이미 선언이된 배열을 재생성 및 초기화
		// scores = {7, 8, 9}; // Array constants can only be used in initializers 오류
		scores = new int[] {7, 8, 9};
		
		System.out.println();
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		System.out.println("---------------------------------");
		String[] users = new String[] {"Ben", "Ken", "Jen"};
		for (int i = 0; i < users.length; i++) {
			System.out.println(users[i]);
		}
		
		
//		foreach문
//		- advanced for를 이용하여 배열 값 출력
		System.out.println("---------------------------------");
		for(String user : users) {
			System.out.println(user);
		}
	}

}
