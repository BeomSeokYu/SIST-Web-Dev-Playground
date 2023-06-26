package javaz.basic;

public class Array2DExam {

	public static void main(String[] args) {
		int[][] scores = new int[][] {
			{100, 95, 98},
			{27, 48, 22},
			{69, 77, 80}
		};
		int sum = 0;
		float[] avg = new float[3];
		System.out.println("번호 \t국어 \t영어 \t수학 \t총점 \t평균");
		System.out.println("-------------------------------------------------");
		for(int i = 0; i < scores.length; i++) {
			System.out.print(i+1 + "번\t");
			for(int score : scores[i]) {
				System.out.print(score + "\t");
				sum += score;
			}
			System.out.print(sum + "\t");
			System.out.printf("%.2f\t", (float)sum/scores[i].length);
			sum = 0;
			System.out.println();
		}
		System.out.println("-------------------------------------------------");
		System.out.printf("총점\t");
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {
				sum += scores[j][i];
			}
			System.out.printf("%d\t", sum);
			avg[i] = (float)sum/3;
			sum = 0;
		}
		System.out.println();
		System.out.printf("평균\t");
		for(int i = 0; i < avg.length; i++) {
			System.out.printf("%.2f\t", avg[i]);
		}
	}
}
