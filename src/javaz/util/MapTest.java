package javaz.util;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "서울");
		map.put(31, "경기");
		map.put(32, "인천");
		map.put(33, "강원");
		map.put(53, "대구");
		map.put(64, "제주");
		map.put(64, "제주중복");
		System.out.println(map);
		System.out.println(map.get(32));
		
		System.out.println("----- KeySet -----");
		Set<Integer> ketSet = map.keySet();
		System.out.println(ketSet);
		for (Integer integer : ketSet) {
			System.out.println(integer);
		}
		
		
		System.out.println("----- iterator -----");
		for (Iterator<Integer> iterator = ketSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		System.out.println("----- entry -----");
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		for (Iterator<Entry<Integer, String>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Integer, String> entry = (Entry<Integer, String>) iterator.next();
			System.out.println(entry);
			
		}
		
		System.out.println("----- Collection : values() -----");
		Collection<String> c = map.values();
		for (Iterator<String> iterator = c.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		
		System.out.println("----- BiConsumer interface + Lambda -----");
		map.forEach((Integer k, String v) -> System.out.println("key : " + k + " \tvalue : " + v));
		
		System.out.println("----- remove -----");
		map.remove(2);		System.out.println(map);
		System.out.println("----- clear -----");
		map.clear();		System.out.println(map);
	}

}
