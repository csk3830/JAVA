package day03;

/* 학생 클래스 생성
 * 멤버변수 : 지점, 이름, 과정, 전화번호
 * 생성자 :
 * - 지점과 이름만 받는 생성자
 * - 지점, 이름, 과정, 전화번호를 받는 생성자 (생성자 호출로 호출)
 * 메서드 : 해당 내용을 출력하는 메서드 print()
 * - getter/setter
 * 
 */
class EzenStudent {
	private String locate, name, course, phone;

	public EzenStudent() {
	}

	public EzenStudent(String locate, String name) {
		this.locate = locate;
		this.name = name;
	}

	public EzenStudent(String locate, String name, String course, String phone) {
		this(locate, name);
		this.course = course;
		this.phone = phone;
	}

	public void print() {
		System.out.println("--학생정보--");
		System.out.println(name+"(" + phone + ") - "  + course + " (지점: " + locate + ")" );
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

public class Student {
	public static void main(String[] args) {
		EzenStudent st1 = new EzenStudent("인천", "홍길동");
		st1.print();
		st1.setCourse("AWS 활용 풀스택 개발자 양성 과정");
		st1.setPhone("010-1234-5678");
		st1.print();

		EzenStudent st2 = new EzenStudent("서울", "김영희", "전산회계", "010-1111-2222");
		st2.print();

		
	}

}
