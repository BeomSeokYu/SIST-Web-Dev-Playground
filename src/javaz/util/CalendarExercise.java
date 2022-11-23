package javaz.util;

import java.util.Calendar;

public class CalendarExercise {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		String[] dows = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fir", "Sat"};
		int y = 2022;
		int m = 10;
		c.set(y, m-1, 1);
		int start = c.get(Calendar.DAY_OF_WEEK)-1;
		
		System.out.println(y + "년 " + m + "월");
		for (String dow : dows) {
			System.out.printf("%4s", dow);
		}
		System.out.println("\n-----------------------------");
		
		for(int i = 0; i < start; i++) {
			System.out.printf("%4s", "");
		}
		
		for(int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			System.out.printf((i+start)%7 == 0 ? "%4d\n" : "%4d", i);
		}
	}
}
