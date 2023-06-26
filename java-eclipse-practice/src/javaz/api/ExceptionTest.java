package javaz.api;

import java.io.IOException;
import java.io.InputStream;

class SamChoException extends Exception{

	public SamChoException(String message) {
		super(message);
	}
}

public class ExceptionTest {
	
	public void countDown(int cntNum) throws InterruptedException, SamChoException {
		if (cntNum < 3) {
			throw new SamChoException("3초 미만 입력 : " + cntNum);
		}
		for(int i = cntNum; i > 0; i--) {
			System.out.println(i);
			Thread.sleep(1000);
		}
	}
	
	public static void main(String[] args) {
		
		try {
			System.out.println("1. 예외 발생 전");
			System.out.println(args[2]);
			System.out.println("3. 예외 발생 후");
		} catch (NullPointerException e) {
			System.out.println("4. 노상관 예외 발생 1 : " + e);
		} catch (ClassCastException | ArithmeticException e) {
			System.out.println("5. 노상관 예외 발생 2 : " + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("6. 예외 발생 : ");
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
			System.err.println("예외 잡음!!");
		} catch (Exception e) {	// 위쪽에 있는 catch 구문이 우선순위가 위에있음.
			System.out.println("7. 최상위 예외 객체 : " + e);
		} finally {
			System.out.println("8. 마지막 항상 실행됨.");
		}
		System.out.println("--- try with resources ---");
		try (InputStream is = System.in){
			is.read();
			is.skip(2);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("=================================");
		ExceptionTest et = new ExceptionTest();
		try {
			et.countDown(2); // 간접 예외 처리
		} catch (InterruptedException e){
			System.out.println(e);
		} catch (SamChoException e){
			System.out.println(e);
		}
			
	}

}
