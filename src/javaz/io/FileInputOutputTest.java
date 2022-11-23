package javaz.io;

import java.io.*;
public class FileInputOutputTest {
	
	public static void main(String[] args) {
		System.out.println("1. .classpath파일 읽어 오기");
		String fileName = ".classpath";
		File file = new File(fileName);
		FileInputStream fis = null;
		// 파일에서 읽어오기 위한 파일입력스트림
		try (FileOutputStream fos = new FileOutputStream(fileName + ".bak")){
			fis = new FileInputStream(file);
			while(fis.available() != 0) {
				int temp = fis.read();
				System.out.print((char)temp);
				fos.write(temp);
			}
			System.out.println("---------------------------------");
			System.out.println("2. 읽어온 파일의 백업 파일 만들기");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
