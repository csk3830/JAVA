package day07;

import java.util.Random;

public class ExceptionEx01 {

	public static void main(String[] args) {
		// 리턴 받은 배열을 출력
		try {
            int size = -1; 
            int start = 1; 
            int count = 10; 
            int[] arr = createArr(size, start, count);
            for (int num : arr) {
                System.out.print(num+" ");
            }
        } catch (RuntimeException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }

	}

	/*
	 * 메서드 생성 기능 : size를 입력받아(매개변수) size 만큼의 길이를 가지는 배열을 생성하여 랜덤값을 채워 배열을 리턴 랜덤값은
	 * 범위를 매개변수를 받아 start(시작값), count(개수) - size가 0보다 작으면 예외발생 - 랜덤값의 개수가 0이면 예외발생
	 */

	/*
	 * 메서드 기능 : 매개변수로 배열을 받아 랜덤값을 채우는 메서드 랜덤값은 범위를 매개변수를 받아 start(시작값), count(개수) -
	 * 랜덤값의 개수가 0이면 예외발생 - 배열이 null이면 예외 발생 - 배열의 길이가 0보다 작으면 예외발생
	 */

	public static int createRanNum(int start, int count) {
		return new Random().nextInt(count)+start;
	}

	public static int[] createArr(int size, int start, int count) {
		if (size < 0) {
			throw new RuntimeException("size가 0보다 작습니다.");
		}
		if (count <= 0) {
			throw new RuntimeException("랜덤값의 개수가 0입니다.");
		}
		int arr[] = new int[size];
		fillArrRanNum(arr, start, count);
		return arr;
	}

	public static void fillArrRanNum(int[] arr, int start, int count) {
		if(arr==null) {
			throw new RuntimeException("배열이 null입니다.");
		}
		if(arr.length<0) {
			throw new RuntimeException("배열의 길이가 0보다 작습니다.");
		}
		if(count<=0) {
			throw new RuntimeException("랜덤값의 개수가 0입니다.");
		}

		for (int i=0; i<arr.length; i++) {
			//RuntimeException이 아닌 Checked Exception이었다면 이미 빨간밑줄
			arr[i] = createRanNum(start, count);
		}
	}
}
