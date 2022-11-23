package javaz.util;

import java.util.Random;

public class RamdomTest {

	public static void main(String[] args) {
		Random r1 = new Random();
		System.out.println(r1.nextBoolean());
		System.out.println(r1.nextDouble());
		System.out.println(r1.nextFloat());
		System.out.println(r1.nextInt());
		System.out.println(r1.nextInt(5));
		System.out.println();
		Random r2 = new Random(12L);
		System.out.println(r2.nextInt(3));
		System.out.println(r2.nextInt(3));
		System.out.println(r2.nextInt(3));
		System.out.println();
		r2.setSeed(System.currentTimeMillis());
		System.out.println(r2.nextInt(3));
		System.out.println(r2.nextInt(3));
		System.out.println(r2.nextInt(3));
		System.out.println();
		Random r3 = new Random(System.currentTimeMillis());
		System.out.println(r3.nextInt(3));
		System.out.println(r3.nextInt(3));
		System.out.println(r3.nextInt(3));
		
		System.out.println("---------------------");
		System.out.println("-------경품 목록--------");
		String[] gifts = {"note", "book", "key", "board", "mouse"};
		for (int i = 0; i < gifts.length; i++) {
			System.out.println(i+1 + "등 : " + gifts[i]);
		}
		System.out.println("---------------------");
		int j = r2.nextInt(5);
		System.out.println(j+1 + "등 : " + gifts[j]);
	}

}
