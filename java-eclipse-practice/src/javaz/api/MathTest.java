package javaz.api;

import java.lang.Math;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(Math.ceil(3.14));
		System.out.println(Math.floor(3.64));
		System.out.println(Math.round(0));
		
		System.out.println((int)(Math.random()*10)%3);
		System.out.println((int)(Math.random()*10)%3+1);
		System.out.println((int)(Math.random()*10)%3+10);
		
		System.out.println("-------------------------------");
		System.out.println("로또 번호 생성 ");
		int[] lottoNum = new int[7];
		int[] lottoWin = {2, 14, 15, 22, 27, 33};
		int bomusNum = 31;
		int i = 0;
		while(lottoNum[6] == 0) { // 6번째 숫자가 0이 아닐 때까지 반복
			boolean in = false;
			int num = (int)(Math.ceil(Math.random()*45));
			for(int j = 0; j <= i; j++)	//중복 체크
				if(lottoNum[j] == num) in = true;
			if(in) continue;	// 중복이 있으면 다시
			lottoNum[i] = num;
			i++;
		}
		// 오름차순 정렬 (버블 정렬)
		for (int j = 0; j < lottoWin.length; j++) {
			for (int k = 1; k < lottoWin.length-j; k++) {
				if(lottoNum[k-1] > lottoNum[k]) {
					int temp = lottoNum[k-1];
					lottoNum[k-1] = lottoNum[k];
					lottoNum[k] = temp;
				}
			}
		}
		for (int j = 0; j < lottoNum.length-1; j++) {
			System.out.print(lottoNum[j] + " ");
		}
		System.out.println();
		System.out.println("-------------------------------");
		System.out.print("당첨 결과 : ");
		int matchNum = 0;
		for(int j = 0; j < lottoWin.length; j++) {
			for(int k = j; k < lottoWin.length; k++) {
				if (lottoNum[j] == lottoWin[k]) {
					matchNum++;
				}
			}
		}
		switch (matchNum) {
		case 6:
			System.out.print("1등 | " + matchNum + " 일치"); 	break;
		case 5:
			if (bomusNum == lottoNum[6])
				System.out.print("2등 | " + matchNum + " 일치 + 보너스");
			else
				System.out.print("3등 | " + matchNum + " 일치");
			break;
		case 4:
			System.out.print("4등 | " + matchNum + " 일치"); 	break;
		case 3:
			System.out.print("5등 | " + matchNum + " 일치");	break;
		default:
			System.out.print("꽝 | " + matchNum + " 일치");	break;
		}
	}
}
