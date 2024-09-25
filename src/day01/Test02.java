package day01;

public class Test02 {

	public static void main(String[] args) {
		/* 국어 영어 수학 세 점수의 합계와 평균을 출력
		 * if문 이용하여 평균 80점 이상이면 pass / fail
		 */
		int kor = 78;
		int eng = 80;
		int math = 90;
		
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+avg);
		
		if(avg>=80) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
	}

}
