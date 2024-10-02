package day04;
/* Product 클래스 생성 : 상품을 등록하는 클래스
 * 상품명(name), 가격(price)을 멤버변수로 생성
 * 상품을 추가하는 메서드
 * 상품을 출력하는 메서드(toString)
 * ex) 사탕: 500
 * 과자 : 2000
 * 젤리 : 1000
 */

import java.util.Scanner;

class Product{
	private String name;
	private int price;
	
	//생성자
	public Product() {}
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	//메서드 : 상품추가, toString
	public void insertProduct(String name, int price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return name+":"+price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
//	private String[] name = new String[10];
//	private int[] price = new int[10];
//	int cnt = 0;
//	
//	public void addProduct(String name, int price) {
//		if (cnt < 10) {
//			this.name[cnt] = name;
//			this.price[cnt]=price;
//			cnt++;
//		}else {
//			System.out.println("더 이상 제품을 등록할 수 없습니다.");
//		}
//		
//	}
//
//	@Override
//	public String toString() {
//		if (cnt == 0) {
//            return "등록된 상품이 없습니다.";
//        } else {
//        	String result = "";
//        	for (int i=0;i<cnt;i++) {
//        		result +=  name[i] + ":"+ price[i] + "\n";
//			}	
//        	return result;
//        }
//	}
	
}

public class 과제 {

	public static void main(String[] args) {
		/* 상품 10개를 등록할 수 있는 배열 생성
		 * 스캐너를 이용하여 상품 등록
		 * 등록된 상품을 출력
		 * 
		 * (10번까지 반복 가능)상품을 등록하시겠습니까? (y/n) y=> 등록  /  n=> 그만
		 * */
//		Product p = new Product("사탕",500);
//		System.out.println(p.toString());
//		p.insertProduct("젤리", 1000);
//		System.out.println(p.toString());
		Scanner scan = new Scanner(System.in);
		
		Product[] p = new Product[10];
//		Product pro = new Product(); //1개의 객체를 변경해서 배열에 추가. (연결고리(링크))만 복사됨
									 // =>새로운 값을 넣을 때마다 바뀜. ex) 사탕을 넣은 후, 젤리를 넣으면 모두 젤리로 바뀜
		
		char c = 'y';	//반복 키워드
		int cnt = 0; //index 변수
		
		while(c!='n') {		// !(c.equals("n")) => String 일 경우
			System.out.println("상품을 등록하시겠습니까? (y/n)");
			c = scan.next().charAt(0);	// 1글자 입력
			if(c=='y') {	// (c.equals("n")) => String 일 경우
				System.out.println("상품명>");
				String name = scan.next();
				System.out.println("가격");
				int price = scan.nextInt();
				
				// 객체 생성
				Product pro = new Product(name, price); 	//추가 메서드 호출
				p[cnt] = pro;
				cnt++;
			}else {
				if(c=='n') {
					System.out.println("상품등록 종료!!");
				}else {
					System.out.println("y/n만 가능합니다.");
				}
			}
			
		}
		
		System.out.println("--등록된 상품 리스트--");
		for(int i=0; i<cnt; i++) {
			System.out.println(p[i]);
		}
		
		scan.close();
		
		
		
		
//		Scanner scan = new Scanner(System.in);
//		Product p = new Product();
//		
//		while (true) {
//            System.out.print("상품을 등록하시겠습니까? (y/n) >");
//            String choice = scan.nextLine();
//
//            if (choice.equals("n") || choice.equals("N")) {
//            	System.out.println("종료합니다.");
//                break;
//            } else if (choice.equals("y") || choice.equals("Y")) {
//                System.out.print("상품명을 입력해 주세요. >");
//                String name = scan.nextLine();
//                
//                System.out.print("가격을 입력해 주세요. >");
//                int price = scan.nextInt();
//                scan.nextLine(); 
//                
//                p.addProduct(name, price);
//            } 
//        }
//
//		System.out.println("등록된 상품 목록:");
//        System.out.println(p.toString());
//		
//		scan.close();
		

	}

}
