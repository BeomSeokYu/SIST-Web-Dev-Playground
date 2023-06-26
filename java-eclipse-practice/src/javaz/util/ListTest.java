package javaz.util;

import java.util.*;
import java.util.function.Consumer;

public class ListTest {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();

		System.out.println(list.size() + " " + list);
		
		list.add(1);
		list.add(2);
		list.add(true);
		list.add(3.0);
		list.add("사");
		list.add(true);
		System.out.println(list.size() + " " + list);
		
		if(list.contains(1)) list.remove(list.indexOf(1));
		System.out.println(list.size() + " " + list);
		
		System.out.println("3번째 인덱스 데이터 : " + list.get(3));
		
		System.out.println();
		System.out.println("List WITH using for---------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		System.out.println("List WITH using foreach---------------");
		for (Object o : list) {
			System.out.println(o);
		}
		System.out.println("List WITH using iterator---------------");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		System.out.println("List WITH using Consumer Interface + annoy---------------");
		list.forEach(new Consumer<Object>() {
			@Override
			public void accept(Object o) {
				System.out.println(o);
			}
		});
		
		System.out.println("List WITH using Consumer Interface + annoy---------------");
		list.forEach(o -> System.out.println(o));
	}

}
