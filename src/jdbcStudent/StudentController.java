package jdbcStudent;

import java.util.List;
import java.util.Scanner;

public class StudentController {
	private Scanner scan;
	private Service service;
	private boolean flag;
	
	public StudentController() {
		scan = new Scanner(System.in);
		service = new StudentServiceImpl();
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println("-- 학생관리프로그램 --");
			System.out.println("1.학생등록|2.학생리스트|3.학생검색(내정보보기)|4.내정보수정|5.학생삭제|6.종료");
			System.out.println("menu > ");
			int menu = scan.nextInt();
			switch(menu){
			case 1: register(); break;
			case 2: list(); break;
			case 3: search(); break;
			case 4: modify(); break;
			case 5: delete(); break;
			case 6: 
				flag = false;
				System.out.println("종료!"); break;
			default: System.out.println("잘못된 메뉴!!");
			}
		}
		
	}

	private void delete() {
		System.out.println("삭제할 학번 입력 > ");
		int sno = scan.nextInt();
		int isOk = service.delete(sno);
		System.out.println("학생삭제 >"+ (isOk > 0 ? "성공":"실패"));
	}

	private void modify() {
		// 학생 수정(내정보 수정) => phone, address, sno
		System.out.println("수정할 학번 입력 > ");
		int sno = scan.nextInt();
		System.out.println("수정할 연락처 입력 > ");
		String phone = scan.next();
		System.out.println("수정할 주소 입력 > ");
		String address = scan.next();
		
		Student s = new Student(phone, address, sno);
		
		int isOk = service.update(s);
		System.out.println("내정보수정 >"+ (isOk > 0 ? "성공":"실패"));
	}

	private void search() {
		System.out.println("검색할 학번 입력 > ");
		int sno = scan.nextInt();
		Student s = service.getStudent(sno);
		System.out.println(s);
	}

	private void list() {
		List<Student> students = service.getList();
		for(Student s : students) {
			System.out.println(s.print());
		}
	}

	private void register() {
		System.out.println("학생 이름 >");
		String name = scan.next();
		System.out.println("생년월일 > ");
		String birth = scan.next();
		System.out.println("연락처 > ");
		String phone = scan.next();
		System.out.println("주소 > ");
		String address = scan.next();
		Student s = new Student(name, birth, phone, address);
		
		int isOk = service.insert(s);
		System.out.println("학생등록 >"+ (isOk > 0 ? "성공":"실패"));
	}
	
	
	
	
}
