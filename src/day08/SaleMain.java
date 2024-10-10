package day08;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
		// 키오스크
		/* menu
		 * 1.메뉴추가|2.메뉴삭제|3.메뉴수정(가격수정)
		 * 4.메뉴보기(전체메뉴보기)|5.주문|6.주문내역출력(영수증)
		 * 7.종료
		 *  */
		Scanner scan = new Scanner(System.in);
		String menu="";
		SaleController sc = new SaleController();
		
		do {
			System.out.println("[menu]  1.메뉴추가|2.메뉴삭제|3.메뉴수정(가격수정)");
			System.out.println("4.메뉴보기(전체메뉴보기)|5.주문|6.주문내역출력(영수증)");
			System.out.println("7.종료 >> ");
			menu = scan.next();
			
			switch(menu) {
			case "1": sc.addMenu(scan); break;
			case "2": sc.deleteMenu(scan); break;
			case "3": sc.modifyMenu(scan); break;
			case "4": sc.printMenu(); break;
			case "5": sc.order(scan); break;
			case "6": sc.printOrder(); break;
			case "7":  System.out.println("종료"); break;
			default: System.out.println("잘못된 메뉴입니다."); break;
			}
			
		}while(!menu.equals("7"));
		
		scan.close();

	}

}
