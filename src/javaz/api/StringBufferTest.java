package javaz.api;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(50);
		StringBuffer sb3 = new StringBuffer("1234567890abcdefghijklmnoopqrstuvWxyz~~~~~~~");
		//StringBuffer sb4 = "Hello wolrd!"; //String같이 초기화하여 사용할 수는 없다
		
		System.out.println(sb1.capacity());	// 기본생성자는 16의 공간이 있음
		System.out.println(sb2.capacity());	// 지정한 50 공간 있음
		System.out.println(sb3.capacity());	// 글자수 + 16의 공간이 생성됨
		System.out.println();
		System.out.println(sb1.length());	// 0
		System.out.println(sb2.length());	// 0
		System.out.println(sb3.length());	// 44
		
		// capacity와 length는 다름
		
		System.out.println(sb3.replace(sb3.indexOf("~"), sb3.lastIndexOf("~")+1, "!!!!!!!"));
		System.out.println(sb3.append("~~~~~~~"));
	}
}
