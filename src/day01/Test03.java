package day01;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		/*
		 * Scanner 클래스 : 콘솔에서 값을 입력받을 때 사용 (int)(Math.random()*개수)+시작 : 시작값부터 개수만큼 정수형
		 * 랜덤값 생성
		 */
		// 값을 입력받으려면 Scanner scan = new Scanner(System.in);

		// 주사위 값 랜덤 발생
//		int random = (int)(Math.random()*6)+1;

		// 랜덤으로 주사위를 굴려 총 30칸을 이동하시오.
		// 주사위 던진 횟수를 출력.
		/*
		 * 주사위 게임 주사위는 Enter 를 치면 던져짐. 주사위 : 3 3칸 전진 => 27칸 남음. 주사위 : 5 5칸 전진 => 22칸 남음.
		 * .... 도착!! 총 던진 횟수 > ??
		 */
		// for(반복횟수가 정해져있을 경우) / while(횟수가 일정하지 않을경우)
//		for(int i=0; i<=10; i++) {
//			// 처리 	0부터 10까지 1씩 반복
//		}
//		while(식) {
//			처리;
//		}

		// Enter 인지 => Scanner
		Scanner scan = new Scanner(System.in);
		// 주사위 값 랜덤 발생
		int sum = 0; // 누적거리
		int count = 0; // 던진 횟수
		int last = 30;
		int random = 0;

		System.out.println("게임시작~!! 주사위를 던져주세요.(enter)");

		// 주사위는 30칸을 이동할 동안 반복해서 던져야 함.

		while (sum < last) { // 거리 누적값이 30보다 작다면 실행
			scan.nextLine(); // next() : Enter 처리 불가
			random = (int) (Math.random() * 6) + 1;
			sum += random;
			count++;
			System.out.println("주사위:" + random);
//			if (last-sum > 0) {
//				System.out.println(random + "칸 전진 => " + (last - sum) + "칸 남았습니다.");
//			} else {
//				System.out.println(random + "칸 전진 => " + "도착~!!");
//			}
			
			System.out.println(random +  "칸 전진 => " + ((last - sum)<=0 ? "도착~~~!!" : (last - sum) + "칸 남았습니다."));
			
		}

		System.out.println("도착~!!, 총 이동횟수 : " + count);
		
		//ctrl+shift+f : 들여쓰기 자동 정렬

//			int throwCnt = 0;
//			int total = 30;
		
//			System.out.println("주사위 게임 start!!");
		
//			while(total > 0) {
//				System.out.print("주사위 던지기(enter) >>");
//				scan.nextLine();
//				int dice = (int)(Math.random()*6)+1;
//				total -= dice;
//				if (total < 0) {
//					total = 0;
//				}
//				throwCnt ++; 
//				System.out.println("주사위" + dice + " / " + dice + "칸 전진 => " + total + "칸 남음.");
//			}
		
//			System.out.println("도착!! 총 던진 횟수 > " + throwCnt);

		scan.close();

	}

}
