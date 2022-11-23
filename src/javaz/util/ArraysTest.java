package javaz.util;

import java.util.Arrays;
import java.util.Collections;

public class ArraysTest {

	public static void main(String[] args) {
		String[] object = {"bee", "air", "sky", "Sea", "Ace"};
		String[] clone1 = Arrays.copyOf(object, object.length);
		System.out.println(Arrays.toString(object));
		System.out.println(Arrays.toString(clone1));
		
		System.out.println();
		String[] clone2 = Arrays.copyOfRange(object, 0, object.length);
		System.out.println(Arrays.toString(object));
		System.out.println(Arrays.toString(clone2));
		System.out.println();
		String[] clone3 = Arrays.copyOfRange(object, 0, object.length);
		System.arraycopy(object, 0, clone3, 0, object.length);
		System.out.println(Arrays.toString(object));
		System.out.println(Arrays.toString(clone3));
		
		System.out.println("---sort()---");
		Arrays.sort(clone3);
		System.out.println(Arrays.toString(clone3));
		Arrays.sort(clone3, Collections.reverseOrder());
		Arrays.sort(clone3, String::compareToIgnoreCase); // 대소문자 무시하고 알파벳 순서
		
		String[] hangle = {"벌", "공기", "하늘", "바다", "에이스"};
		Arrays.sort(hangle);
		System.out.println(Arrays.toString(hangle));
		
		System.out.println();
		System.out.println("---search()---");
		System.out.println(Arrays.binarySearch(object, "sky"));
	}

}
