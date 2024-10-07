package lotto;

import java.util.Scanner;

public class LottoController {
	//당첨번호는 여러개 배열로 저장
	private LottoExtend lotto[] = new LottoExtend[5];
	private int lCount=0;
 	//사용자 변호는 1개
	private Lotto user = new Lotto();
	
	private int st = 0; //회차 값
	
	public void createLotto(Scanner scan) {
		// 수동 로또번호 입력
		System.out.println("로또번호입력(중복X, 1~45, 숫자6개)>");
		int tmp[] = new int[6];
		for(int i=0; i<tmp.length; i++) {
			tmp[i] = scan.nextInt();
		}
		if(isDuplicated(tmp)) {
			System.out.println("오류발생. 다시입력하세요!!");
		}else {
			user.insertNumbers(tmp);
			user.st = this.st+1;
			System.out.println(user);
		}		
	}
	
	//수동으로 입력되는 로또번호의 중복체크, 범위체크
	public boolean isDuplicated(int arr[]) {
		//중복확인
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		
		//범위확인
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<0 || arr[i]>45) {
				return true;
			}
		}
		return false;
	}

	public void createLottoAuto() {
		// 자동 로또번호 입력
		user.randomLotto();
		user.st = this.st+1;
		System.out.println(user);
	}

	public void insertLotto(Scanner scan) {
		// 당첨번호 수동생성
		System.out.println("당첨번호입력(중복X, 1~45, 숫자7개)>");
		int tmp[] = new int[6];
		
		for(int i=0; i<tmp.length; i++) {
			tmp[i] = scan.nextInt();
		}
		int bonus = scan.nextInt();
		
		if(isDuplicated(tmp)) {
			System.out.println("오류발생. 다시입력하세요!!");
		}else {
			LottoExtend tmpLotto = new LottoExtend();
			tmpLotto.insertNumbers(tmp, bonus);
			this.st++;
			tmpLotto.st = st;
			lotto[lCount] = tmpLotto;
			lCount++;
			System.out.println(tmpLotto);
		}		
		
	}

	public void checkLotto() {
			// 당첨번호와 유저번호를 체크하여 등수를 출력
		// 사용자번호와 가장 마지막 당첨번호를 확인하여 등수를 출력
		if(user.isContain(0)) { //모든 값이 다 채워지지 않았거나 하나도 채워지지 않을경우
			System.out.println("체크할 번호가 없습니다.");
			return;
		}
		//당첨번호가 없을 경우
		if(lCount==0) {
			System.out.println("당첨번호가 없습니다.");
			return;
		}
		int cnt = 0;
		//가장 마지막 당첨번호 저장
		LottoExtend tmp = lotto[lCount-1];
		
		//회차 일치여부 확인
		if(tmp.getSt() != user.getSt()) {
			System.out.println("회차가 맞지 않습니다.!!");
			return;
		}
		
		//for문으로 일치하는 개수 확인
		for(int i=0; i<user.getNumbers().length; i++) {
			int num = tmp.getNumbers()[i];
			if(user.isContain(num)) {
				cnt++;
			}
		}
		int rank = -1;
		switch(cnt) {
		case 6: rank = 1; break;
		case 5: 
			if(user.isContain(tmp.getBonus())) {
				rank = 2;
			}else {
				rank = 3;
			}
			break;
		case 4: rank = 4; break;
		case 3: rank = 5; break;
		default:
			System.out.println("꽝~!!");
		}
		if(rank != -1) {
			System.out.println(rank+"등 당첨~!!");			
		}
		
	}

	public void printLotto() {
		// 역대 당첨번호 리스트 확인
		System.out.println("--당첨번호리스트--");
		for(int i=0; i<lCount; i++) {
			System.out.println(lotto[i]);
		}
		
	}

}