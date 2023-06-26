package javaz.api;

import java.io.IOException;

public class GameCenter {
	private int input;		// 입력
	private char yesNo;		// 계임 계속 여부
	private String result;	// 게임 결과
	
	public static void main(String[] args) {
		try {
			new GameCenter().manu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void baseBall() {
		System.out.println(">> 자바 야구 게임!!!!!!");
		System.out.println(">> 준비중입니다.");
		System.out.println();
	}

	public void gawiBawiBo() throws IOException {
		String[] gbb = {"가위", "바위", "보"};
		int me = -1;
		int cpu = -1;
		do {
			System.out.println(">> 컴퓨터와 가위 바위 보!!!!!!");
			System.out.println(">> 가위(0), 바위(1), 보(2) 중에 하나를 선택하세요.");
			while (true) {
				System.out.print(">> 선택 : ");
				me = System.in.read()-48;
				System.in.skip(2);
				if (me >= 0 && me <= 2)	break;
				else					System.out.println(">> 0 ~ 2 중에 하나를 선택해 주세요.");
			}
			cpu = (int)(Math.random()*3);
			System.out.println(cpu);
			System.out.println("  ---------------------------------");
			System.out.println("   you : " + gbb[me] + "\t vs. \t com : " + gbb[cpu]);
			if (me - cpu == 1 || me - cpu == -2) 		result = "이겼습니다.";
			else if (me - cpu == -1 || me - cpu == 2) 	result = "졌습니다";
			else 										result = "비겼습니다";
			System.out.println("\t\t" + result);
			System.out.println("  ---------------------------------");
			System.out.println();
			System.out.print("계속하려면 y, 그만하면 아무거나 입력해주세요. : ");
			yesNo = (char) System.in.read();
			System.in.skip(2);
		} while (yesNo == 'y');
	}
	
	public void manu() throws IOException {
		while(true) {
			System.out.println("ㅁㅁㅁㅁㅁㅁㅁJAVA GAME CENTERㅁㅁㅁㅁㅁㅁㅁ");
			System.out.println("  1. 가위 바위 보 게임");
			System.out.println("  2. 야구 게임");
			System.out.println("  3. 종료");
			System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
			System.out.print(">> 선택 : ");
			input = System.in.read();
			System.in.skip(2);
			switch (input) {
			case '1' :	gawiBawiBo();	break;
			case '2' :	baseBall();		break;
			case '3' :	System.out.println(">> 게임을 종료되었습니다.");
						System.exit(0);
			default :   System.out.println(">> 1 ~ 3 중에 하나를 선택해 주세요.\n");
			            break;
			}
		}
	}

}
