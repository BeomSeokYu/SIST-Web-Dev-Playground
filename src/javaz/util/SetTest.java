package javaz.util;

import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		Set<Object> set = new HashSet<>();
		HashSet<Object> hset = new HashSet<>();
		
		System.out.println(set.size() + " " + set);
		
		set.add(1);
		set.add(2);
		set.add(true);
		set.add(3.0);
		set.add("사");
		set.add(true);
		System.out.println(set.size() + " " + set);
		
		if(set.contains(1)) set.remove(1);
		System.out.println(set.size() + " " + set);
		
		set.clear();
		System.out.println(set.size() + " " + set);
		
		Iterator<Object> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
