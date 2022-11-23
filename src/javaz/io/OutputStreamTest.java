package javaz.io;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {

	public static void main(String[] args) {
		OutputStream os;
		os = System.out;
		byte[] b = {104 ,101 ,108 ,108 ,111};
		try {
			os.write(b);
			os.write(65);
			os.write('a');
			os.write('\n'); // 개행 문자가 있어야 스트림 버퍼를 비워 
			os.write(70);
			os.write('B');
			os.flush(); // 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
