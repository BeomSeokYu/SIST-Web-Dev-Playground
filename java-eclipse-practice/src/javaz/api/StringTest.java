package javaz.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest {
	static String nullStr;
	static String emptyStr = "";
	
	public static void main(String[] args) throws UnsupportedEncodingException {
//		System.out.println("|" +nullStr+ "|");
//		System.out.println("|" +emptyStr+ "|");
//		
//		//nullStr.length();
//		System.out.println(emptyStr.length());
//		
//		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
//		String str1 = new String(bytes); 		//파일에서 내용을 읽거나, 네트워크를 통해 데이터를 받을 때 보통 byte 배열 사용
//		System.out.println(str1);
//		String str2 = new String(bytes, 0, 5);	//특정 문자셋을 지정
//		System.out.println(str2);
//		String str3;
//		try {
//			str3 = new String(bytes, 6, 4, "UTF-8");
//			System.out.println(str3);
//		} catch (UnsupportedEncodingException e) {
//			System.err.println("지원하지 않는 문자셋입니다.");
//		}
//		
//		System.out.println();
//		
//		byte[] byteArr = new byte[100];
//		System.out.print("입력 : ");
//		try {
//			int inputBytes = System.in.read(byteArr);	// 입력 문자 개수 반환 : 개행문자와 캐리지리턴이 포함되어있음 /n/r
//			System.out.println(inputBytes);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(new String(byteArr));
//		System.out.println("========================================");
		String pw1 = "top secret ";
		String pw2 = "HELLO#password-1234,5678";
		System.out.println(pw1.length());
		System.out.println(pw2.length());
		System.out.println(pw1.equals(pw2));
		System.out.println(pw2.equalsIgnoreCase(pw2));
		System.out.println(pw1.indexOf("t"));
		System.out.println(pw1.lastIndexOf("t"));
		System.out.println(pw1.charAt(4));
		System.out.println(pw1.substring(4));
		System.out.println(pw1.charAt(4));
		
		String[] tokens = pw1.split(" ");
		for (String token : tokens) {
			System.out.println(token);
		}
		String[] tokens2 = pw2.split("#|-|,");
		for (String token : tokens2) {
			System.out.println(token);
		}
		System.out.println();
		System.out.println("---문자열 변환---");
		System.out.println(pw2);
		System.out.println(pw2.replace("word", "PORT"));
		System.out.println(pw1.trim());
		
		// 다른 자료형 문자열로 변경
		System.out.println(String.valueOf(123));
		System.out.println(String.valueOf(1.23));
		System.out.println(String.valueOf(1.23f));
		System.out.println(String.valueOf(true));
		
		System.out.println(123 + ""); // 자동 형 변환 이용
		
		System.out.println();
		System.out.println("---문자열을 바이트 배열로 변환---");
		String str = "문자열";
		byte[] byte1 = str.getBytes();
		byte[] byte2 = str.getBytes("UTF-8");
		byte[] byte3 = str.getBytes("EUC-KR");
		System.out.println(Arrays.toString(byte1));
		System.out.println(Arrays.toString(byte2));
		System.out.println(Arrays.toString(byte3));
		
		System.out.println();
		System.out.println("---바이트 배열을 문자열로 변환---");
		System.out.println(new String(byte1));
		System.out.println(new String(byte2));
		System.out.println(new String(byte3));
		System.out.println(new String(byte3, "EUC-KR"));
	}
}