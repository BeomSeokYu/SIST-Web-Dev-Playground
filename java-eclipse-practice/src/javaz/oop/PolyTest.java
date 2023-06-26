package javaz.oop;

public class PolyTest {

	public static void main(String[] args) {
		//Shape shape = new Shape(); 	// 인터페이스는 인터페이스를 생성할 수 없음
		Shape shapeC = new Circle();	// 자식 타입의 인스턴스 생성 가능
		Shape shapeR = new Rectangle();
		
		shapeC.draw();
		shapeR.draw();
	}

}

interface Shape {
	void draw();
} // End interface Shape

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("원을 그린다.");
	}

} // End class Circle

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("직사각형을 그린다.");
	}

} // End class Rectangle