package day01;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		//ex : 검색어를 입력받아 fileName 배열에 검색어가 존재하면 해당 파일 이름을 출력
		/* 검색어 : java
		 * spring.java
		 * String.java
		 * 
		 * 검색어 : s
		 * spring.java
		 * css.css
		 * String.java
		 * 
		 * 검색어 : 가나다
		 * 검색결과가 없습니다.
		 */
		
		Scanner scan = new Scanner(System.in);
		String[] fileName = {"spring.java", "python.py", "react.jsx", "css.css", "String.java", "component.jsx", "test.txt"};
		boolean isResult = false;
		
		System.out.print("검색어를 입력해 주세요..>");
	
		String search = scan.nextLine();
		
		System.out.println("---검색어:"+search+"---");
		for(String a:fileName) {
			if (a.toLowerCase().contains(search.toLowerCase())) {
				isResult = true;
				System.out.println(a);
			}
		}
		if(isResult == false) {
			System.out.println("검색 결과가 없습니다.");
		}
			
		scan.close();

	}

}
