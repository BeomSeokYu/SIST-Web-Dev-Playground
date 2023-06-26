package javaz.util;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties p = new Properties();
		p.put("user", "dev");
		p.setProperty("password", "1234");
		System.out.println(p.get("user"));
		System.out.println(p.getProperty("password"));
		
		Enumeration<?> e =  p.propertyNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			System.out.println(name + " : " + p.get(name));
		}
		System.out.println();
		// 시스템의 파일 구분자와 경로 구분자 출력
		System.out.println(System.getProperty("file.separator"));
		System.out.println(System.getProperty("path.separator"));
		// 시스템의 전체 속성 출력
		System.out.println(System.getProperties());
	}
}
