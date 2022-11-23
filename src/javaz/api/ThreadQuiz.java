package javaz.api;

import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

class Quiz extends Thread {
	public static boolean inputFlag;

	@Override
	public void run() {
		// 퀴즈 출제
		String input = new String();
		input = JOptionPane.showInputDialog("자바의 최상위 클래스 이름은 ?\n(제한 시간 : " + Countdown.remainTime + ")");
		do {
			if (input == null) {
				showResult("실행이 취소되었습니다.");
			}
			else {
				if(!input.isEmpty()) {
					inputFlag = true;
					showResult(input.equals("Object") ? "정답입니다!\n입력 : " : "오답입니다!\n입력 : " + input + "\n정답 : Object");
				} else {
					input = JOptionPane.showInputDialog("답을 입력해주세요.\n자바의 최상위 클래스 이름은 ?\n(제한 시간 : " + Countdown.remainTime + ")");
				}
			}
		} while (Countdown.remainTime > 0);
	}
	
	public static void showResult(String s) {
		// 정답 출력
		JOptionPane.showMessageDialog(null, s);
		System.exit(0);
	}
}
class Countdown implements Runnable {
	public static int remainTime = 10;
	@Override
	public void run() {
		for(int i = remainTime; i > 0; i--, remainTime--) {
			System.out.println("남은 시간 : " + remainTime + "초");
			if (Quiz.inputFlag)	break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (!Quiz.inputFlag) {
			System.out.println("- 제한 시간 종료 -");
			Quiz.showResult("- 제한 시간 종료 -\n정답 : 자바의 최상위 클래스는 Object");
		}
	}
	
}

public class ThreadQuiz {

	public static void main(String[] args) {	
		Quiz q = new Quiz();
		q.start();
		Countdown c = new Countdown();
		new Thread(c).start();
	}

}
