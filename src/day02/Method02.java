package day02;

public class Method02 {
	// static없이 사칙연산 ( + - * / % ) 각각 메서드 생성
	public int sum(int a, int b) {
		return a+b;
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public int mul(int a, int b) {
		return a*b;
	}
	public void div(int a, int b) {
	    System.out.println(b==0 ? "0으로 나눌 수 없습니다." : a/(double)b);
	}
	public void mod(int a, int b) {
		System.out.println(b==0 ? "0으로 나눌 수 없습니다." : a%b);
	}
	
	public static void main(String[] args) {
		Method02 m = new Method02();
		
		System.out.println(m.sum(101, 20));
		System.out.println(m.sub(101, 20));
		System.out.println(m.mul(101, 20));
		m.div(101, 2);
		m.mod(101,20);
		//div, mod => 나누는 값(b)이 0이면 Exception 발생
		//return 타입이 double Infinity
		
		
	}

}
