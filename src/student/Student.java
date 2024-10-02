package student;

public class Student {
	private String num;
	private String name;
	private int age;
	private String phone;
	private String addr;
	private Subject sj[] = new Subject[10];
	private int cnt;
	
	public Student() {}
	
	public void printSubject() {
		if (cnt == 0) {
			System.out.println("신청된 과목이 없습니다.");
			return;
		}
		System.out.println("-- 수강신청 리스트 --");
		for(int i=0; i<cnt; i++) {
			System.out.println(sj[i].toString()+" ");
		}
	}
	
	
	
	public Student(String num, String name, int age, String phone, String addr) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
	}
	
	public Student(Subject[] sj) {
		this.sj = sj;
	}
	
	public void insertStudent(String num, String name, int age, String phone, String addr) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
	}
	public void insertStudent(Subject[] sj) {
		this.sj = sj;
	}

	@Override
	public String toString() {
		return name+"("+age+"세"+")"+"|"+"학번:"+num+"|"+"휴대폰 번호:"+phone
				+ "|"+"주소:"+addr;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Subject[] getSj() {
		return sj;
	}

	public void setSj(Subject[] sj) {
		this.sj = sj;
	}
	
	
	
}
