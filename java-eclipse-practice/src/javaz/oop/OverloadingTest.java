package javaz.oop;

public class OverloadingTest {

	public static void main(String[] args) {
		Overloading ol = new Overloading();
		ol.area();
		System.out.println(ol + "\n");
		
		Overloading saa = new Overloading("정사각형");
		System.out.print("가로세로 5인 정사각형의 넓이 : ");
		saa.area(5);
		System.out.println(saa + "\n");
		
		Overloading sam = new Overloading("삼각형");
		System.out.print("밑변 5 높이 5인 삼각형의 넓이 : ");
		sam.area(5, 5);
		System.out.println(sam + "\n");
		
		Overloading one = new Overloading("원");
		System.out.print("반지름이 5인 원의 넓이 : ");
		one.area(5.0);
		System.out.println(one + "\n");
		
		System.out.println(Overloading.PI + "\n");
	}

}