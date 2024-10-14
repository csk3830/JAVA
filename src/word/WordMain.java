package word;

import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		/* 단어장 프로그램
		 * Word class 생성
		 * - 넘버링, 단어, 뜻(list<String>)
		 * 1.단어등록|2.단어검색|3.단어수정|4.단어출력|5.단어삭제|6.단어파일로출력|7.종료
		 * 6. - 내가 등록한 모든 단어를 메모장에 파일로 출력
		 * Word (equals 사용) : 단어가 같으면 같은 객체(2.검색, 5.삭제, 3.수정, 4.출력까지)
		 * */
		Scanner scan = new Scanner(System.in);
		WordController wc = new WordController();
		wc.addWord();
		int menu = -1;
		do {
			System.out.println("--menu--");
			System.out.println("1.단어등록|2.단어검색|3.단어수정|4.단어출력|5.단어삭제|6.단어파일로출력|7.종료");
			System.out.println("menu>");
			menu = scan.nextInt();
			switch(menu) {
			case 1: wc.insertWord(scan); break;
			case 2: wc.searchWord(scan); break;
			case 3: wc.modifyWord(scan); break;
			case 4: wc.printWord(); break;
			case 5: wc.removeWord(scan); break;
			case 6: wc.fileWord(); break;
			case 7: System.out.println("종료~!!");  break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 7);
		scan.close();
		
		
		
	}

}
