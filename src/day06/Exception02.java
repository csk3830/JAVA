package day06;

public class Exception02 {

	public static void main(String[] args) {
		// ArithmeticException : 0으로 나누었을 때 발생하는 Exception
		// 1 2 +	1 2  - 		1 2 * 	1 0 / 	1 0 %
		Exception02 ex02 = new Exception02();
		try {
			//예외가 발생할 수 있는 구문 작성
			System.out.println(ex02.calc(1, 2, '+'));
			System.out.println(ex02.calc(1, 2, '-'));
			System.out.println(ex02.calc(1, 2, '*'));
			System.out.println(ex02.calc(1, 0, '/'));
		} catch (Exception e) {
			// 예외 처리 작성
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println(ex02.calc(1, 2, '-'));
		
		
		
		

	}
	// 두 수를 입력받고, 연산자를 입력받아 4칙연산의 결과를 리턴하는 메서드
	// 매개변수 : int num1, int num2, char op
	// return Type : double
	// 예외 발생시키기 : throw new 발생시킬 수 있음.
	// 예외를 발생시키게 되면 메서드 선언부 끝에 throws를 적고, 발생시킨 예외를
	// 반드시 적어줘야 함.
	// throws는 예외적으로 RuntimeException만 생략가능
	// throws : 예외 떠넘기기
	public double calc(int num1, int num2, char op) throws RuntimeException{
		double res = 0;
		
		//연산자가 / % 인경우 num2가 0이면 예외 발생시키기
		if((op=='/' || op=='%') && num2==0) {
			throw new RuntimeException("num2는 0이 될 수 없습니다.");
		}
		switch(op){
			case '+' : res = num1 + num2; break;
			case '-' : res = num1 - num2; break;
			case '*' : res = num1 * num2; break;
			case '/' : res = num1 / num2; break;
			case '%' : res = num1 % num2; break;
			default:
				//예외 발생
				throw new RuntimeException(op+"는 산술연산자가 아닙니다.");
		}
		return res;
	}
	

}
