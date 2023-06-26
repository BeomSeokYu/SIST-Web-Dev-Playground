package javaz.oop;

public class InnerTest {

	public static void main(String[] args) {
		Outer o = new Outer();
		o.method();	// Local Inner 클래스
		
		Outer.Member m = o.new Member(); // Outer 내부의 Member Inner 클래스
		m.method();
		
		Outer.Static.method(); // Outer Static 사용
		
		Abstract a = new Abstract() {
			@Override
			void method() {
				System.out.println("Anonymous Inner - extends X");
			}
		};
		a.method();
		
		new Interface() {
			
			@Override
			public void method() {
				System.out.println("Anonymous Inner - implements X");
			}
		}.method();
		
		Interface interLambda = () -> {
			System.out.println("Lambda Inner - implements X");
		};
		
		interLambda.method();
	}

}

class Outer {
	class Member {
		public void method() {
			System.out.println("Member Inner");
		}
	}
	
	static class Static {
		public static void method() {
			System.out.println("Static Inner");
		}
	}
	
	public void method() {
		class Local {
			public void method() {
				System.out.println("Local Inner");
			}
		}
		new Local().method();
	}
	
}

abstract class Abstract {
	abstract void method();
}

class AbsChild extends Abstract {

	@Override
	void method() {
		
	}
	
}

interface Interface {
	void method();
}

class InterChild implements Interface {

	@Override
	public void method() {
		System.out.println("InterChild method");
	}

}
