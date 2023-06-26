package javaz.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		String s = "1 and 2 and bee and ant and fly";
		
		Scanner sc = new Scanner(s);
		
		sc.useDelimiter("\\s*and\\s*");	// \s: 공백 | *: 0개 이상
		while (sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
		
		
		sc = new Scanner(new File("src/user.txt"));
		sc.useDelimiter("^.");
		while (sc.hasNext()) {
			for (String string : sc.nextLine().strip().split("',*\\s*^.*")) {
				System.out.println(string);
			}
			System.out.println();
		}
		sc.close();
		
//		System.out.println();
//		System.out.println("-scan을 이용하여 키보드 입력 받기-");
//		sc = new Scanner(System.in);
//		System.out.print("문자열 입력 : ");
//		System.out.println("\"" + sc.nextLine() + "\"");
//		
//		System.out.print("정수 입력 : ");
//		System.out.println(sc.nextInt());
//		
//		System.out.print("실수 입력 : ");
//		System.out.println(sc.nextDouble());
//		
//		sc.close();
	}

}
