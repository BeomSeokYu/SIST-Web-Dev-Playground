package javaz.basic;

import java.util.Dictionary;

public class Array1DExam {

	public static void main(String[] args) {
		String[] names = new String[] {"Kim", "Lee", "Han", "Ann", "Ben"};
		int[] javas = new int[] {99, 88, 77, 66, 50};
		int sum = 0;
		System.out.println("=== JAVA TEST SCORE ===");
		System.out.println("\tname \t score");
		System.out.println("-----------------------");
		for(int i = 0; i < names.length; i++) {
			System.out.println(i+1 + "\t" + names[i] + "\t" + javas[i]);
			sum += javas[i];
		}
		System.out.println("-----------------------");
		System.out.printf("총점 : %d\n평균 : %.2f", sum, (float)sum/javas.length);
		
		System.out.printf("\n\n--------버블 정렬---------\n");
		for(int i = 0; i < javas.length; i++) {
			for(int j = 1; j < javas.length-i; j++) {
				if (javas[j-1] > javas[j]) {
					int temp = 0;
					temp = javas[j-1];
					javas[j-1] = javas[j];
					javas[j] = temp;
				}
			}
		}
		for (int i : javas) {
			System.out.println(i);
		}
		// 
		for (String i : args) {
			System.out.println(i);
		}
	}

}
