package javaz.util;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		String s = "java # db # project # html # css";
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
		System.out.println();
		st = new StringTokenizer(s, "#");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
