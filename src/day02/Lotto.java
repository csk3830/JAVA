package day02;

public class Lotto {

	public static void main(String[] args) {
		/* 로또 번호 생성
		 * */
		
		int lotto[] = new int[7]; //당첨번호
		int user[] = new int[6]; //사용자 로또 번호	
		
		// 당첨 번호, 사용자 번호 생성 
        ranNum(lotto, 7);
        ranNum(user, 6);
        
        // 출력
        System.out.print("당첨번호: ");
        print(lotto);
        System.out.print("사용자 번호: ");
        print(user);
        
        // 등수 확인
        int rank = checkRank(user, lotto);
        System.out.println( rank==0 ? "꽝" : ("당첨 등수: " + rank + "등"));

	}
	/* 배열을 매개변수로 받아 1~45까지의 랜덤수를 채워서 생성 (중복불가능 - 메서드 호출로 구현)
	 * 리턴할 필요가 없음. main에 있는 배열을 채우기.
	 */
	public static void ranNum(int[] arr, int cnt) {
      
        for (int i=0;i<cnt;i++) {
            int randomNum=0;
            do {
                randomNum = (int)(Math.random()*10)+1;
            } while (isNum(arr, randomNum, i));
            arr[i] = randomNum;
        }
    }
	
	/* 배열과 값을 주고 같은지 아닌지 확인하는 메서드
	 * 배열에 값이 있으면 true / 없으면 false
	 */
	public static boolean isNum(int[] arr, int num, int len) {
        for (int i=0;i<len;i++) {
            if (arr[i]==num) {
                return true; 
            }
        }
        return false;
	}
	
	/* 배열(매개변수)의 값을 출력하는 메서드
	 * 1 2 3 4 5 6 [7] 당첨번호 출력방식
	 * 1 2 3 4 5 6 유저번호 출력방식
	 */
	public static void print(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            if (i == arr.length-1 && arr.length == 7) {
                System.out.print("["+ arr[i] + "]"); 
            } else {
                System.out.print(arr[i]);
                if (i<arr.length-1) {
                    System.out.print(" "); 
                }
            }
        }
        System.out.println(); 
    }


	/* 등수확인 메서드
	 * --당첨기준
	 * user번호 기준으로
	 * 6개 일치 : 1등
	 * 5개 일치 + 보너스 번호 : 2등
	 * 5개 일치 : 3등
	 * 4개 일치 : 4등
	 * 3개 일치 : 5등
	 * 나머지는 꽝
	 */
	public static int checkRank(int[] user, int[] lotto) {
		int matchCount = 0;

	    for (int i=0;i<user.length;i++) {
	        if (isNum(lotto, user[i], lotto.length - 1)) { 
	            matchCount++;
	        }
	    }

	    // 보너스 번호 확인
	    boolean bonus = isNum(lotto, user[user.length-1], lotto.length); 

	    if (matchCount==6) {
	        return 1;
	    } else if (matchCount==5 && bonus) {
	        return 2;
	    } else if (matchCount==5) {
	        return 3; 
	    } else if (matchCount==4) {
	        return 4; 
	    } else if (matchCount==3) {
	        return 5; 
	    } else {
	        return 0; 
	    }
    }


}
