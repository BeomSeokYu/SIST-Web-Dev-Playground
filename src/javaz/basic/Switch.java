package javaz.basic;

public class Switch {

	public static void main(String[] args) {
		// switch문
		// - 조건이 여러 개이거나, 특정 경우의 수가 정해여 있는 경우
		// - 조건은 int 이하의 정수 또는 String
		// - 조건에 맞는 case문을 실행
		// - 조건이 일치하더라고 break가 없다면 계속 다음 문장을 수행
		// - 모든 조건이 일치하지 않을 경우 default 실행
		//		switch (조건값) { - 조건값은 정수 또는 문자열
		//		case 값1:
		//			수행문1;
		//			break;
		//		case 값2:
		//			수행문2;
		//			break;
		//		default: (생략 가능)
		//			수행문
		//			break;
		//		}

		String pizzaSize = "small";
		switch (pizzaSize) {
		case "small":
			System.out.println("10000원");
			break;
		case "medium":
			System.out.println("20000원");
			break;
		case "large":
			System.out.println("30000원");
			break;
		default:
			System.out.println("잘못된 사이즈");
			break;
//			return; // main메소드를 끝내고 반환
		}
		int y = 2000;
		int m = 2;
		int lastDate = 0;
		boolean yoon = (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;

		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			lastDate = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		case 2:
			if(yoon) 	lastDate = 29;
			else		lastDate = 28;
			break;
		}
		System.out.printf("%d년 %d월의 마지막 날은 %d일\n", y, m, lastDate);
	}

}
