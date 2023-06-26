package javaz.io;

import java.io.*;
import java.util.Arrays;

public class FileTest {

	public static void main(String[] args) {
		String fileName = "src/";
		File dir = new File(fileName);
		System.out.println(Arrays.toString(dir.list()));
		File[] fileList = dir.listFiles();
		for (File file : fileList) {
			System.out.println("이름 : " + file.getName());
			System.out.println("디렉토리 : " + file.isDirectory());
			boolean isf = file.isFile();
			System.out.println("파일 : " + isf);
			if(isf)  System.out.println("파일 크기 : " + file.length() + "byte");
			System.out.println();
		}
	}

}
