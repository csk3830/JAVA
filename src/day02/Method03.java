package day02;

import java.util.Scanner;

public class Method03 {
	// 정수 하나를 주면
	// 해당 정수의 구구단 출력하는 메서드 (리턴 없음.)
	
	public void gugu(int a) {
		for(int i=1; i<=9; i++) {
			System.out.print(
					a + " ✖ " + i + " = " + a*i + "   "
			);
		}
	}


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System. in);
		System.out.println("구구단을 출력할 정수를 입력해 주세요. >>");
		int input = scan.nextInt();
		
		Method03 m = new Method03();
		
		m.gugu(input);

		scan.close();
	}

}
