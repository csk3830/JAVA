package student;

import java.util.Scanner;

public class StudentController implements Program {
	
	// 멤버변수 추가 : Student 배열을 멤버변수로 추가
	private Student[] studentList = new Student[5];
	private int stdCnt = 0;
	
	@Override
	public void insertStudent(Scanner scan) {
		// 학생 추가 : 1명의 정보를 받아 Student 객체로 생성 후 배열에 추가
		System.out.println("학번>");
		String stdNum = scan.next();
		System.out.println("이름>");
		String stdName = scan.next();
		System.out.println("전화번호>");
		String stdPhone = scan.next();
		
		Student s = new Student(stdNum, stdName, stdPhone);
		// 만약 배열이 다 차서 저장할 공간이 없을 경우
		if(stdCnt == studentList.length) {
			Student[] tmp = new Student[studentList.length+5];
			System.arraycopy(studentList, 0, tmp, 0, stdCnt);
			studentList = tmp;
		}
		studentList[stdCnt] = s;
		stdCnt++;
	}
	
	@Override
	public void printStudent() {
		// 학생 배열 출력
		System.out.println("--전체 학생정보--");
		for(int i=0; i<stdCnt; i++) {
//			System.out.println(studentList[i]);		//toString
			studentList[i].stdPrint();				//메서드 호출
		}
	}
	
	@Override
	// 해당 학번의 index 리턴
	public int searchStudent(Scanner scan) {
		// 학생검색 - 학번을 기준
		// 학번을 입력받아 배열에서 탐색 후 학생정보 + 수강정보 출력
		// 없으면 없다고 출력
		System.out.println("학번>");
		String searchNum = scan.next();
		
		for(int i=0; i<stdCnt; i++) {
			if(searchNum.equals(studentList[i].getStdNum())) {
				studentList[i].stdPrint();
				studentList[i].subPrint();
				return i;
			}
		}
		System.out.println("검색한 학번이 없습니다.");
		return -1;
	}
	
	@Override
	public void modifyStudent(Scanner scan) {
		// 학생정보 수정
		int index = searchStudent(scan);
		if(index != -1) {
			System.out.println("이름>");
			String name = scan.next();
			System.out.println("전화번호>");
			String phone = scan.next();
			studentList[index].setStdName(name);
			studentList[index].setStdPhone(phone);
		}
		
	}
	
	@Override
	public void deleteStudent(Scanner scan) {
		// 학생 삭제
		int index = searchStudent(scan);
		if(index != -1) {
			int copyCnt = studentList.length - index - 1;
			System.arraycopy(studentList, index+1, studentList, index, copyCnt);
			// 마지막 번지 null 처리
			studentList[studentList.length-1] = null;
			stdCnt--;
		}
		
	}
	
	@Override
	public void registerSubject(Scanner scan) {
		// 수강과목의 정보를 입력받아 subject 객체를 생성하여 Student 클래스
		// 누가 어떤과목을 수강할지를 받아야 함.
		// 수강신청 학번을 먼저 검색 후 추가
		
		int index = searchStudent(scan);
		System.out.println("---------------------------");
		System.out.println("과목코드>");
		String subCode = scan.next();
		System.out.println("과목이름>");
		String subName = scan.next();
		//객체 생성 후 메서드 호출
		Subject sub = new Subject(subCode, subName);
		studentList[index].insertSubject(sub);
	}

	@Override
	public void deleteSubject(Scanner scan) {
		// 삭제할 수강코드를 입력받아 Student 클래스의 강의 삭제 
		int index = searchStudent(scan);
		//수강과목이 없다면 받지 않기.
		if (studentList[index].getCnt() != 0) {
			System.out.println("---------------------------");
			System.out.println("과목코드>");
			String subCode = scan.next();
			studentList[index].removeSubject(subCode);
			System.out.println(subCode+" 과목 수강철회 완료!");
	    }
	}





	
	
	
//	private Student sds[] = new Student[10];
//	private int cnt;
//	
//	@Override
//	public void insertStudent(Scanner scan) {
//		if (cnt == sds.length) {
//			Student[] tmp = new Student[sds.length+5];
//			System.arraycopy(sds, 0, tmp, 0, cnt);
//			sds = tmp;
//		}
//		
//		System.out.print("학번 >");
//		String num = scan.next();
//		
//		System.out.print("학생 이름 >");
//		String name = scan.next();
//		
//		System.out.print("나이 >");
//		int age = scan.nextInt();
//		
//		System.out.print("휴대폰 번호 >");
//		String phone = scan.next();
//		
//		System.out.print("학생 주소 >");
//		String addr = scan.next();
//		
//		Student sd = new Student(num, name, age, phone, addr);
//		sds[cnt] = sd;
//		cnt++; 
//	}
//
//	@Override
//	public void printStudent() {
//		if (cnt == 0) {
//			System.out.println("등록된 학생이 없습니다.");
//			return;
//		}
//		System.out.println("-- 등록된 학생 리스트 --");
//		for (int i=0; i<cnt; i++) {
//			System.out.println(sds[i].toString());
//		}
//	}
//
//	@Override
//	public void searchStudent(Scanner scan) {
//		System.out.print("검색할 학번 입력 >");
//		String num = scan.next();
//
//		for(int i=0; i<cnt; i++) {
//			if (sds[i].getNum().equals(num)) {
//				System.out.print(sds[i].toString() + "|");
//				sds[i].printSubject();
//				return;
//			}
//		}
//		System.out.println("해당 학번의 학생이 없습니다.");	
//	}
//
//	@Override
//	public void modifyStudent(Scanner scan) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteStudent(Scanner scan) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void registerSubject(Scanner scan) {
//		// 수강과목의 정보를 입력받아 subject 객체를 생성하여 Student 클래스의 개인 추가 메서드 호출
		
		
//		System.out.print("수강신청할 학번 입력 >");
//	    String num = scan.next();
//		
//	    Student sd = null;
//	    
//	    for (int i=0; i<cnt; i++) {
//	        if (sds[i].getNum().equals(num)) {
//	            sd = sds[i];
//	            break;
//	        }
//	    }
//	    
//	    if (sd == null) {
//	        System.out.println("잘못된 학번입니다.");
//	        return;
//	    }
//	    
//	    System.out.print("신청할 과목 코드 >");
//	    String code = scan.next();
//	    System.out.print("과목명 >");
//	    String name = scan.next();
//	    System.out.print("학점 >");
//	    int point = scan.nextInt();
//	    System.out.print("시수 >");
//	    int time = scan.nextInt();
//	    System.out.print("교수명 >");
//	    String professor = scan.next();
//	    System.out.print("시간표 >");
//	    String timetable = scan.next();
//	    System.out.print("강의실 >");
//	    String room = scan.next();
//	       
//	    Subject sj = new Subject();
//	    sj.insertSubject(code, name, point, time, professor, timetable, room);

}
