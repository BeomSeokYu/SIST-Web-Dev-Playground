package javaz.oop;

public class ParentChildTest {

	public static void main(String[] args) {
		Child c = new Child();
		Parent p = new Parent();
		c.method();
		c.child();
		p.method();
		
		System.out.println("\n1. Up Casting");
		Parent p1 = c;
		p1.method();	// 자식의 메소드가 소환됨
		//p1.child();	// 상속 시켜준 메소드가 아니므로 사용 불가
		
		System.out.println("\n2. Down Casting");
		Child c1 = (Child) p;
		c1.method(); 	// ClassCastException 발생
		c1.child();		// ClassCastException 발생
	}

}

class Parent {
	protected int num;
	Parent() {
		//System.out.println("1.Parent()");
	}
	
	public void method() {
		System.out.println("Parent's method");
	}
}

class Child extends Parent{
	Child() {
		super(); // 부모클래스의 생성자 호출 - 생략 가능
		//System.out.println("2.Child()");
	}
	
	public void method() {
		System.out.println("Child's method");
	}
	
	public void child() {
		System.out.println("Child's child method");
	}
}

//class GrandChild {
//	GrandChild() {
//		
//	}
//}