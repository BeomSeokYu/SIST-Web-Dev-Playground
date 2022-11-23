package javaz.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFileCopy {

	public static void main(String[] args) {
		String src = "c:/dev/java.png";
		String srcCopy = src.substring(0, src.lastIndexOf(".")) + " - 복사본.png";
		FileInputStream fis = null;
		try (FileOutputStream fos = new FileOutputStream(srcCopy)) {
			fis = new FileInputStream(src);
			System.out.println("----- 이미지 파일 복사본 만들기");
			while(fis.available() != 0) {
				fos.write(fis.read());
			}
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
