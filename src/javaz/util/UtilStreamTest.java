package javaz.util;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class UtilStreamTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("seA", "sky", "Art", "sun");
		
		list.forEach(t -> System.out.println(t));
		
		System.out.println();
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println();
		List<String> newlist = list.stream()
									.filter(o -> o.startsWith("s"))
									.collect(Collectors.toList());
		
		System.out.println();
		list.stream()
					.map(o -> o.toUpperCase())
					.sorted()
					.forEach(System.out::println);
		
		System.out.println();
		list.stream()
					.map(String::toLowerCase)
					.sorted()
					.forEach(System.out::println);
									
		System.out.println();
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		System.out.println("5. 연습 - list의 각 요소의 길이 출력");
		list.stream().forEach(o -> System.out.println(o.length()));
		
		System.out.println();
		System.out.println();
		System.out.println("6. 연습 - list의 각 요소의 길이 출력");
		list.stream().forEach(o -> System.out.println(o.length()));
	}

}
