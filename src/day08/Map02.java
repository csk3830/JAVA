package day08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Map02 {

	public static void main(String[] args) {
		/* 과목과 점수를 입력받아(Scanner) map에 저장 후 출력
		 * 합계, 평균 출력
		 * 종료 키워드가 나올 때까지 반복 (1=계속, 0=종료)
		 * 과목/점수 입력 > 국어 78
		 * 1=계속, 0=종료 > 1
		 * 영어 98
		 * .. 반복
		 * */
		Scanner scan = new Scanner(System.in);

		int menu = -1;
		String subjectScore;
		String subject;
		int score = 0;
		double avg = 0;
		int sum = 0;
		Map<String, Integer> map = new HashMap<>();
		
		do {
			System.out.println("과목/점수 입력 > ");				
			subjectScore = scan.next();
			
			String tmpArr[] = subjectScore.split("/");
			subject = tmpArr[0];
			score = Integer.parseInt(tmpArr[1]);

			map.put(subject, score);
			
			System.out.println("계속하시겠습니까? (1=계속, 0=종료) > ");
			menu = scan.nextInt();
			if (menu == 0) {break;}
		
		}while(menu != 0);
		
		for(String key : map.keySet()) {
			sum += map.get(key);
			System.out.println(key+" "+map.get(key));
		}
		
		System.out.println("합계: "+sum);
		
		avg = sum / (double)map.size(); 
		System.out.println("평균: "+avg);
		
		scan.close();

	}

}
