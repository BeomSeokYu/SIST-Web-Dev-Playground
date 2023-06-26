package javaz.api;

class A {
	
}

class B {

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "This is class B";
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
}

public class ObjectTest {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		System.out.println(a);
		System.out.println(b);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(a.getClass());
		System.out.println(b.getClass());
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a.equals(b));
		System.out.println(b.equals(b));
		String s = "haha";
		String ss = "haha";
		String t = new String("haha");	// new String은 매번 새로운 객체를 생성
		String tt = new String("haha");
		System.out.println(s == ss);
		System.out.println(t == tt);
		System.out.println(s == t);
		System.out.println(s.equals(ss));
		System.out.println(t.equals(tt));
		System.out.println(s.equals(t));
		System.out.println(s.hashCode());
		System.out.println(ss.hashCode());
		System.out.println(t.hashCode());
		System.out.println(tt.hashCode());
		System.out.println(s.toString());
		System.out.println(ss.toString());
		System.out.println(t.toString());
		System.out.println(tt.toString());
		
		System.out.println("=============================================");
		String adminId = "admin";
		String inputId = "abc";
		
		if (adminId.equals(inputId)) {
			System.out.println("관리자로 로그인 중");
		} else {
			System.out.println("관리자 전용 페이지 입니다.");
		}
		System.out.println("=============================================");
		s = "s";
		ss = "ss";
		t = "t";
		tt = "tt";
		
		System.out.println(s.hashCode());
		System.out.println(ss.hashCode());
		System.out.println(t.hashCode());
		System.out.println(tt.hashCode());
	}

}
