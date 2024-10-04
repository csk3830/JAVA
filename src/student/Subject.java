package student;

public class Subject {
	
	// --Subject 클래스가 가져야 하는 기본적인 내용--
	// 과목정보 : 과목코드, 과목명, 학점, 시수, 교수명, 시간표, 강의장
	// 멤버변수, 생성자, getter/setter, toString(과목정보 출력)
	private String subCode;
	private String subName;
	private int subPoint;
	private int subTime;
	private String subProfessor;
	private String subScheduler;
	private String subRoom;
	
	// 생성자
	public Subject() {}
	
	// 과목코드,과목명만 받는 생성자
	public Subject(String subCode, String subName) {
		this.subCode = subCode;
		this.subName = subName;
	}

	public Subject(String subCode, String subName, int subPoint, int subTime, String subProfessor, String subScheduler,
			String subRoom) {
		this.subCode = subCode;
		this.subName = subName;
		this.subPoint = subPoint;
		this.subTime = subTime;
		this.subProfessor = subProfessor;
		this.subScheduler = subScheduler;
		this.subRoom = subRoom;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getSubPoint() {
		return subPoint;
	}

	public void setSubPoint(int subPoint) {
		this.subPoint = subPoint;
	}

	public int getSubTime() {
		return subTime;
	}

	public void setSubTime(int subTime) {
		this.subTime = subTime;
	}

	public String getSubProfessor() {
		return subProfessor;
	}

	public void setSubProfessor(String subProfessor) {
		this.subProfessor = subProfessor;
	}

	public String getSubScheduler() {
		return subScheduler;
	}

	public void setSubScheduler(String subScheduler) {
		this.subScheduler = subScheduler;
	}

	public String getSubRoom() {
		return subRoom;
	}

	public void setSubRoom(String subRoom) {
		this.subRoom = subRoom;
	}
	
	@Override
	public String toString() {
		return "Subject [subCode:" + subCode + ", subName:" + subName + "]";
	}
	
	
	
	
	
	
	
	
	
//	private String code;
//	private String name;
//	private int point;
//	private int time;
//	private String professor;
//	private String timetable;
//	private String room;
//	
//	public Subject() {}
//	public Subject(String code, String name, int point, int time,
//			String professor, String timetable, String room) 
//	{
//		this.code = code;
//		this.name = name;
//		this.point = point;
//		this.time = time;
//		this.professor = professor;
//		this.timetable = timetable;
//		this.room = room;
//	}
//	
//	public void insertSubject(String code, String name, int point, int time,
//			String professor, String timetable, String room) 
//	{
//		this.code = code;
//		this.name = name;
//		this.point = point;
//		this.time = time;
//		this.professor = professor;
//		this.timetable = timetable;
//		this.room = room;
//	}
//	
//	@Override
//	public String toString() {
//		return "Subject [code=" + code + ", name=" + name + ", point=" + point 
//				+ ", time=" + time + ", professor=" + professor + ", timetable=" 
//				+ timetable + ", room=" + room + "]";
//	}
//	
//	public String getCode() {
//		return code;
//	}
//	public void setCode(String code) {
//		this.code = code;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getPoint() {
//		return point;
//	}
//	public void setPoint(int point) {
//		this.point = point;
//	}
//	public int getTime() {
//		return time;
//	}
//	public void setTime(int time) {
//		this.time = time;
//	}
//	public String getProfessor() {
//		return professor;
//	}
//	public void setProfessor(String professor) {
//		this.professor = professor;
//	}
//	public String getTimetable() {
//		return timetable;
//	}
//	public void setTimetable(String timetable) {
//		this.timetable = timetable;
//	}
//	public String getRoom() {
//		return room;
//	}
//	public void setRoom(String room) {
//		this.room = room;
//	}

	
	
	
	
}
