// 키오스크
/* menu
 * 1.메뉴추가|2.메뉴삭제|3.메뉴수정(가격수정)
 * 4.메뉴보기(전체메뉴보기)|5.주문|6.주문내역출력(영수증)
 * 7.전체 판매 내역|8.종료
 * */

// Menu  Class 생성
// 제품ID
// 제품명
// 가격
//
// Order Class 생성 Menu 상속
// 주문번호
// 제품ID
// 제품명
// 수량
// 가격
// 금액
//
// SaleController 
// Menu List =>  List<Menu> menu = new ArrayList<>();
// Order List =>  List<Order> order = new ArrayList<>();

package sale;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
		// 키오스크
		/* menu
		 * 1.메뉴추가|2.메뉴삭제|3.메뉴수정(가격수정)
		 * 4.메뉴보기(전체메뉴보기)|5.주문|6.주문내역출력(영수증)
		 * 7.종료
		 *  */
		
		/* 1,2,3,7 => 관리자용
		 * 4,5,6 => 사용자용
		 * */
		Scanner scan = new Scanner(System.in);
		String menu="";
		SaleController sc = new SaleController();
		//미리 몇가지 메뉴 추가 메서드 호출
		sc.addMenu();		
		
		do {
			System.out.println("[menu]  1.메뉴추가|2.메뉴삭제|3.메뉴수정(가격수정)");
			System.out.println("4.메뉴보기(전체메뉴보기)|5.주문|6.주문내역출력(영수증)");
			System.out.println("7.종료 >> ");
			menu = scan.next();
			
			switch(menu) {
			case "1": sc.add(scan); break;
			case "2": sc.delete(scan); break;
			case "3": sc.update(scan); break;
			case "4": sc.printMenu(); break;
			case "5": sc.orderPick(scan); break;
			case "6": sc.orderPrint(scan); break;
			case "7":  System.out.println("종료"); break;
			default: System.out.println("잘못된 메뉴입니다."); break;
			}
			
		}while(!menu.equals("7"));
		
		scan.close();

	}

}
