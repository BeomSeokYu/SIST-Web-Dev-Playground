package javaz.oop;

public class Constructor {
	
//	- 생성자
//    - [접근제어자] 생성자이름( [매개변수타입 매개변수명1 …] ) { 수행 구문 }
//        - 접근제어자 : public, private, protected, default/package/생략
//    - 객체 생성 시 단 한 번만 호출되는 특수한 메소드
//    - 메모리 할당 및 객체의 필드 값 초기화
//    - `new` 연산자로 호출
//    - 정의 방법
//        - 클래스 이름고 동일한 메소드 작성
//        - 반환형은 없음
//        - 접근 제어자는 보통 public
//        - singelton pattern일 때는  private
//        - 오버로딩 가능
//        - 필수 구현은 아님
//        - 상속 안됨
//    - 기본 생성자
//        - 생성자를 정의하지 않으면 컴파일러가 자동으로 디폴트 생성자 생성
//        - 매개 변수가 없는 생성자
	
	
	// 상수도 생성자를 이용해 초기화가 가능함
	final int LEVEL;
	
	public Constructor(int LEVEL) {
		this.LEVEL = LEVEL;
	}
}
