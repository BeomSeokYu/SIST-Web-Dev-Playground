package javaz.io;

import java.io.*;

public class InputStreamReaderTest {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = " a   asdf  ";
		System.out.println(s.strip());
		while(true) {
			System.out.print("단어를 입력하세요 (종료는 /q) : ");
			String input = br.readLine();
			if(input.equals("/q")) {
				System.out.println("단어입력종료");
				break;
			} else if (input.equals("")) {
				System.out.println("단어가 입력되지 않았습니다.");
			} else {
				System.out.println(input);
			}
		}
	}
}