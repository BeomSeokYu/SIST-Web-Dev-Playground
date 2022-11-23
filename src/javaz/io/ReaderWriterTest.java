package javaz.io;

import java.io.*;

public class ReaderWriterTest {

	public static void main(String[] args) throws IOException {
		String fileName = "./src/user.txt";
		
		// InputStream 사용
		InputStream is = new FileInputStream(fileName);
		while(is.available() != 0) {
			System.out.print((char)is.read());
		}
		is.close();
		
		// Reader 사용
		System.out.println();
		System.out.println();
		Reader r = new FileReader(fileName);
		while(r.ready()) {
			System.out.print((char)r.read());
		}
		r.close();
		
		fileName = "write.txt";
		//Writer w = new FileWriter(fileName);
		Writer w = new FileWriter(fileName, true); // 수정을 위해서는 append 모드를 true로 설정해 줘야함
		
		//w.write("writer를 이용하여 파일에 쓰기");
		w.write("writer를 이용하여 파일에 쓰기2");
		w.append("\n안녕하세요\n");
		
		w.close();
	}

}
