package day02;

import java.util.Scanner;

public class MethodEx01 {
	public void sum(int a, int b) {
		System.out.println("결과👨: " + a + " ➕ " + b + " = " + (a+b));
	}
	public void sub(int a, int b) {
		System.out.println("결과👨: " + a + " ➖ " + b + " = " + (a-b));
	}
	public void mul(int a, int b) {
		System.out.println("결과👨: " + a + " ✖ " + b + " = " + (a*b));
	}
	public void div(int a, int b) {
	    System.out.println("결과👨: " + (b==0 ? "0으로 나눌 수 없습니다." : a + " ➗ " + b + " = ") + (a/(double)b));
	}
	public void mod(int a, int b) {
		System.out.println("결과👨: " + (b==0 ? "0으로 나눌 수 없습니다." : a + " % " + b + " = ") + a%b);
	}	
	public static void main(String[] args) {
		/* 계산기 만들기
		 * --menu--
		 * 1.덧셈|2.뺄셈|3.곱셈|4.나눗셈|5.나머지|6.종료
		 * > 메뉴선택 1
		 * > 숫자 입력 : 1 5
		 * 결과 : 1+5 = 6
		 * (더하기 메서드를 호출하여 연산결과를 출력)
		 * 4, 5번은 두번째 숫자가 0이면 0으로 나눌 수 없습니다.
		 * */
		
		Scanner scan = new Scanner(System.in);
		MethodEx01 m = new MethodEx01();
		
		
		do {
			System.out.println("--menu--");
			System.out.println("1.덧셈|2.뺄셈|3.곱셈|4.나눗셈|5.나머지|6.종료");
			
			System.out.print("메뉴 선택 > ");
			int menu = scan.nextInt();
			
			if (menu == 6) {
				System.out.println("종료합니다.");
				break;
			}
			
			System.out.print("숫자 입력 > ");
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			
			switch(menu) {
			case 1: m.sum(num1, num2); break;
			case 2: m.sub(num1, num2); break;
			case 3: m.mul(num1, num2); break;
			case 4: m.div(num1, num2); break;
			case 5: m.mod(num1, num2); break;
			default: System.out.println("잘못된 메뉴입니다."); break;
			}
			
		}while (true);
		
		scan.close();
		
		

	}

}
