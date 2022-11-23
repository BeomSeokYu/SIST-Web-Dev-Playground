package javaz.api;

import java.io.IOException;
import java.util.Properties;

public class SystemTest {

	public static void main(String[] args) throws IOException {
		System.out.println("운영체제 : " + System.getProperty("os.name") );
		System.out.println("운영체제 : " + System.getProperty("os.arch") );
		System.out.println("사용자명 : " + System.getProperty("user.name") );
		System.out.println("파일 구분자 : " + System.getProperty("file.separator") );
		System.out.println("경로 구분자 : " + System.getProperty("path.separator") );
		System.out.println();
		System.out.println("시스템 프로터티 읽어오기");
		Properties p = System.getProperties();
		p.list(System.out);
		
		System.out.println();
		System.out.println("시스템 환경변수 읽어오기");
		System.out.println("JAVA_HOME : " + System.getenv("JAVA_HOME"));
		System.out.println("path : " + System.getenv("path"));
		System.out.println();
		// 환경변수 Path의 값을 시스템의 path구분자로 나누어 한 줄씩 출력
		for (String s : System.getenv("path").split(";")) {
			if(!s.equals(""))	System.out.println(s);
		}
		
		System.out.println();
		System.out.print("문자 하나를 입력해주세요 : ");
		int input = System.in.read();
		System.out.println("입력문자 : " + (char)input);
		System.out.println("아스키 : " + input);
		System.out.println();

		input = System.in.read();
		System.out.println("입력문자 : " + (char)input);	// \n : 개행
		System.out.println("아스키 : " + input);
		
		input = System.in.read();
		System.out.println("입력문자 : " + (char)input);	// \r : 캐리지리턴
		System.out.println("아스키 : " + input);
		
		System.in.close();
	}

}
