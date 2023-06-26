package javaz.api;

import java.io.IOException;
import java.util.Arrays;

public class StringExercise {
	
	public void printBirthInfo(String idNo) {
		String s = "";
		s += idNo + "|";
		if (idNo.charAt(7) == '1' || idNo.charAt(7) == '2') {
			s += "19";
		} else {
			s += "20";
		}
		s += idNo.subSequence(0, 2) + "|";
		s += idNo.subSequence(2, 4) + "|";
		s += idNo.subSequence(4, 6) + "|";
		if (idNo.charAt(7) == '1' || idNo.charAt(7) == '3') {
			s += "남성";
		} else {
			s += "여성";
		}
		System.out.println(s);
	}
	
	public static void printFilrInfo(String filename) {
		int dot = filename.lastIndexOf(".");
		System.out.println("파일정보 : " + filename);
		System.out.println("파일명 : " + filename.substring(0, dot));
		System.out.println("확장자명 : " + filename.substring(dot+1));
	}
	
	public static void main(String[] args) {
		// 1. 주민들록번호에서 출생년도, 월, 일, 성별 추출
		StringExercise se = new StringExercise();
		System.out.println("주민등록번호|출생년도|월|일|성별");
		for (String arg : args) {
			se.printBirthInfo(arg);
		}
		System.out.println();
		// 2, 파일정보에서 파일명과 확장자 분리
		String file1 = "my.music.best.one.mp3";
		String file2 = "long_long_file_two.mpeg";
		StringExercise.printFilrInfo(file1);
		StringExercise.printFilrInfo(file2);
	}

}
