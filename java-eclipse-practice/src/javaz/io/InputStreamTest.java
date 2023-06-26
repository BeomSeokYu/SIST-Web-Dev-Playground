package javaz.io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = System.in;
			System.out.println("-- 문자의 아스키코드 알아보기 --");
			String s = "문자를 입력해 주세요(종료 ctrl + z) : ";
			System.out.print(s);
			int input = 0;
			while(input != -1) {
				input = is.read();
				switch (input) {
				case '\n': 	continue;
				case '\r': 	System.out.print(s);
							continue;
				default:	System.out.println((char)input + " : " + input);
							break;
				}
			}
			System.out.println("종료되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
