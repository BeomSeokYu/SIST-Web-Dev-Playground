package javaz.io;

import java.io.*;

public class DataInputOutput {

	public static void main(String[] args) throws IOException {

		String fileName = "dataOut.txt";
		File file = new File(fileName);
		if(!file.isFile()) file.createNewFile();
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(file);
		DataInputStream dis = new DataInputStream(fis);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeBoolean(false);
		dos.writeChar('A');
		dos.writeDouble(0.1234);
		dos.close();
		
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		System.out.println(dis.readDouble());
		dis.close();

	}

}
