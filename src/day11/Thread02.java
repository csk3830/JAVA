package day11;

class MyThread2 implements Runnable{

	@Override
	public void run() {
		// run은 반드시 구현해야 함.
		// 0~500까지 반복하여 실행하는 구문수행
		for(int i=0; i<=500; i++) {
			System.out.println(i+"번째 thread > "+ Thread.currentThread().getName());
		}
		
	}
	
	
}

public class Thread02 {

	public static void main(String[] args) {
		// 2. runnable 구현하는 방법
		// join() : 동시에 여러개의 스레드가 실행될 때 다른 스레드의 결과를 참조하여 실행되어야 할 경우 join() 메서드를 사용
		// join() : try~catch 필요 
		System.out.println(Thread.currentThread().getName());
		
		System.out.println("main thread start~!!");
		
		MyThread2 th2 = new MyThread2();
		Thread th = new Thread(th2);
		th.start();
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread th3 = new Thread(new MyThread2());
		th3.start();
		try {
			th3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main thread end~!!");
	}

}
