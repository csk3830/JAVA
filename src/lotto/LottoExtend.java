package lotto;

public class LottoExtend extends Lotto {
	// Lotto 클래스를 상속받아서 보너스 처리만 하면 됨.
	private int bonus;	//보너스 번호만 있으면 됨.

	@Override
	protected void randomLotto() {
		super.randomLotto();
		while(true) {
			int r = random();
			if(!isContain(r)) {
				bonus = r;
				break;
			}
		}
	}

	@Override
	protected void init() {
		// 배열 초기화
		super.init(); //numbers 배열을 새로 만들어놓은 상태
		bonus = 0;
	}

	@Override
	protected void insertNumbers(int[] arr) {
		// 가져온 번호가 7자리일 경우...
		super.insertNumbers(arr);	//6자리만 넣기
		this.bonus = arr[numbers.length];	//6번지 채우기 나머지는 버리기
	}
	
	protected void insertNumbers(int[] arr, int bonus) {
		// 가져온 번호는 6자리, 보너스를 별도로 가져오는 경우...
		super.insertNumbers(arr);
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString()+"["+bonus+"]";
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	
	
	
	
	
	
	
//	private int bonus; 
//
//	public LottoExtend(int round) {
//		super(round);
//	}
//
//	public void printLotto(){
//		System.out.print(getRound() + "회차 "); 
//	    for (int i=0; i<getNums().length; i++) {
//	        System.out.print(getNums()[i]);
//	        if (i<getNums().length-1) {
//	            System.out.print(" ");
//	        }
//	    }
//	    System.out.println();
//	}
//	
//	public void addWinNum(Scanner scan) {
//        createHandNum(scan);
//        System.out.print("보너스 번호 입력(1~45) > ");
//        int bonus = scan.nextInt();
//        setBonus(bonus);
//    }
//	
//	@Override
//	public String toString() {
//		return "LottoExtend [bonus=" + bonus + "]";
//	}
//
//	public void setBonus(int bonus) {
//		this.bonus = bonus;
//	}
//	
//	public int getBonus() {
//		return bonus;
//	}


	

}
