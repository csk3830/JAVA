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
		
	}

	private void modify() {
		
	}

	private void search() {
		
	}

	private void list() {
		// 상품 전체 리스트
		// 매개변수는 없고, 리턴 List
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
