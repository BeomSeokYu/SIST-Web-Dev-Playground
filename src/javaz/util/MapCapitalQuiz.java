package javaz.util;

import java.util.HashMap;

class Capital {
	private HashMap<String, String> map;

	public Capital() {
		map = new HashMap<>();
		map.put("한국", "서울");
		map.put("중국", "베이징");
		map.put("일본", "도쿄");
		map.put("미국", "워싱턴");
		map.put("수리남", "파르나이바");
	}

	public String getCapital(String Country) {
		if(map.containsKey(Country))
			return Country+"의 수도는 ["+map.get(Country)+"]입니다.";
		else
			return "등록되지 않은 나라입니다.";
	}
}
public class MapCapitalQuiz {

	public static void main(String[] args) {
		Capital c = new Capital();
		String input = "일본";
		System.out.println(c.getCapital(input));
		input = "수리남";
		System.out.println(c.getCapital(input));
		input = "고조선";
		System.out.println(c.getCapital(input));
	}
}
