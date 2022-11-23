package javaz.basic;

public class StringType {

	public static void main(String[] args) {
		// var
		// - 자바 10부터 사용 가능
		// - 저장되는 데이터에 따라 타입 자동 결정
		var guess = "someData";
		var num = 123;
		
		String name = "Lee";
//		String s = new String("String");
		System.out.println(name);
		
		//국어 90, 영어 80, 수학 77
		int kor = 90, eng = 80, math = 77;
		int sum = kor + eng + math;
		int avg1 = sum / 3;
		float avg2 = sum / 3;
		float avg3 = sum / 3.0f;
		double avg4 = sum / 3.0;
		System.out.println("국어\t영어\t수학");
		System.out.println("--------------------");
		System.out.println(kor+"\t"+eng+"\t"+math);
		System.out.println("--------------------");
		System.out.println("총점: " + sum + " | 평균1: " + avg1 + " | 평균2: " + avg2 + " | 평균3: " + avg3  + " | 평균3: " + avg4);
		System.out.printf("평균 : %.2f\n", avg4);
		String s = "";
		if(avg4 >= 90 && avg4 <= 100) {
			s = "A학점";
		} else if(avg4 >= 80 && avg4 < 90) {
			s = "B학점";
		} else if(avg4 >= 70 && avg4 < 80) {
			s = "C학점";
		} else if(avg4 >= 60 && avg4 < 70) {
			s = "D학점";
		} else {
			s = "F학점";
		}
		System.out.println(s);

	}
}