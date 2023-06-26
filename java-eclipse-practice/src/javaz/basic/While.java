package javaz.basic;

public class While {

	public static void main(String[] args) {
//		while문
//		- 특정 조건에 따른 단순 반복 처리에 주로 사용
//		- 무한 반복에 많이 사용
//		
//		do ~ while문
//		- 최초 1회 실행을 무조건 보장
//		- 조건 검사를 마지막에 실행
		
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("----------------------------");
		do {
			System.out.println(i);
			i++;
		} while (i <= 10);
		
		System.out.println("----------------------------");
		do {
			System.out.println(i);  // 한번은 실행된다.
			i++;
		} while (i <= 4);
		
		System.out.println(" - PLAY GAME WHILE - ");
		char yesNo = 'n';
		do {
			System.out.println(">> 게임을 시작합니다.");
			System.out.println(">> 게임이 종료되었습니다.");
			System.out.println(">> 계속 하시겠습니까? (Y/n)");
		} while (yesNo != 'n');
		System.out.println(">> 종료되었습니다.");
		
		System.out.println("----------------------------");
		i = 10;
		while(i > 0) {
			System.out.println(i--);
			if(i == 0) System.out.println("fire!");
		}

	}

}
