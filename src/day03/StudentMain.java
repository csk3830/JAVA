package day03;

public class StudentMain {

	public static void main(String[] args) {
		Student s = new Student("incheon", "홍길동");
		s.print();
		System.out.println(s); //자동으로 toString 호출
		Student s1 = new Student("incheon", "김순이", "AWS 개발자 양성 과정", "010-1111-1111");
		s1.print();
		//toString이 없으면 객체의 주소가 출력
		System.out.println(s1);
		Student s2 = new Student("incheon", "김영철", "JAVA", "010-1111-2222");
		Student s3 = new Student("seoul", "이순이", "AWS 개발자 양성 과정", "010-1111-3333");
		Student s4 = new Student("incheon", "박승이", "AWS 개발자 양성 과정", "010-1111-4444");
		Student s5 = new Student("seoul", "최순철", "JAVA", "010-1111-5555");
		
		Student[] studentArr = new Student[6];
		
		studentArr[0]=s;
		studentArr[1]=s1;
		studentArr[2]=s2;
		studentArr[3]=s3;
		studentArr[4]=s4;
		studentArr[5]=s5;
		
		// 전체 학생명단 출력
		for(Student a : studentArr) {
			a.print();
			// 또는 System.out.println(a);
		}
		
		System.out.println("-----------------------------------");
		//홍길동의 정보를 출력
		//equals() : String의 값이 같은지 확인하는 메서드
		String searchName = "홍길동";
		for(Student a : studentArr) {
			if(a.getName().equals(searchName)){
				a.print();
			}
		}
		
		System.out.println("-----------------------------------");	
		//incheon 지점 학생들 명단 출력
		//학생이 없다면 명단이 없습니다. 출력
		boolean isIncheon = false;
		String searchLocate = "seoul";
		
		for(int i=0;i<studentArr.length;i++) {
			if(studentArr[i].getLocate().equals(searchLocate)) {
				isIncheon = true;
				studentArr[i].print();
			}
		}
		if(!isIncheon) {
			System.out.println("명단이 없습니다.");
		}
		
		System.out.println("-----------------------------------");	
		//홍길동의 group을 AWS로 변경 => 출력
		String course = "전산회계";
		
		for(Student a : studentArr) {
			if(a.getName().equals(searchName)){
				a.setCourse(course);
				a.print();
			}
		}
		
	}

}
