package javaz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		Date current = new Date(System.currentTimeMillis());
		System.out.println(date);
		System.out.println(current);
		System.out.println(current.toLocaleString());
		
		System.out.println();
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		System.out.println(dateFmt.format(date));
		System.out.println(dateFmt.parse(dateFmt.format(date)));
		
		System.out.println();
		System.out.println("-------Calendar-------");
		
		// Date >> Calendar
		Calendar cal = Calendar.getInstance();
		Date now = new Date();
		cal.setTime(now);
		DateTest.printDateTime(cal);
		
		// Calendar >> Date
		cal = Calendar.getInstance();
		now = new Date(cal.getTimeInMillis());
		
		System.out.println();
		System.out.println("----------------------");
		System.out.println("특정일시 지정하고 받아오기");
		System.out.println("생년월일 : 2000년 5월 5일 금요일");
		System.out.println("출생시간 : 오후 11시 22분 33초");
		Calendar birthInfo = Calendar.getInstance();
		birthInfo.set(2000, Calendar.MAY, 5);
		birthInfo.set(Calendar.HOUR, 11);
		birthInfo.set(Calendar.MINUTE, 22);
		birthInfo.set(Calendar.SECOND, 33);
		DateTest.printDateTime(birthInfo);
	}
	
	public static void printDateTime(Calendar cal) {
		String[] s = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println("오늘은 "  + cal.get(Calendar.YEAR) + "년 "
									+ (cal.get(Calendar.MONTH)+1) + "월 "
									+ cal.get(Calendar.DATE) + "일 "
									+ s[cal.get(Calendar.DAY_OF_WEEK)-1] + "요일 "
					+"\n지금 시간은 "	+ (cal.get(Calendar.AM_PM) == 0 ? "오전 " : "오후 ")
									+ cal.get(Calendar.HOUR) + "시 "
									+ cal.get(Calendar.MINUTE) + "분 "
									+ cal.get(Calendar.SECOND) + "초 ");
	}
}
