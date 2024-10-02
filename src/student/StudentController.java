package student;

import java.util.Scanner;

public class StudentController implements Program {
	
	// 멤버변수 추가
	private Student sds[] = new Student[10];
	private int cnt;
	
	@Override
	public void insertStudent(Scanner scan) {
		if (cnt == sds.length) {
			Student[] tmp = new Student[sds.length+5];
			System.arraycopy(sds, 0, tmp, 0, cnt);
			sds = tmp;
		}
		
		System.out.print("학번 >");
		String num = scan.next();
		
		System.out.print("학생 이름 >");
		String name = scan.next();
		
		System.out.print("나이 >");
		int age = scan.nextInt();
		
		System.out.print("휴대폰 번호 >");
		String phone = scan.next();
		
		System.out.print("학생 주소 >");
		String addr = scan.next();
		
		Student sd = new Student(num, name, age, phone, addr);
		sds[cnt] = sd;
		cnt++; 
	}

	@Override
	public void printStudent() {
		if (cnt == 0) {
			System.out.println("등록된 학생이 없습니다.");
			return;
		}
		System.out.println("-- 등록된 학생 리스트 --");
		for (int i=0; i<cnt; i++) {
			System.out.println(sds[i].toString());
		}
	}

	@Override
	public void searchStudent(Scanner scan) {
		System.out.print("검색할 학번 입력 >");
		String num = scan.next();

		for(int i=0; i<cnt; i++) {
			if (sds[i].getNum().equals(num)) {
				System.out.print(sds[i].toString() + "|");
				sds[i].printSubject();
				return;
			}
		}
		System.out.println("해당 학번의 학생이 없습니다.");	
	}

	@Override
	public void modifyStudent(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerSubject(Scanner scan) {
		System.out.print("수강신청할 학번 입력 >");
	    String num = scan.next();
		
	    Student sd = null;
	    
	    for (int i=0; i<cnt; i++) {
	        if (sds[i].getNum().equals(num)) {
	            sd = sds[i];
	            break;
	        }
	    }
	    
	    if (sd == null) {
	        System.out.println("잘못된 학번입니다.");
	        return;
	    }
	    
	    System.out.print("신청할 과목 코드 >");
	    String code = scan.next();
	    System.out.print("과목명 >");
	    String name = scan.next();
	    System.out.print("학점 >");
	    int point = scan.nextInt();
	    System.out.print("시수 >");
	    int time = scan.nextInt();
	    System.out.print("교수명 >");
	    String professor = scan.next();
	    System.out.print("시간표 >");
	    String timetable = scan.next();
	    System.out.print("강의실 >");
	    String room = scan.next();
	       
	    Subject sj = new Subject();
	    sj.insertSubject(code, name, point, time, professor, timetable, room);

	    

	    	
	}

	@Override
	public void deleteSubject(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

}
