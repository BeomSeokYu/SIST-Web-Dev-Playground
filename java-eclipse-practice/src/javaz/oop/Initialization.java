package javaz.oop;

public class Initialization {
	int instanceField;
	static int staticField;
	
	{ System.out.println("instance init block"); }
	
	static { System.out.println("static init block"); }
	
	public Initialization() {
		System.out.println("constructor block");
	}
	
	public static void main (String [] args) {
		System.out.println("main() start");
		new Initialization();
		System.out.println("main() start");
	}
}
