package day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleController {
//	SaleController 
//	Menu List =>  List<Menu> menu = new ArrayList<>();
//	Order List =>  List<Order> order = new ArrayList<>();
	List<SaleMenu> saleMenu = new ArrayList<>();
	List<SaleOrder> saleOrder = new ArrayList<>();

	public void dataMenu() {
		saleMenu.add(new SaleMenu("라면", 5500));
		saleMenu.add(new SaleMenu("김밥", 3000));
		saleMenu.add(new SaleMenu("쫄면", 6000));
		saleMenu.add(new SaleMenu("돈까스", 8000));
		saleMenu.add(new SaleMenu("만두", 6000));
	}
	
	public void addMenu(Scanner scan) {
		System.out.print("추가할 메뉴명 입력 >> ");
		String productName = scan.next();
		System.out.print("가격 >> ");
		int price = scan.nextInt();
		saleMenu.add(new SaleMenu(productName, price));
		System.out.println("메뉴가 추가되었습니다.");
	}

	public void deleteMenu(Scanner scan) {
		System.out.println("삭제할 메뉴명 입력 >> ");
		String productName = scan.next();
		SaleMenu tmp = null;

		for (SaleMenu m : saleMenu) {
			if (m.getProductName().equals(productName)) {
				tmp = m;
				break;
			}
		}
		if (tmp != null) {
			saleMenu.remove(tmp);
			System.out.println("메뉴가 삭제되었습니다.");
		} else {
			System.out.println("메뉴가 존재하지 않습니다.");
		}
	}

	public void printMenu() {
		System.out.println("----메뉴목록----");
		if(saleMenu.isEmpty()) {
			System.out.println("현재 등록된 메뉴가 없습니다.");
		}else {
			for(SaleMenu m : saleMenu) {
				System.out.println(m);
			}
		}
	}
	
	public void modifyMenu(Scanner scan) {
		System.out.println("가격을 수정할 메뉴명 입력 >> ");
		String productName = scan.next();
		for (SaleMenu m : saleMenu) {
			if(m.getProductName().equals(productName)) {
				System.out.println("새 가격 입력 >> ");
				int newPrice = scan.nextInt();
				saleMenu.remove(m);
				saleMenu.add(new SaleMenu(productName, newPrice));
				System.out.println("가격이 수정되었습니다.");
				return;
			}
		}
		System.out.println("메뉴가 존재하지 않습니다.");
	}

	public void order(Scanner scan) {
		System.out.println("주문할 메뉴의 ID 입력 >> ");
		int productId = scan.nextInt();
		System.out.println("수량 입력 >> ");
		int quantity = scan.nextInt();
		
		for(SaleMenu m:saleMenu) {
			if(m.getProductId()==productId) {
				saleOrder.add(new SaleOrder(m.getProductId(), m.getProductName(), m.getPrice(), quantity));
				System.out.println("주문 완료.");
				return; 
			}			
		}
		System.out.println("메뉴가 존재하지 않습니다.");
	}
	
	public void printOrder() {
	    if (saleOrder.isEmpty()) {
	        System.out.println("주문 내역이 없습니다.");
	        return;
	    }
	    System.out.println("----주문내역----");
	    for (SaleOrder o : saleOrder) {
	    	System.out.println(
	    			"주문번호:"+o.getOrderId()+"\n"
	    			+ "메뉴:"+o.getProductName()+"\n"
	    			+ "수량:"+o.getQuantity()+"\n"
	    			+ "금액:"+o.getTotalPrice()
	    			);
	    	
	    }
	}
}
