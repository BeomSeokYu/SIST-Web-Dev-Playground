package javaz.util;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		Consumer<Integer> c = x -> System.out.println("" + x);
		c.accept(12);
		
		Supplier<Boolean> s = () -> new Random().nextBoolean();
		System.out.println(s.get());
	}

}
