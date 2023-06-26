package javaz.util;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		s.add("red");	// add도 됨
		s.push("mon");
		s.push("tue");
		s.push("wed");
		
		System.out.println(s);
		System.out.println(s.peek());
		System.out.println(s.search("wed"));
		System.out.println(s.empty());
	}

}
