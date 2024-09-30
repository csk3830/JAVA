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
/* 객체를 생성시 값을 초기화 하는 방법
 * - 기본값, 명시적 초기값, 초기화 블럭
 * 1. 기본값 : 기본적으로 지정되는 값 int = 0 / String = null
 * 2. 명시적 초기값 : 사용자가 멤버변수를 선언함과 동시에 값을 지정
 * 3. 초기화 블럭 : { } 멤버변수들의 초기화
 * 4. 생성자 : 객체 생성시 초기화를 해서 생성
 * 
 * 초기값의 우선순위(순위가 높은 값으로 덮어쓰여짐)
 * 기본값 -> 명시적 초기값 -> 초기화 블럭 -> 생성자
 */
public class Student {
	private String locate = "incheon"; 	//명시적 초기값
	private String name; //기본값 기본적으로 주는 null / 0의 값
	private String course;
	private String phone;
	{
		//초기화 블럭 영역
		name = "student";
		course = "JAVA";
		phone = "010-0000-0000";
	}

	public Student() { //기본생성자
		name = "student";
		course = "JAVA";
	}

	public Student(String locate, String name) {
		this.locate = locate;
		this.name = name;
	}

	public Student(String locate, String name, String course, String phone) {
		this(locate, name);
		this.course = course;
		this.phone = phone;
	}

	public void print() {
		System.out.println(name+"(" + phone + ") - "  + course + " (지점: " + locate + ")" );
	}

	//객체의 내용을 출력하는 메서드(toString)
	// @Override : 어노테이션(애너테이션) =? 작은 기능이 있는 정의어
	// override(오버라이드) : 부모의 메서드를 자식이 가져와서 재정의 하는 기능
	// 생성자, getter/setter, toString => 자동생성해줌.
	// 마우스 우클릭 => Source => Generate toString()...
	@Override
	public String toString() {
		return "Student [locate=" + locate + ", name=" + name + ", course=" + course + ", phone=" + phone + "]";
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
