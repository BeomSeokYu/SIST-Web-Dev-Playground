package javaz.io;

import java.io.*;

public class PrintStreamTest {

	public static void main(String[] args) throws IOException {
		String fileName = "print.txt";
		PrintStream ps = new PrintStream(fileName);
		
		for (int i = '1'; i <= '9'; i++) {
			ps.write(i);
		}
		ps.println(123);
		ps.println(3.14);
		ps.println(true);
	}

}
