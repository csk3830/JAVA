package day06;

public class Exception03 {

	public static void main(String[] args) {
		/* 자주 발생하는 예외 코드들
		 * ArithmeticException : 0으로 나누었을 때 발생
		 * ArrayIndexOutOfBoundsException : 배열의 index가 범위를 벗어났을 때 발생
		 * NullPointerException : 객체의 값이 null일 경우, 혹은 객체 자체가 없을 경우
		 * ClassCastException : 다운 캐스팅이 잘못 되었을 경우
		 * */
		
//		int arr[] = null;
		int arr[] = new int[5];
		for (int i=0; i<=arr.length; i++) {
			System.out.println(arr[i]);
		}

		// Checked Exception과 Unchecked Exception의 차이점 중 중요한 것은
		// 예외 발생시 트랜잭션 처리
		// 체크예외 : 한번 체크를 했기 때문에 롤백이 되지 않고 커밋까지 완료 됨.
		// 언체크 예외 : 롤백이 됨.
	}

}
