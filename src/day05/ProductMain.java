package day05;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		// 키오스크 생성
		// 1.전체 상품리스트 | 2.상품등록 | 3.상품삭제 | 4.상품수정 | 5.종료 
		
		ProductController productController = new ProductController();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		do {
			//메뉴를 받을 때 필요, 상품을 받을 때 필요
			// 스캐너를 매개변수로 전달
			System.out.println("1.전체 상품리스트 | 2.상품등록 | 3.상품삭제 | 4.상품수정 | 5.종료 ");
			System.out.print("menu > ");
			menu = scan.nextInt();
			switch(menu) {
			case 1: productController.printProduct();
				break;
			case 2: productController.insertProduct(scan);
				break;
			case 3: productController.deleteProduct(scan);
				break;
			case 4: productController.modifyProduct(scan);
				break;
			case 5: System.out.println("키오스크 종료!!"); 
				break;
			default: System.out.println("잘못된 메뉴입니다.");
			}
			
		}while(menu != 5);
		
		scan.close();

	}

}
