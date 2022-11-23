package javaz.util;

import java.util.function.*;

class ConsumerImpl implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
	
}

public class MethodReference {

	public static void main(String[] args) {
		Consumer<String> cs = new ConsumerImpl();
		cs.accept("1. named class");
		
		cs = t -> System.out.println(t);
		cs.accept("2. lamda class");
		
		cs = System.out::println;
		cs.accept("3. method reference");
		
		System.out.println();
		System.out.println("=== 정적 메소드 참조 ===");
		int result = Math.max(3, 5);
		System.out.println(result);
		
		IntBinaryOperator ibo = (x, y) -> Math.max(3, 5);
		System.out.println(ibo.applyAsInt(3, 5));

		IntBinaryOperator ibo2 = Math::max;
		System.out.println(ibo2.applyAsInt(3, 5));
	}

}
