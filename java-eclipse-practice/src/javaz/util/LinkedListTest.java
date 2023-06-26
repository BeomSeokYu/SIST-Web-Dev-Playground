package javaz.util;

import java.util.*;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("ant");		System.out.println(list);
		list.add("bee");		System.out.println(list);
		System.out.println();
		
		list.add(1, "CAT");		System.out.println(list);
		list.addFirst("DOG");	System.out.println(list);
		
		list.offer("fly");		System.out.println(list);
		list.offerFirst("ZOO");	System.out.println(list);
		list.offerLast("zoo");	System.out.println(list);
		
		
		System.out.println(list.get(0) + " " + list);
		System.out.println(list.getFirst() + " " + list);
		System.out.println(list.getLast() + " " + list);
		
		System.out.println(list.peek() + " " + list);
		System.out.println(list.poll() + " " + list);
		System.out.println(list.pop() + " " + list);
	}

}
