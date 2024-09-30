package day04;
/* Product 클래스 생성 : 상품을 등록하는 클래스
 * 상품명(name), 가격(price)을 멤버변수로 생성
 * 상품을 추가하는 메서드
 * 상품을 출력하는 메서드(toString)
 * ex) 사탕: 500
 * 과자 : 2000
 * 젤리 : 1000
 */

import java.util.Arrays;
import java.util.Scanner;

class Product{
	private String[] name = new String[10];
	private int[] price = new int[10];
	int cnt = 0;
	
	public void addProduct(String name, int price) {
		if(cnt>=10) {
			System.out.println("더이상 등록하실 수 없습니다.");
			return;
		}
		this.name[cnt] = name;
		this.price[cnt] = price;
		cnt++;
	}

	@Override
	public String toString() {
		return "Product [name=" + Arrays.toString(name) + ", price=" + Arrays.toString(price) + "]";
	}
	
}

public class 과제 {

	public static void main(String[] args) {
		/* 상품 10개를 등록할 수 있는 배열 생성
		 * 스캐너를 이용하여 상품 등록
		 * 등록된 상품을 출력
		 * 
		 * (10번까지 반복 가능)상품을 등록하시겠습니까? (y/n) y=> 등록  /  n=> 그만
		 * */
		Scanner scan = new Scanner(System.in);
		Product p = new Product();
		
		while (true) {
            System.out.print("상품을 등록하시겠습니까? (y/n) >");
            String choice = scan.nextLine();

            if (choice.equals("n") || choice.equals("N")) {
            	System.out.println("종료합니다.");
                break;
            } else if (choice.equals("y") || choice.equals("Y")) {
                System.out.print("상품명을 입력해 주세요. >");
                String name = scan.nextLine();
                
                System.out.print("가격을 입력해 주세요. >");
                int price = scan.nextInt();
                scan.nextLine(); 
                
                p.addProduct(name, price);
            } 
        }

		p.toString();
		
		scan.close();
		

	}

}
