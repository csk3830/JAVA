package jdbc;

import java.util.List;
import java.util.Scanner;

public class ProductController {
	/* controller <-> Service <-> DAO <-> DB
	 * Controller 모든 메뉴 분기처리
	 * */
	private Scanner scan;
	private Service svc; //아직 없음.
	private boolean flag; //종료변수
	
	public ProductController() {
		scan = new Scanner(System.in);
		svc = new ProductServiceImpl(); //service interface 구현체
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println("--상품관리프로그램--");
			System.out.println("1.상품등록|2.상품목록|3.상품검색(상세보기)|4.상품수정|5.상품삭제|6.종료");
			System.out.println("menu > ");
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1: register(); break;
			case 2: list(); break;
			case 3: search(); break;
			case 4: modify(); break;
			case 5: delete(); break;
			case 6: 
				flag = false;
				System.out.println("종료!!"); break;
			default: System.out.println("잘못된 메뉴!!");
			}
		}
		
	}

	private void delete() {
		// 상품 삭제
		// 삭제할 번호(pno) isOk return
		System.out.println("삭제할 번호 입력 > ");
		int pno = scan.nextInt();
		//메서드 명은 상관없음.(기능과 관련있게 명명)
		// set get insert register add update, modify, remove, delete
		int isOk = svc.delete(pno); // Service의 delete 메서드를 호출
	    System.out.println("상품삭제 >" + (isOk > 0 ? "성공" : "실패"));
		
	}

	private void modify() {
		// 상품 수정 : 이름, 가격, 상세내용
		System.out.println("수정할 번호 입력 > ");
		int pno = scan.nextInt();
		System.out.println("상품이름:");
		String name = scan.next();
		System.out.println("상품가격:");
		int price = scan.nextInt();
		scan.nextLine(); 	//공백처리용
		System.out.println("상품상세내역:");
		String madeby = scan.nextLine();	//공백포함
		
		Product p = new Product(name, price, madeby, pno);
		int isOk = svc.update(p);
		System.out.println("상품수정 >" +(isOk > 0 ? "성공":"실패"));
	}

	private void search() {
		// 특정 상품 검색 (세부내용 madeby / regdate)
		// pno가 필요
		// select * from product where pno = ?
		// pno 값을 입력받아 매개변수로 전달 Product 객체 리턴
		System.out.println("검색할 번호 입력 > ");
		int pno = scan.nextInt();
		Product p = svc.getProduct(pno);
		System.out.println(p);
	}

	private void list() {
		// 상품 전체 리스트
		// 매개변수는 없고, 리턴 List
		// select * from product order by pno desc
		
		List<Product> list = svc.getList();
		//출력
		for(Product p : list) {
			System.out.println(p.listPrint());
		}
		
	}

	private void register() {
		// 상품등록
		System.out.println("상품이름:");
		String name = scan.next();
		System.out.println("상품가격:");
		int price = scan.nextInt();
		scan.nextLine(); 	//공백처리용
		System.out.println("상품상세내역:");
		String madeby = scan.nextLine();	//공백포함
		
		Product p = new Product(name, price, madeby);
		//service에게 p 객체 등록 요청 (메서드 작성)
		// 1 row(s) affected 0.016 sec
		// isOk =1 (DB에 성공적으로 들어감) / isOk = 0 (실패)
		int isOk = svc.insert(p);
		System.out.println("상품등록 >" +(isOk > 0 ? "성공":"실패"));
				
		
	}
	
	
}
