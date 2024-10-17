package jdbcStudent;

public class Student {
	
	private int sno;
	private String sname;
	private String birth;
	private String phone;
	private String address;
	private String regdate; // now()
	
	public Student() {}
	
	//학생 등록 -> sname, birth, phone, address
	public Student(String sname, String birth, String phone, String address) {
		this.sname = sname;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
	}
	
	//학생 리스트 -> sno, sname 출력용 print() 메서드 생성
	public Student(int sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}
	
	//학생 상세보기 -> 전부
	public Student(int sno, String sname, String birth, String phone, String address, String regdate) {
		this(sname, birth, phone, address);
		this.sno = sno;
		this.regdate = regdate;
	}
	
	//학생 수정 -> phone, address, sno
	public Student(String phone, String address, int sno) {
		this.phone = phone;
		this.address = address;
		this.sno = sno;
	}
	
	public String print() {
		return sname + "("+sno+")";
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return sname + "(" + sno+ ")" + "/생년월일:" + birth + "/연락처:" + phone + "/주소:"
				+ address + "/등록일:" + regdate ;
	}
	
	
	
	
	
}
