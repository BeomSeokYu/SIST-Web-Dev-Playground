package javaz.basic;

public class Array2D {

	public static void main(String[] args) {
		int[] numbers[] = {
				{99, 88, 77},
				{66, 55, 44}
				};
		for(int[] number : numbers) {
			for(int i : number) {
				System.out.println(i);
			}
		}
		
		boolean[][] pass = new boolean[3][2];
		double[][] incen = new double[][] {
			{ 0.1, 0.2, 0.3 },
			{ 0.4, 0.5, 0.6 },
		};
		String[][] users = new String[][] {
			{ "Kim", "Lee", "Han" },
			{ "Ann", "San", "Ben" },
		};
		char[][] grades = new char[2][];
		grades[0] = new char[] {'h', 'i'};
		grades[1] = new char[] {'j', 'a', 'v', 'a'};
		for(char[] grade : grades) {
			for(char i : grade) {
				System.out.print(i);
			}
			System.out.print(" ");
		}
	}
}
