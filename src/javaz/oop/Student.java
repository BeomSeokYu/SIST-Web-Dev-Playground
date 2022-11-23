package javaz.oop;

public class Student extends Person{
	private String id;

	public Student(String name, String id) {
		super(name);
		this.id = id;
	}

	public Student(String name, String phoneNum, String id) {
		super(name, phoneNum);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "학생 학번: " + id + ", 이름: " + getName() + ", 연락처: " + getPhoneNum();
	}
}
