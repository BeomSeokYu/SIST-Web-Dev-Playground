package javaz.oop;

public class PersonTest {

	public static void main(String[] args) {
//		Person p1 = new Person("John", "010-1234-5678");
//		Person p2 = new Person("Lee", "011-1234-5678");
//		Person p3 = new Person("Jin", "016-1234-5678");
//		
//		Person[] persons = new Person[100];
//		
//		persons[0] = p1;
//		persons[1] = p2;
//		persons[2] = p3;
		
		Person[] persons = {new Person("John", "010-1234-5678"), 
							new Person("Lee", "011-1234-5678"), 
							new Person("Jin", "016-1234-5678")};
		System.out.println("-------연락처 목록-------");
		System.out.println("이름 \t전화번호");
		for(int i = 0; i < persons.length; i++) {
			System.out.println(persons[i].getName() + "\t" + persons[i].getPhoneNum());
		}
	}

}
