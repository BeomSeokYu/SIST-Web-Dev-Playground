package javaz.io;

import java.io.*;

public class BufferedReaderWriter {

	public static void main(String[] args) throws IOException {
		
		String fileName = "bufferedWrite.txt";
		System.out.println("버퍼를 추가하여 파일에서 쓰기 ===========");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		bw.write("Hello 한글");
		bw.newLine();
		bw.append("append....");
		bw.close();
		
		System.out.println();
		System.out.println("버퍼를 추가하여 파일에서 읽기 (Reader) ===========");
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		while (br.ready()) {
			int input = br.read();
			System.out.print((char)input);
		}
		br.close();
		
		System.out.println("\n");
		System.out.println("버퍼를 추가하여 파일에서 읽기 (InputStream) ===========");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
		while (bis.available() != 0) {
			int input = bis.read();
			System.out.print((char)input);
		}
		bis.close();
	}

}
