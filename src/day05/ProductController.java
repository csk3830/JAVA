package day05;

import java.util.Scanner;

public class ProductController { // 컨트롤러는 생성자가 필요 없음.
// Product 배열 생성
// 추가, 삭제, 수정, 리스트 보기
	private Product menu[] = new Product[2];
	private int cnt; // index 역할, 넘버링 대신으로 넣어도 좋음.

	public void printProduct() {
		if (cnt == 0) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}
		System.out.println("-- 등록된 상품 리스트 --");
		for (int i = 0; i < cnt; i++) {
			System.out.print(menu[i].toString() + "  ");
		}
		System.out.println();
	}

	public void insertProduct(Scanner scan) {
		// 상품추가
		// 배열이 다 찼다면... 배열 늘려주기.
		// 배열은 길이를 한번 정하면 변경 불가능.
		// 더 긴 길이의 배열을 생성하여 배열 복사 후 배열 교체(배열 이사)
		if (cnt == menu.length) {
			// 5개 더 많은 길이의 배열을 생성
			Product[] tmp = new Product[menu.length + 5];
			// 배열복사 기존배열의 0번지부터 새배열의 0번지부터 복사 cnt 개수만큼 복사
			System.arraycopy(menu, 0, tmp, 0, cnt);
			menu = tmp;
		}

		System.out.println("상품명 >");
		String name = scan.next();
		System.out.println("가격>");
		int price = scan.nextInt();
		Product p = new Product();
		p.insertProduct(name, price);
		menu[cnt] = p;
		cnt++;

//		if(cnt>=menu.length) {
//			System.out.println("더 이상 상품을 등록할 수 없습니다.");
//		}
//		System.out.print("상품명 >");
//		String name = scan.next();
//		System.out.print("가격 >");
//		int price = scan.nextInt();		
//		
//		menu[cnt] = new Product(name, price);
//		cnt++;
	}

	public void deleteProduct(Scanner scan) {
// 상품삭제 : 이름을 검색하여 해당 상품을 삭제
		System.out.println("삭제할 상품명>");
		String deleteName = scan.next();
		int index = -1; // 없는 번지를 기본값으로 설정
		for (int i = 0; i < cnt; i++) {
			if (menu[i].getName().equals(deleteName)) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			// deteleName을 못찾았을 경우
			System.out.println("찾는 과목이 없습니다.");
			return;
		}
		// 삭제 : 찾은 위치부터 뒷번지를 앞번지로 옮기는 작업
//				for(int i=index; i<cnt-1; i++) {
//					menu[i] = menu[i+1]; // 덮어쓰기
//				}

		// arraycopy를 이용한 방법 => 속도가 빠름(성능이 우수)
		// 배열복사 기존배열의 0번지부터 새배열의 0번지부터 복사 cnt 개수만큼 복사
		int copyCnt = menu.length - index - 1;
		System.arraycopy(menu, index + 1, menu, index, copyCnt);

		// 끝번지는 null
		menu[cnt - 1] = null;
		// 한개의 상품 줄어듦
		cnt--;
		printProduct(); // 삭제후 출력

//		System.out.print("삭제할 상품명 >");
//        String name = scan.next();
//        int delIdx = 999999;
//        
//        for(int i=0;i<cnt;i++) {
//        	if(menu[i].getName().equals(name)) {
//        		// i = 검색한 상품의 index
//        		delIdx = i;
//        	}
//        }
//        
//        if (delIdx == 999999){
//        	System.out.println("검색 결과가 없습니다.");
//        } else {
//        	for(int i=delIdx;i<cnt-1;i++) {
//        		menu[i] = menu[i + 1];
//        	} 
//        	cnt--;	
//        }
	}

	public void modifyProduct(Scanner scan) {
		// 상품수정 : 이름을 검색하여 금액만 수정
		System.out.println("수정할 상품명>");
		String searchName = scan.next();
		for (int i = 0; i < cnt; i++) {
			if (menu[i].getName().equals(searchName)) {
				System.out.println("수정금액>");
				int price = scan.nextInt();
				menu[i].setPrice(price);
				return;
			}
		}
		System.out.println("찾는 상품이 없습니다.");

//		System.out.println("검색할 상품 번호 >");
//		String searchName = scan.next();
//		System.out.println("다음 상품명으로 변경합니다. >");
//		String modName = scan.next();
//		System.out.println("다음 가격으로 변경합니다. >");
//		int price = scan.nextInt();
//		
//		boolean isName = false;
//		
//		for(int i=0;i<cnt;i++) {
//        	if(menu[i].getName().equals(searchName)) {
//        		isName = true;
//        		menu[i] = new Product(modName, price);        		
//        	}
//        }
//		
//		if(!isName) {
//			System.out.println("검색 결과가 없습니다.");
//		}
//		
	}

	public void setMenu(Product[] menu) {
		this.menu = menu;
	}

	public Product[] getMenu() {
		return menu;
	}
}
