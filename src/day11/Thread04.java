package day11;

class Bank{
	private int money = 20000;
	
	//입금 : synchronized : 동기화(순차접근)
	public synchronized void saveMoney(int save) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.money = m+save;
		
	}
	//출금
	public synchronized void minusMoney(int minus) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.money = m-minus;
		
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}

class Hong extends Thread{
	@Override
	public void run() {
		System.out.println("홍길동이 입금 시작~!!");
		Thread04.myBank.saveMoney(10000);
		System.out.println("saveMoney(10000) > "+Thread04.myBank.getMoney());
	}
	
}

class HongWife extends Thread{
	@Override
	public void run() {
		System.out.println("홍길동 와이프 출금 시작~!!");
		Thread04.myBank.minusMoney(5000);
		System.out.println("minusMoney(5000) > "+Thread04.myBank.getMoney());
	}
}

public class Thread04 {
	//계좌 생성 : 공유영역에 생성
	public static Bank myBank = new Bank();
	

	public static void main(String[] args) {
		Hong h = new Hong();
		h.start();
		
		HongWife hw = new HongWife();
		hw.start();
		
		
		
		/* critical section(임계영역)은 두 개 이상의 thread가
		 * 동시에 접근할 수 있는 영역 (공유 영역)
		 * 동시에 여러개의 thread가 접근하여 공유영역을 가지려고 하면 문제가 생길 수 있음.
		 * 교착상태(deadlock)가 발생
		 * 한 순간에는 하나의 thread만 사용가능 : 세마포어(semaphore)
		 * 세마포어를 얻은 스레드만 접근이 가능 / 나머지는 대기상태가 됨.
		 * 
		 * 동기화(순서화) : synchronized
		 * 동기화가 필요한 메서드 앞에 선언
		 * */

		/* bank 클래스 생성
		 * 계좌 1개 생성 => 공유영역 (static)
		 * hong / hongwife
		 * 잔액 : 10000
		 * */
		
	}

}
