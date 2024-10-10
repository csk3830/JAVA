package day08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MapEx01 {

	public static void main(String[] args) {
		/* 단어장
		 * 단어 5개를 입력받아 콘솔에 출력하는 기능
		 * --단어장--
		 * hello : 안녕
		 * apple : 사과
		 * orange : 오렌지
		 * map 저장 후 출 출력
		 * */
		
		Scanner scan = new Scanner(System.in);
		int size = 5;
		Map<String, String> map = new HashMap<>();
		
		System.out.println("--단어장 입력 start--");
		while(map.size() < size) {
			System.out.println("(영단어/한글)을 입력해 주세요.>");
			// 공백허용 scan.nextLine();
			// enter 콘솔입력시 완료
			// nextLine() : enter값으로 인지하는 케이스는
			// 다른 입력값 -> nextLine()이 오는 케이스
			String input = scan.next();
			String inputArr[] = input.split("/");
			String eng = inputArr[0];
			String kor = inputArr[1];
			
			map.put(eng, kor);
		}
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+" : "+map.get(key));
		}
		
		scan.close();

	}

}
