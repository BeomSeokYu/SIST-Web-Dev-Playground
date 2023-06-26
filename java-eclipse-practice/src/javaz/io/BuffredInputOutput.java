package javaz.io;

import java.io.*;
import java.util.Iterator;

public class BuffredInputOutput {

	public static void main(String[] args) throws IOException {
		String fileName = ".classpath";
		File file = new File(fileName);
		System.out.println("버퍼를 추가하여 파일에서 읽기 ===========");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		while (bis.available() != 0) {
			int input = bis.read();
			System.out.print((char)input);
		}
		bis.close();
		
		fileName = "buffered.txt";
		file = new File(fileName);
		System.out.println("버퍼를 추가하여 파일에서 쓰기 ===========");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		for (char i = '1'; i < '1'+9; i++) {
			bos.write(i);
		}
		bos.flush();
		bos.close();
	}

}
