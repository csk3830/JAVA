package lotto;

import java.util.Arrays;
import java.util.Random;   

//로또 번호 만들어서 찍어내는 것 까지. 중복제거 포함.
public class Lotto {
	// 나도 쓰지만 상속 해줘야 함.
	protected int numbers[] = new int[6]; // 사용자번호+당첨번호 같이 사용하는 배열
	protected int st; // 회차
	
	protected int random() {
		return new Random().nextInt(45)+1; 
	}
	
	// 1. 랜덤번호 6개를 numbers[]에 채우는 메서드 (중복제거)
	protected void randomLotto() {
		//배열초기화
		init();
		int cnt = 0;
		while(cnt<numbers.length) {
			int r = random();  // Random() => Math.random() 같은 효과
			if(isContain(r)) {
				numbers[cnt] = r;
				cnt++;
			}
		}
		
	}
	
	// 2. 중복제거 메서드 중복이 있으면 true / false (범위 체크도 같이)
	protected boolean isContain(int num) {
		if(num <0 || num >45) {
			// 오류발생
			throw new RuntimeException("숫자의 범위는 1~45 입니다.");
		}
		for(int tmp:numbers) {
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}
	
	// 3. 배열초기화
	protected void init() {
		numbers = new int[6]; 	//기존 배열 버리고 새배열로 추가
	}
	
	// 4. 번호 수동생성
	//(수동생성된 번호(이미 중복제거 확인 후 넘어오는 배열)를 numbers[]에 배열복사)
	protected void insertNumbers(int arr[]) {
		if(arr.length > numbers.length) { // 7자리는 허용
			throw new RuntimeException("배열의 길이를 확인하세요.");
		}
		// 만약 7자리의 값을 가져오면 마지막 1자리를 버리겠따.
		System.arraycopy(arr, 0, numbers, 0, numbers.length);
	}
	
	// 5. 번호확인메서드 => toString()
	@Override
	public String toString() {
		return st + "회차 " + Arrays.toString(numbers);
	}
	
	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	public int getSt() {
		return st;
	}
	public void setSt(int st) {
		this.st = st;
	}
	
	
	
//	private int round;
//	private int[] nums;
//
//	public Lotto(int round) {
//		this.round = round;
//		this.nums = new int[6];
//	}
//
//	public void createAutoNum(){
//		int cnt = 0;
//		while (cnt < 6) {
//            int num = (int)(Math.random()*45)+1;
//            if (!isNum(num, cnt)) {
//                nums[cnt] = num;
//                cnt++;
//            }
//        }
//	}
//	
//	public void createHandNum(Scanner scan) {
//        int cnt = 0;
//        
//        while (cnt<6) {
//            System.out.print("로또 번호 입력 (1~45) > ");
//            int num = scan.nextInt();
//
//            if (checkNum(num)) {
//                if (!isNum(num, cnt)) {
//                    nums[cnt] = num;
//                    cnt++;
//                } else {
//                    System.out.println(num + ": 중복된 번호!");
//                }
//            } else {
//                System.out.println("번호의 범위는 1~45 입니다.");
//            }
//        }
//	}
//	
//	private boolean checkNum(int num) {
//        return num>=1 && num<=45;
//    }
//	
//	private boolean isNum(int num, int count) {
//        for (int i=0; i<count; i++) {
//            if (nums[i] == num) {
//                return true; 
//            }
//        }
//        return false;
//    }
//	
//	public int checkRank(int[] user) {
//		int cnt = 0;
//		
//		for (int i=0; i<user.length-1; i++) {
//            if (isNum(user[i], 6)) { 
//            	cnt++; 
//            }
//        }
//		
//		boolean bonus = isNum(user[user.length - 1], 6); 
//
//	    if (cnt==6) {
//	    	return 1;
//	    } else if(cnt==5 && bonus) {
//	    	return 2;
//	    } else if(cnt==5) {
//	    	return 3;
//	    } else if(cnt==4) {
//	    	return 4;
//	    } else if(cnt==3) {
//	    	return 5;
//	    } else {
//	    	return 0;
//	    }
//    }
//	
//	
//	@Override
//	public String toString() {
//		return "Lotto [round=" + round + ", nums=" + Arrays.toString(nums) + "]";
//	}
//
//	public int getRound() {
//		return round;
//	}
//
//	public void setRound(int round) {
//		this.round = round;
//	}
//
//	public int[] getNums() {
//		return nums;
//	}
//
//	public void setNums(int[] nums) {
//		this.nums = nums;
//	}


}
