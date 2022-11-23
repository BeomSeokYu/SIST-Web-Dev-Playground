package javaz.util;

import java.util.ArrayList;
import java.util.Random;

public class ListRandomTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Korea");
		list.add("Japan");
		list.add("China");
		list.add("USA");
		Random r = new Random(System.currentTimeMillis());
		System.out.println("오늘의 추천 여행지 : " + list.get(r.nextInt(4)));
	}

}
