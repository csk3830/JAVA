package day04;
//패키지가 다르면 클래스명은 같아도 상관 X

/* - 학생 정보를 관리하기 위한 클래스 
 * - 학생 기본정보 : 이름, 생년월일, 전화번호, 나이
 * - 학원 정보 : 학원명 = "EZEN" (final static), 지점
 * - 수강 정보 : 수강과목, 기간 => 수강과목도 배열, 기간도 배열
 * 	=> 여러 과목을 들을 수 있음.(여러과목을 수강하기 위해서는 배열로 처리 5과목까지 가능)
 * 
 * ex) 홍길동(010101) 010-1111-1111 / 25 => 학생정보
 * 		EZEN(인천) => 학원정보
 * 		자바 6개월, 파이썬 1개월, SQLD 1개월 => 수강정보
 * 기능(메서드)
 * - 학생의 기본정보를 출력하는 기능
 * - 학원 정보를 출력하는 기능
 * - 수강정보를 출력하는 기능
 * - 학생이 수강정보를 추가하는 기능
 */
public class Student {
	//멤버변수 선언
	//이름, 생년월일, 전화번호, 나이
	private String name; 
	private String birth;
	private String phone;
	private String age;
	//학원명="EZEN" (final static), 지점
	private final static String COMPANY="EZEN";
	private String branch;
	//수강과목, 기간
	private String[] course = new String[5];
	private String[] period = new String[5];
	//index 처리용 변수
	private int cnt;
	
	//생성자
	public Student() {}

	//phone, branch, name
	public Student(String name, String phone, String branch) {
		this.name = name;
		this.phone = phone;
		this.branch = branch;
	}

	public Student(String name, String birth, String phone, String age, String branch) {
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.age = age;
		this.branch = branch;
	}

	public void printInfo() {
//		System.out.println("--학생정보--");
		System.out.println(name+"("+birth+") "+phone+" / "+age);
	}
	public void printCompany() {
		System.out.println(COMPANY+"/"+branch+"지점");
	}
	public void printCourse() {
		if(course.length==0 || cnt == 0) {
			System.out.println("수강과목이 없습니다.");
			return;
		}
		for(int i=0;i<cnt;i++) {
			System.out.print(course[i]+"("+period[i]+")  ");
		}
		System.out.println();
	}
	
	// 수강등록
	// insertCourse()
	// 매개변수 : 등록하고자 하는 course, period
	// 리턴타입 : 배열에 데이터 추가 (리턴되는 값은 없음. ) void
	public void insertCourse(String course, String period) {
		// cnt가 0인 상황(하나도 추가되지 않은 상황
		if(cnt>=5) {
			System.out.println("더이상 수강하실 수 없습니다.");
			//배열을 늘려서 더 많은 수강을 받을 수도 있음. (배열복사)
			return;
		}
		this.course[cnt] = course;
		this.period[cnt] = period;
		cnt++;
	}
	
	
	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String[] getCourse() {
		return course;
	}

	public void setCourse(String[] course) {
		this.course = course;
	}

	public String[] getPeriod() {
		return period;
	}

	public void setPeriod(String[] period) {
		this.period = period;
	}

	public static String getCompany() {
		return COMPANY;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private String name;
//	private String birth;
//	private String phone;
//	private int age;
//	private final String ACADEMY_NAME = "EZEN";
//	private String locate;
//	private String[] course = new String[5];
//	private String[] courseMonth = new String[5];
//	private int courseCnt = 0;
//	
//	public void addCourse(String course, String courseMonth) {
//		if (courseCnt < 5) {
//			this.course[courseCnt] = course;
//			this.courseMonth[courseCnt] = courseMonth;
//			courseCnt++;
//		} else {
//			System.out.println("더 이상 과목을 추가할 수 없습니다.");
//		}
//	}
//	
//	public void printStudent(){
//		System.out.println(name+"("+birth+")"+" "+phone+" / "+age);
//	}
//	public void printAcademy() {
//		System.out.println(ACADEMY_NAME+"("+locate+")");
//	}
//	public void printCourse() {
//		if (courseCnt == 0) {
//			System.out.println("수강 과목이 없습니다.");
//		} else {
//			for (int i=0; i<courseCnt; i++) {
//				System.out.print(course[i] + " "+ courseMonth[i] + "개월" + (i==courseCnt-1 ? "" : ", ") );
//			}			
//		}
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getBirth() {
//		return birth;
//	}
//	public void setBirth(String birth) {
//		this.birth = birth;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String[] getCourse() {
//		return course;
//	}
//	public void setCourse(String[] course) {
//		this.course = course;
//	}
//	public String[] getCourseMonth() {
//		return courseMonth;
//	}
//	public void setCourseMonth(String[] courseMonth) {
//		this.courseMonth = courseMonth;
//	}
//	public String getACADEMY_NAME() {
//		return ACADEMY_NAME;
//	}
//
//	public String getLocate() {
//		return locate;
//	}
//	public void setLocate(String locate) {
//		this.locate = locate;
//	}

}
