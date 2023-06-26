package javaz.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		String[] animals = {"cat", "dog", "ant"};
		
		List<String> animalList = Arrays.asList(animals);
		ArrayList<String> list = new ArrayList<>(animalList);
		
		System.out.println(Arrays.toString(animals));
		System.out.println(list);
		
		Object[] s2 = list.toArray();
		System.out.println(Arrays.toString(list.toArray()));
		String[] s = list.toArray(new String[0]);
		String[] s1 = list.toArray(String[]::new);
		System.out.println(Arrays.toString(s));
		System.out.println(Arrays.toString(s1));
		System.out.println(Arrays.toString(s2));
	}
}
