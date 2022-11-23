package javaz.basic;

public class If {

	public static void main(String[] args) {
		// if문
		// - 조건식과 수행문을 포함하는 블록으로 구성
		// - 조건식을 만족하는 경우의 수행문이 하나일 때는 블럭을 명시하지 않아도 됨
		
		// - 조건이 하나 일 때
		//	if(boolean 수식|값) 수행문1;
		//	if(boolean 수식|값) {수행문1; 수행문2; ... 수행문n;}
		
		// - 조건이 둘 일 때
		//	if(boolean 수식|값)	{수행문1; 수행문2; ... 수행문n;}
		//	else				{수행문1-1; 수행문1-2; ... 수행문1-n;}
		
		// - 조건이 둘 이상 일 때
		//	if(boolean 수식|값)		{수행문1; 수행문2; ... 수행문n;}
		//	else if(boolean 수식|값) 	{수행문1-1; 수행문1-2; ... 수행문1-n;}
		//		...
		//	else if(boolean 수식|값) 	{수행문(n-1)-1; 수행문(n-1)-2; ... 수행문(n-1)-n;}
		//	else  					{수행문n-1; 수행문n-2; ... 수행문n-n;}
		
		int mist = 0;
		String status = "알 수 없음";
//		status = mist <= 50 ? "좋음" : "알 수 없음";
		if(mist < 0) {
			status = "0 이상의 값을 입력해 주세요.";
		} else if (mist <= 0 && mist <= 50) {
			status = "좋음";
		} else if(mist > 50 && mist <= 100) {
			status = "보통";
		} else if(mist > 100 && mist <= 250) {
			status = "나쁨";
		} else {
			status = "매우 나쁨";
		}
		System.out.printf("미세먼지 지수: %d\n미세먼지 상태: %s\n\n", mist, status);
		
		
		// BMI
		double height = 1.8, weight = 80;
		double bmi = weight / (height * height);
		System.out.printf("%.2f ", bmi);
		if(bmi < 18.5) {
			System.out.println("저체중");
		} else if(bmi >= 18.5 && bmi <= 24.9) {
			System.out.println("보통");
		} else if(bmi >= 25 && bmi <= 29.9) {
			System.out.println("과체중");
		} else if(bmi >= 30 && bmi <= 34.9) {
			System.out.println("고도비만");
		} else {
			System.out.println("초고도비만");
		}
	}

}
