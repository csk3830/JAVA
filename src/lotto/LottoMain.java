package lotto;

import java.util.Scanner;

public class LottoMain {
	public static void main(String[] args) {
		// 로또 프로그램
		/* --menu--
		 * 1. 로또 번호 생성 (수동) : 사용자가 직접 번호 입력
		 * 2. 로또 번호 생성 (자동) : Random
		 * 3. 당첨번호 입력(수동(일단 수동만 하고 자동은 나중에)) : 사용자가 직접 입력
		 * 4. 당첨확인 : 가장 마지막에 발행한 당첨번호로 확인
		 * 5. 역대 당첨번호 목록 확인
		 * 6. 종료
		 * 
		 * 로또는 상속을 하여 사용
		 * Lotto class = 사용자의 번호를 저장하는 클래스
		 * 	회차 : 첫 발행부터 자동 증가 1회차
		 *  6자리 배열을 넣는 클래서 (중복X), 출력
		 *  1회차 1 2 3 4 5 6 
		 * 
		 * LottoExtend(당첨번호) class => Lotto를 상속 + 보너스 번호
		 * LottoController => 처리
		 * */
		Scanner scan = new Scanner(System.in);
		LottoController lc = new LottoController();
		int menu = 0;
		
		do {
			System.out.println("--menu--");
			System.out.println("1.로또 번호 생성 (수동)|2.로또 번호 생성 (자동)");
			System.out.println("3.당첨번호 입력|4.당첨확인|5.역대 당첨번호 목록 확인|6.종료");	
			System.out.println("menu>");
			menu = scan.nextInt();
			switch(menu) {
			case 1: lc.createLotto(scan); break;
			case 2: lc.createLottoAuto(); break;
			case 3: lc.insertLotto(scan); break;
			case 4: lc.checkLotto(); break;
			case 5: lc.printLotto(); break;
			case 6: System.out.println("종료!!"); break;			
			default: System.out.println("잘못된 메뉴~!!");
			}
		}while(menu != 6);
		
		scan.close();

	}

}
