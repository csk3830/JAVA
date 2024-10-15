package day11;

class JoinTest extends Thread{

	int start;
	int end;
	int total;
	
	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			System.out.println(i);
			this.total += i;
		}
	}
	
}

public class Thread03 {

	public static void main(String[] args) {
		// 1~50, 51~100까지의 합을 구하는 두개의 Thread를 생성
		// 그 결과를 확인
		// Thread.sleep() : 기다렸다가 실행
		// millisecond 단위 1초=1000
		
		// 두개의 Thread가 실행되고 난 후
		// Thread-0 1~50까지의 합계 출력
		// Thread-1 51~100까지의 합계 출력
		// Thread-0 + Thread-1 의 합계 출력
		
		JoinTest jt1 = new JoinTest(1, 50);
		JoinTest jt2 = new JoinTest(51, 100);
		
		jt1.start();
		try {
			jt1.join();
			Thread.sleep(1000); // millisecond단위 1초=1000
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jt2.start();
		try {
			jt2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("thread1 total > " + jt1.total);
		System.out.println("thread2 total > " + jt2.total);
		System.out.println("thread 1+2 > " + jt1.total+jt2.total);
		
		
		
	}

}
