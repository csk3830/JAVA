package student;

public class Subject {
	private String code;
	private String name;
	private int point;
	private int time;
	private String professor;
	private String timetable;
	private String room;
	
	public Subject() {}
	public Subject(String code, String name, int point, int time,
			String professor, String timetable, String room) 
	{
		this.code = code;
		this.name = name;
		this.point = point;
		this.time = time;
		this.professor = professor;
		this.timetable = timetable;
		this.room = room;
	}
	
	public void insertSubject(String code, String name, int point, int time,
			String professor, String timetable, String room) 
	{
		this.code = code;
		this.name = name;
		this.point = point;
		this.time = time;
		this.professor = professor;
		this.timetable = timetable;
		this.room = room;
	}
	
	@Override
	public String toString() {
		return "Subject [code=" + code + ", name=" + name + ", point=" + point 
				+ ", time=" + time + ", professor=" + professor + ", timetable=" 
				+ timetable + ", room=" + room + "]";
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getTimetable() {
		return timetable;
	}
	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}

	
	
	
	
}
