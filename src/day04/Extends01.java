package day04;

class A{
	private int a, b, c; // 나만 사용가능
	protected int num1; // 상속가능
	
	public void print() {
		System.out.println("a:"+a+", b:"+b+", c:"+c);
		System.out.println("num1:"+num1);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}
	
	
}


class B extends A{
	private int d,e,f;

	// 오버라이드(override) : 부모의 메서드를 재정의하여 사용하는 것
	// super : 부모의 멤버값을 가져올 때 사용하는 키워드
	// 마우스 우클릭=> Source => Override/Implement Methods... 
	@Override
	public void print() {
		super.print(); 	//부모의 print() 메서드를 호출하여 가져오기
		System.out.println("d:"+d+", e:"+e+", f:"+f);
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}
	
	
	
	
}





public class Extends01 {

	public static void main(String[] args) {
		/* 상속(Inheritance) : 부모 클래스의 멤버 요소를 자식이 물려받는 것.
		 * 멤버 요소 : private, 멤버변수, 메서드 사용 가능. private는 상속 안됨.
		 * 상속받는 부모클래스가 다른 패키지에 있다면 default도 상속 대상이 안됨.
		 * public / protected 잡근제한자만 가능.
		 * 
		 * 상속 키워드 : extends
		 * 상속은 1개만 가능. 다음 상속을 허용하지 않음.
		 * class class명 = extends 부모님Class명 {
		 * 	// 본인의 멤버와 메서드 구현 가능.
		 * 
		 * }
 		 * */

		A a = new A(); 	// 부모 클래스의 객체 생성
		a.setA(10);
		a.setB(20);
		a.setC(30);
		a.setNum1(100);
		a.print();
		
		System.out.println("--------------");
		
		B b = new B();
		b.setA(100);
		b.setB(200);
		b.setC(300);
		b.num1 = 1000; 	// 접근제한자가 protected라서 직접 접근 가능.
		b.setD(10);
		b.setE(20);
		b.setF(30);
		b.print();
		
		
		
		
		
		
		
	}

}
